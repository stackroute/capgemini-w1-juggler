package com.stackroute.juggler.emailservice.service;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;
import org.thymeleaf.context.Context;
import org.thymeleaf.spring5.SpringTemplateEngine;

import com.stackroute.juggler.emailservice.EmailserviceApplication;
import com.stackroute.juggler.emailservice.domain.EmailDetails;
import com.stackroute.juggler.rsvp.domain.EventDetails;

@Service
public class NotificationService {
	private JavaMailSender javaMailSender;
	private SpringTemplateEngine templateEngine;

	@Autowired
	public NotificationService(JavaMailSender javaMailSender, SpringTemplateEngine templateEngine) {
		super();
		this.javaMailSender = javaMailSender;
		this.templateEngine = templateEngine;
	}

	EmailDetails emailDetails = new EmailDetails();
	String emailBody;
	
String url="www.google.co.in";
	@KafkaListener(topics = "eventdetails1", groupId = "event")
	public void getEventDetails(EventDetails event) {
		System.out.println("geteventdetails");
		emailDetails.setToEmailId(event.getInvitiesMail());
		emailDetails.setBody(event.getEventSynopsis());
		System.out.println(emailDetails.toString());
		
	}

	public void sendNotification() throws MessagingException {

//		Context context = new Context();
//		context.setVariable("eventSynopsis", emailDetails.getBody());
//        String html = templateEngine.process("mailtemplate", context);
//		System.out.println("service1");
//		SimpleMailMessage mail= new SimpleMailMessage();
//		System.out.println("service2");
//		mail.setTo(emailDetails.getToEmailId());
//		System.out.println("service3");
//		mail.setCc(emailDetails.getEmailCc());
//		mail.setSubject("Event Invitation");
//		mail.setText(html);
//		System.out.println(mail);
//		System.out.println("before sending");
//		javaMailSender.send(mail);
//		System.out.println("sent");
		MimeMessage message = javaMailSender.createMimeMessage();
		MimeMessageHelper helper = new MimeMessageHelper(message, true);

		helper.setTo(emailDetails.getToEmailId());
		helper.setSubject("Event Invitation");
		this.emailBody = "Hi," + emailDetails.getBody();
		helper.setText("<html><head><body> <h3>Hi,</h3><p>"+ emailBody +"</p> <a>"+ url +"</a><div>\n"
				+ "        <button mat-button matStepperPrevious>Accept</button><button mat-button matStepperPrevious>Decline</button></body></head></html>",
				true);
		System.out.println(message.toString());
		javaMailSender.send(message);
	}

}
