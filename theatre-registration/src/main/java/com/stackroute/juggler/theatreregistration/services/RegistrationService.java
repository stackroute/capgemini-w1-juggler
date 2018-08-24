package com.stackroute.juggler.theatreregistration.services;

import com.stackroute.juggler.theatreregistration.domain.Registration;
import com.stackroute.juggler.theatreregistration.exceptions.TheatreAlreadyExists;

public interface RegistrationService {

	public Registration saveTheatre(Registration theatre) throws TheatreAlreadyExists;

	public Registration updateTheatre(Registration theatre);

	public Registration getByTitle(String searchTerm);
	
}