package com.stackroute.payment.controller;

import org.apache.catalina.servlet4preview.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.stackroute.payment.domain.TicketDetails;
import com.stackroute.payment.service.PaymentServiceImpl;
import com.stripe.model.Charge;
import com.stripe.model.Refund;

@CrossOrigin("*")
@RestController
@RequestMapping("/api/v1/payment")
public class PaymentController {
	
	private PaymentServiceImpl stripeClient;

	@Autowired
	PaymentController(PaymentServiceImpl stripeClient) {
		this.stripeClient = stripeClient;
	}

	@PostMapping("/charge")
	public Charge chargeCard(HttpServletRequest request) throws Exception {
		String token = request.getHeader("token");
		Double amount = Double.parseDouble(request.getHeader("amount"));
		return this.stripeClient.chargeNewCard(token, amount);
	}

	@PostMapping("/refund")
	public Refund refundCard(HttpServletRequest request) throws Exception {
		// String token = request.getHeader("token");
		// Double amount = Double.parseDouble(request.getHeader("amount"));
		return this.stripeClient.cardRefund();
	}
	
	@PostMapping("/ticket")
	public ResponseEntity<?> saveTicketHandler(@RequestBody TicketDetails ticket) {
		TicketDetails saveTicket = stripeClient.saveTicket(ticket);
		return new ResponseEntity<TicketDetails>(saveTicket, HttpStatus.OK);
		
	}
	
}
