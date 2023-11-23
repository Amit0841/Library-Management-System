package com.masai.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
public class EmailService {
	@Autowired
private JavaMailSender mailSender;
	
public void sendEmail(String toEmail,String sub, String body) {
	
SimpleMailMessage message=new SimpleMailMessage();

message.setFrom("coursejava27@gmail.com");
message.setTo(toEmail);
message.setText(body);
message.setSubject(sub);
mailSender.send(message);
System.out.println("send success");
}
}
