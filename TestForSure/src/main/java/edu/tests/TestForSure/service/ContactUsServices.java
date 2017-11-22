package edu.tests.TestForSure.service;

import java.util.Properties;

import javax.mail.Authenticator;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import edu.tests.TestForSure.datalayer.ContactUsDAO;
import edu.tests.TestForSure.entity.ContactUs;
import edu.tests.TestForSure.response.CommonResponse;

@CrossOrigin
@RestController
@RequestMapping("/test-for-sure/contact-us")
public class ContactUsServices {
	
	@RequestMapping(method = {RequestMethod.POST}, value = "/insert-query")
	public CommonResponse getAllNews(@RequestBody ContactUs obj){
		System.out.println("Calling insert contact us query service");
		CommonResponse response = null;
		try{
			response = ContactUsDAO.insertQueryDAO(obj);
			
			//Send e-mail to the admin whenever a new query in contact us comes
			//Set these in configuration
			final String fromEmail = System.getenv("FROM_EMAIL");//requires valid gmail id
			final String password = System.getenv("FROM_PASSWORD"); // correct password for gmail id
			//System.out.println("fromEMail: "+fromEmail);
			//System.out.println("password: "+password);
			final String toEmail = System.getenv("TO_EMAIL"); // can be any email id 
			
			Properties props = new Properties();
			props.put("mail.smtp.host", "smtp.gmail.com"); //SMTP Host
			props.put("mail.smtp.port", "587"); //TLS Port
			props.put("mail.smtp.auth", "true"); //enable authentication
			props.put("mail.smtp.starttls.enable", "true"); //enable STARTTLS
			
			//create Authenticator object to pass in Session.getInstance argument
			Authenticator auth = new Authenticator() {
				//override the getPasswordAuthentication method
				protected PasswordAuthentication getPasswordAuthentication() {
					return new PasswordAuthentication(fromEmail, password);
				}
			};
			Session session = Session.getInstance(props, auth);
			
			StringBuilder sb = new StringBuilder();
			sb.append("<h3>Username: "+obj.getName()+"</h3></br>");
			sb.append("<h3>Email address: "+obj.getEmail()+"</h3></br>");
			sb.append("<h4>Query: "+obj.getQuery()+"</h4></br>");
			sb.append("<p>Thanks,</p></br>");
			sb.append("<p>TEST Team</p>");
			
			System.out.println("html: "+sb.toString());
			String body = sb.toString();
			GeneralFunctionality.sendEmail(session, toEmail,"Contact Us Query", body);
		}
		catch(Exception e){
			System.out.println("Exception in getAllNews service: "+e.getMessage());
		}
		return response;
	}
}
