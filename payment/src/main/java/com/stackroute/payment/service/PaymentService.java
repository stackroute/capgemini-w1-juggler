package com.stackroute.payment.service;

import com.stackroute.kafka.domain.TicketDetails;
import com.stripe.exception.CardException;
import com.stripe.model.Charge;
import com.stripe.model.Refund;

public interface PaymentService {
	
	public Charge chargeNewCard(String token, double amount)throws CardException;
	
	public Refund cardRefund() throws Exception;
	
	public TicketDetails saveTicket(TicketDetails ticket);

}
