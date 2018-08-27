package com.stackroute.juggler.theatreregistration.services;

import com.stackroute.juggler.kafka.domain.Registration;
import com.stackroute.juggler.theatreregistration.exceptions.TheatreAlreadyExists;

//interface to define methods that service should support 
public interface RegistrationService {

	// To save the theatre details
	public Registration saveTheatre(Registration theatre) throws TheatreAlreadyExists;

	// To update the theatre details
	public Registration updateTheatre(Registration theatre);

	// To get the theatre by using theatre-title from database
	public Registration getByTitle(String searchTerm);

}