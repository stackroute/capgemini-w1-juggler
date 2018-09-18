package com.stackroute.payment.service;

import com.stackroute.payment.domain.TicketDetails;
import com.stripe.model.Charge;
import com.stripe.model.Refund;

public interface PaymentService {
	
	public Charge chargeNewCard(String token, double amount) throws Exception;
	
	public Refund cardRefund() throws Exception;
	
	public TicketDetails saveTicket(TicketDetails ticket);

}
