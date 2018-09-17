package com.stackroute.payment.service;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.stackroute.payment.Repository.PaymentRepository;
import com.stackroute.payment.domain.TicketDetails;
import com.stripe.Stripe;
import com.stripe.model.Charge;
import com.stripe.model.Refund;

@Component
public class PaymentServiceImpl implements PaymentService {

	private PaymentRepository paymentRepo;

	@Autowired
	PaymentServiceImpl(PaymentRepository paymentRepo) {
		Stripe.apiKey = "sk_test_m91u0Hec19aRB71O6d0d1LbW";
		this.paymentRepo = paymentRepo;
	}

	String chargeId;
	String chargeStatus;

	@Override
	public Charge chargeNewCard(String token, double amount) throws Exception {
		Map<String, Object> chargeParams = new HashMap<String, Object>();
		chargeParams.put("amount", (int) (amount * 100));
		chargeParams.put("currency", "INR");
		chargeParams.put("source", token);
		// RequestOptions options = RequestOptions
		// .builder()
		// .setIdempotencyKey("A1m2a3r4")
		// .build();
		Charge charge = Charge.create(chargeParams);
		chargeId = charge.getId();
		chargeStatus = charge.getStatus();
		System.out.println(charge.getStatus());
		System.out.println(charge.getId());
		System.out.println(charge);
		return charge;
	}

	@Override
	public Refund cardRefund() throws Exception {
		Map<String, Object> refundParams = new HashMap<String, Object>();
		refundParams.put("charge", chargeId);
		Refund refund = Refund.create(refundParams);
		return refund;

	}

	@Override
	public TicketDetails saveTicket(TicketDetails ticket) {
		ticket.setBookingStatus(chargeStatus);
		TicketDetails saveTicket = paymentRepo.save(ticket);
		return saveTicket;
	}

}
