package com.stackroute.juggler.ticketengine.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.stackroute.juggler.ticketengine.domain.Seat;

@Repository
public interface SeatsRepository extends CrudRepository<Seat, String>{
	
	public List<Seat> findAll();
	
}


