package com.stackroute.juggler.emailservice.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import com.stackroute.juggler.emailservice.domain.EmailDetails;

@Service
public class NotificationService {
	private JavaMailSender javaMailSender;
@Autowired
	public NotificationService(JavaMailSender javaMailSender) {
		super();
		this.javaMailSender = javaMailSender;
	}
	public void sendNotification(EmailDetails emailDetails) {
		System.out.println("service1");
		SimpleMailMessage mail= new SimpleMailMessage();
		System.out.println("service2");
		mail.setTo(emailDetails.getToEmailId());
		System.out.println("service3");
		mail.setCc(emailDetails.getEmailCc());
		mail.setSubject(emailDetails.getSubject());
		mail.setText(emailDetails.getBody());
		System.out.println(mail);
		javaMailSender.send(mail);
		System.out.println("sent");
	}
}
