package com.stackroute.juggler.theatreregistration.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.stackroute.juggler.theatreregistration.domain.Registration;
		
@Repository
public interface RegistrationRepository extends CrudRepository<Registration,Integer> {

	 public Registration getByTheatreName(String theatreTitle);

	}





