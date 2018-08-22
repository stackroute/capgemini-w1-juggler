package com.stackroute.juggler.theatreregistration.services;

import com.stackroute.juggler.theatreregistration.domain.Registration;

public interface RegistrationService {

	public Registration saveTheatre(Registration theatre);

	public Registration updateTheatre(Registration theatre);

	public Registration getByTitle(String searchTerm);

}