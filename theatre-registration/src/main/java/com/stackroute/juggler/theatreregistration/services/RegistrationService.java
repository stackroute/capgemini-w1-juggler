package com.stackroute.juggler.theatreregistration.services;

import com.stackroute.juggler.kafka.domain.Theatre;
import com.stackroute.juggler.theatreregistration.exceptions.TheatreAlreadyExists;

//interface to define methods that service should support 
public interface RegistrationService {

	// To save the theatre details
	public Theatre saveTheatre(Theatre theatre) throws TheatreAlreadyExists;

	// To update the theatre details
	public Theatre updateTheatre(Theatre theatre);

	// To get the theatre by using theatre-title from database
	public Theatre getByTitle(String searchTerm);

}