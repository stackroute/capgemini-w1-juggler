package com.stackroute.juggler.ticketengine.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/ticket")
public class TicketController {

	@GetMapping("/")
	public String message() {
		System.out.println("Hai.....Welcome");
		return "Hello....it's working";
	}
	
}
