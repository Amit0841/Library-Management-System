package com.masai.controller;

import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.masai.model.Mail;
import com.masai.service.EmailService;



@RestController
@CrossOrigin(origins = "*")
public class MailSenderController {
	@Autowired
	private EmailService EService;
	
	// Endpoint : http://localhost:8080/mail?email= YourMailId
@PostMapping("/mail")
	public ResponseEntity<Mail> sendEmail(@RequestParam String email) {
	 Random random = new Random();
     int min = 1000; 
     int max = 9999; 
     int randomNumber = random.nextInt(max - min + 1) + min;
     String body="Thank you for taking the time to verify your email with us. To complete the verification process, please use the following four-digit verification CODE : "+randomNumber+". \n \n";
     String body2="Please enter this code in the designated field on the verification page to confirm and activate your email account. If you did not initiate this verification process, please disregard this email.";
		EService.sendEmail(email, "Email Verification Code", body+" "+body2+"\n \n Thank you for choosing our service.");
		 System.out.println("email send");
		 Mail mail=new Mail(randomNumber-1,randomNumber);
		return new ResponseEntity<Mail>(mail,HttpStatus.ACCEPTED);
	}
}
