package com.xoriant.enrollmentapplication.service;

public interface EmailService {
	
	public void sendMail(String toEmail, String Subject, String body);
}
