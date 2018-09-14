package com.stackroute.juggler.emailservice.controller;

import javax.mail.MessagingException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.stackroute.juggler.emailservice.domain.EmailDetails;
import com.stackroute.juggler.emailservice.service.NotificationService;

@RestController
@RequestMapping("/api/v1/email")
public class EmailServiceController {
	
	
	private NotificationService notificationService;
	@Autowired
public EmailServiceController(NotificationService notificationService) {
		super();
		this.notificationService = notificationService;
	}

//String[] mailIds= {"jyothirmayee.24.6.1997@gmail.com"};
//mailIds[0]="jyothirmayee.24.6.1997@gmail.com";
@PostMapping("/sendEmail")
public String sendInvitations(@RequestBody EmailDetails emailDetails) throws MessagingException {
	System.out.println("controller1");
		notificationService.sendNotification(emailDetails);
		System.out.println("controller2");
return "Thank you for registering";
	
}

}
