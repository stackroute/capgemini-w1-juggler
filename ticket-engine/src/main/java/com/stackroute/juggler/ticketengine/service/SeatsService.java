package com.stackroute.juggler.ticketengine.service;

import java.util.List;
import java.util.Optional;

import com.stackroute.juggler.ticketengine.domain.Seats;

public interface SeatsService {
	
	public Seats save(Seats seats);
	
	public Seats update(Seats seats);
	
	public Optional<Seats> getById(String id);
	
	public void delete(String id);

	public List<Seats> getAll();
	
	public void removeAll();
	
	public Optional<Seats> getByName(String name);
	
}

