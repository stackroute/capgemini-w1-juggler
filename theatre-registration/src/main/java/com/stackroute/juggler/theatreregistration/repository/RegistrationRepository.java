package com.stackroute.juggler.theatreregistration.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.stackroute.juggler.kafka.domain.Registration;

//Repository to perform operations on database
@Repository
public interface RegistrationRepository extends CrudRepository<Registration, Integer> {

	// get the theatre details by theatre-name from database
	public Registration getByTheatreName(String theatreTitle);

	// checks if the theatre with that particular name exists or not
	public boolean existsByTheatreName(String theatreName);

}
