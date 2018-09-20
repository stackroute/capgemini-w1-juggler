package com.stackroute.juggler.ticketengine.service;

import java.util.Optional;

import com.stackroute.juggler.kafka.domain.MovieSchedule;
import com.stackroute.juggler.ticketengine.domain.Seats;

public interface SeatsService {
	
	public Seats save(Seats seats);
	
	public Seats update(Seats seats);
	
	public Optional<Seats> getById(String id);
	
	public void delete(String id);

	public Iterable<Seats> getAll();
	
	public void removeAll();
	
	public void kafkaListen(MovieSchedule mveSchedule);
	
}

