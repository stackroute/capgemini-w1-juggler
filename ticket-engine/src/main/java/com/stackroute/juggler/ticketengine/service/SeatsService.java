package com.stackroute.juggler.ticketengine.service;

import java.text.ParseException;

import com.stackroute.juggler.kafka.domain.MovieSchedule;
import com.stackroute.juggler.ticketengine.domain.Seat;

public interface SeatsService {

	public void getDetails(MovieSchedule movieSchedule) throws ParseException;

	public Seat save(Seat seat);
	
	public Seat findById(String showId);	
	
}

