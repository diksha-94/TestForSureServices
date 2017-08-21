package edu.tests.TestForSure.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Component;

@Component
public class TestEmail{
	
	    @Autowired
	    public static JavaMailSender emailSender;
	 
	    public static void sendSimpleMessage(
	      String to, String subject, String text) {
	        System.out.println("to: "+to);
	        System.out.println("subject: "+subject);
	        System.out.println("text: "+text);
	        SimpleMailMessage message = new SimpleMailMessage(); 
	        message.setTo(to); 
	        message.setSubject(subject); 
	        message.setText(text);
	        emailSender.send(message);
	        
	    }
}
