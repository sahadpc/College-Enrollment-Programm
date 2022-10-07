package com.xoriant.enrollmentapplication.service;


import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;

@Service
public class EmailServiceImpl implements EmailService{
	
	@Autowired
	JavaMailSender mailSender;

	@Override
	public void sendMail(String toEmail, String Subject, String body) {
		
		SimpleMailMessage message = new SimpleMailMessage();
		message.setFrom("shamilmuhyin@gmail.com");
		message.setTo(toEmail);
		message.setText(body);
		message.setSubject(Subject);
		
		mailSender.send(message);
	}

}
