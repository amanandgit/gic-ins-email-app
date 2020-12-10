package com.cts.gic.email.service;

import java.util.Properties;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class SendEmailService {
	
	@Autowired
	private JavaMailSender javaMailSender;
	
	public String sendEmailReport(String emailList, String url) {
		System.out.println("inside controller...");
		run(emailList, url);
		return "Email Sent !!";
	}
	
	public void run(String emailList, String url) {
		System.out.println("Sending Email...");
	
		Session session = createEmailSession();

		try {
	
	        Message message = new MimeMessage(session);
	        message.setFrom(new InternetAddress("amanand92@gmail.com"));
	        message.setRecipients(
	                Message.RecipientType.TO,
	                InternetAddress.parse(emailList)
	        );
	        
	        message.setSubject("GIC LM Insurance Mail");
	        message.setText("Dear Customer,"
	        		+ "\n\n Greetings of the Day!"
	                + "\n\n Thank you for choosing Liberty Mutual as you Insurance partner!"
	                + "\n\n We have special offers for you to cater your insurance needs."
	                + "\n Please find the below link: "
	                + "\n https://onecognizant.cognizant.com/"
	                + "\n\n Thanks !!"
	                + "\n F&C INS Team");
	
	       Transport.send(message);
	
	        System.out.println("Done");
	
	    } catch (MessagingException e) {
	        e.printStackTrace();
	    }
	}

	private Session createEmailSession() {
		final String username = "";//add email
		final String password = "";// add password

		Properties prop = new Properties();
		prop.put("mail.smtp.host", "smtp.gmail.com");
		prop.put("mail.smtp.port", "587");
		prop.put("mail.smtp.auth", "true");
		prop.put("mail.smtp.starttls.enable", "true"); //TLS
		
		Session session = Session.getInstance(prop,
		        new javax.mail.Authenticator() {
		            protected PasswordAuthentication getPasswordAuthentication() {
		                return new PasswordAuthentication(username, password);
		            }
		        });
		return session;
	}

}
