package edu.tests.TestForSure.service;

import java.io.File;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Properties;

import javax.mail.Authenticator;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;

import org.apache.tomcat.util.http.fileupload.FileUtils;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import edu.tests.TestForSure.datalayer.TestDAO;
import edu.tests.TestForSure.datalayer.UserDAO;
import edu.tests.TestForSure.entity.AuthenticateUserRequest;
import edu.tests.TestForSure.entity.RegisterUserRequest;
import edu.tests.TestForSure.entity.User;
import edu.tests.TestForSure.entity.UserCreds;
import edu.tests.TestForSure.response.CommonResponse;
import edu.tests.TestForSure.response.LoginUserResponse;

@CrossOrigin
@RestController
@RequestMapping("/test-for-sure/user")
public class UserServices {

	@RequestMapping(method = {RequestMethod.POST}, value = "/register-user")
	public LoginUserResponse registerUser(@RequestBody RegisterUserRequest request){
		System.out.println("Calling register user service");;
		LoginUserResponse response = new LoginUserResponse();
		CommonResponse res = null;
		User user = new User();
		user.setId(request.getUserDetails().getId());
		user.setName(request.getUserDetails().getName());
		user.setEmail(request.getUserDetails().getEmail());
		user.setMobileno(request.getUserDetails().getMobileno());
		
		String encryptedPassword = PasswordEncryption.encryptPassword(request.getPassword());
		if(encryptedPassword.equals("exception")){
			res = new CommonResponse(false, "Error in encrypting password");
			response.setResponse(res);
			return response;
		}
		UserCreds userCreds = new UserCreds();
		userCreds.setUserId(request.getUserDetails().getId());
		userCreds.setPassword(encryptedPassword);
		try{
			response = UserDAO.registerUserDAO(user, userCreds);
			response.setUsername(user.getName());
		}
		catch(Exception e){
			System.out.println("Exception in service: "+e.getMessage());
		}
		return response;
	}
	
	@RequestMapping(method = {RequestMethod.POST}, value = "/authenticate-user")
	public LoginUserResponse authenticateUser(@RequestBody AuthenticateUserRequest request){
		System.out.println("Calling authenticate user service");;
		LoginUserResponse sendResponse = new LoginUserResponse();
		CommonResponse res = null;
		try{
			LoginUserResponse response = UserDAO.authenticateUserDAO(request.getEmail());
			sendResponse.setUsername(response.getUsername());
			System.out.println(response);
			System.out.println("Password: "+(PasswordEncryption.encryptPassword(request.getPassword())));
			String password = (PasswordEncryption.encryptPassword(request.getPassword()));
			if(response.getResponse().getStatus()){
				if(password.equals(response.getPassword())){
					System.out.println("Inside equals");
					res = new CommonResponse(true, "User authenticated successfully");
					sendResponse.setResponse(res);
				}
				else{
					System.out.println("Inside not equal");
					res = new CommonResponse(false, "Email/Password is incorrect");
					sendResponse.setResponse(res);
				}
			}
			else{
				sendResponse = response;
			}
		}
		catch(Exception e){
			System.out.println("Exception in service: "+e.getMessage());
		}
		return sendResponse;
	}
	
	@RequestMapping(method = {RequestMethod.POST}, value = "/forgot-password")
	public CommonResponse forgotPasswordClick( @RequestParam(value = "emailId", required = true) String emailId){
		System.out.println("Calling forgot password click");
		CommonResponse response = null;
		String registeredId = "";
		String currentPassword = "";
		try{
			response = UserDAO.checkEmailExists(emailId);
			if(response.getStatus()){
				//User exists, then send the email to this registered user to reset the password
				registeredId = response.getMessage();
				
				response = UserDAO.getCurretPassword(registeredId);
				if(response.getStatus()){
					currentPassword = response.getMessage();
				
					//Set these in configuration
					final String fromEmail = System.getenv("FROM_EMAIL"); //requires valid gmail id
					final String password = System.getenv("FROM_PASSWORD"); // correct password for gmail id
					final String toEmail = emailId; // can be any email id 
					
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
					String link = "file:///C:/MyGit/Test-for-sure-app/User%20Interface/TestForSureUI/WebContent/html/PasswordReset.html?userId="+registeredId+"&pass="+currentPassword;
					
					StringBuilder sb = new StringBuilder();
					sb.append("<h4>Greetings!!</h4></br>");
					sb.append("<p>Below is the link to reset password for your account</p></br>");
					sb.append("<a href='"+link+"'>"+link+"</a></br></br>");
					sb.append("<p>Thanks,</p></br>");
					sb.append("<p>TEST Team</p>");
					
					System.out.println("html: "+sb.toString());
					String body = sb.toString();
					GeneralFunctionality.sendEmail(session, toEmail,"TEST Password Reset Link", body);
				}
				else{
					return response;
				}
			}
			else{
				//User doesn' exist
				return response;
			}
		}
		catch(Exception e){
			System.out.println("Exception in service: "+e.getMessage()+"  "+e.getStackTrace()+"  "+e.getCause());
		}
		return response;
	}
	
	
	@RequestMapping(method = {RequestMethod.POST}, value = "/update-password")
	public CommonResponse updatePassword( @RequestBody AuthenticateUserRequest request){
		System.out.println("Calling update password");
		CommonResponse response = null;
		try{
			String encryptedPassword = PasswordEncryption.encryptPassword(request.getPassword());
			if(encryptedPassword.equals("exception")){
				response = new CommonResponse(false, "Error in encrypting password");
				return response;
			}
			response = UserDAO.checkIfPasswordIsSame(request.getEmail(), encryptedPassword);
			if(response.getStatus()){
				//Password is different from the old one
				
			    response = UserDAO.updatePassword(request.getEmail(), encryptedPassword);
				return response;
			}
			else{
				//Password is same as the old one
				return response;
			}
		}
		catch(Exception e){
			System.out.println("Exception in service: "+e.getMessage());
		}
		return response;
	}
	
	//This service is to test whether the reset password link is still valid or not-means clicked for the first time or not
	@RequestMapping(method = {RequestMethod.POST}, value = "/get-current-password")
	public CommonResponse getCurrentPassword( @RequestParam(value = "emailId", required = true) String emailId){
		System.out.println("Calling forgot password click");
		CommonResponse response = null;
		try{
			response = UserDAO.getCurretPassword(emailId);
		}
		catch(Exception e){
			System.out.println("Exception in service: "+e.getMessage());
		}
		return response;
	}
}
