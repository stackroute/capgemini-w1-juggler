package com.stackroute.juggler.theatreregistration.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.stackroute.juggler.kafka.domain.Registration;
		
@Repository
public interface RegistrationRepository extends CrudRepository<Registration,Integer> {

	 public Registration getByTheatreName(String theatreTitle);

	
//	@Query("db.registration.find( { theatreName : <theatreName> } )")
	public boolean existsByTheatreName(String theatreName);

}

