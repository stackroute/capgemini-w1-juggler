package com.stackroute.juggler.ticketengine.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.stackroute.juggler.ticketengine.domain.Seats;

@Repository
public interface SeatsRepository extends CrudRepository<Seats, String>{

}


