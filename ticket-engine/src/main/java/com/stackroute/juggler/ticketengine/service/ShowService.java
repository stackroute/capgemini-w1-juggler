package com.stackroute.juggler.ticketengine.service;

import com.stackroute.juggler.kafka.domain.TicketDetails;
import com.stackroute.juggler.ticketengine.domain.Show;

public interface ShowService {

	public Show getById(String showId);
	
	public void getBookedSeats(TicketDetails ticketDetails);
	
}
