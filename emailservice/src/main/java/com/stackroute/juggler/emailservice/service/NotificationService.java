package com.stackroute.juggler.emailservice.service;

import java.nio.charset.StandardCharsets;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import org.thymeleaf.TemplateEngine;
import org.thymeleaf.context.Context;
import org.thymeleaf.spring5.SpringTemplateEngine;

import com.stackroute.juggler.emailservice.domain.EmailDetails;

@Service
public class NotificationService {
	private JavaMailSender javaMailSender;
	private SpringTemplateEngine templateEngine;
	@Autowired
	public NotificationService(JavaMailSender javaMailSender, SpringTemplateEngine templateEngine) {
		super();
		this.javaMailSender = javaMailSender;
		this.templateEngine=templateEngine;
	}

	public void sendNotification(EmailDetails emailDetails) throws MessagingException {
	//	MimeMessage message = javaMailSender.createMimeMessage();
	//  MimeMessageHelper helper = new MimeMessageHelper(message,
	//  MimeMessageHelper.MULTIPART_MODE_MIXED_RELATED,
	//  StandardCharsets.UTF_8.name());
		Context context = new Context();
        String html = templateEngine.process("mailtemplate", context);
		System.out.println("service1");
		SimpleMailMessage mail= new SimpleMailMessage();
		System.out.println("service2");
		mail.setTo(emailDetails.getToEmailId());
		System.out.println("service3");
		mail.setCc(emailDetails.getEmailCc());
		mail.setSubject(emailDetails.getSubject());
		mail.setText(html);
		System.out.println(mail);
		javaMailSender.send(mail);
		System.out.println("sent");
	}
}
