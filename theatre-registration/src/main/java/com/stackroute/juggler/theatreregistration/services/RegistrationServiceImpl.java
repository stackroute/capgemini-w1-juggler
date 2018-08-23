package com.stackroute.juggler.theatreregistration.services;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.stackroute.juggler.theatreregistration.domain.Registration;
import com.stackroute.juggler.theatreregistration.repository.RegistrationRepository;


@Service
public class RegistrationServiceImpl implements RegistrationService {

	private RegistrationRepository registrationRepository;

	@Autowired
	public RegistrationServiceImpl(RegistrationRepository registrationRepository) {

		this.registrationRepository = registrationRepository;
	}

	@Override
	public Registration saveTheatre(Registration theatre) {
		// TODO Auto-generated method stub
		Registration theatreSaved = registrationRepository.save(theatre);
		return theatreSaved;
	}

	@Override
	public Registration updateTheatre(Registration theatre) {
		// TODO Auto-generated method stub

		Registration theatreUpdated = registrationRepository.save(theatre);

		return theatreUpdated;
	}

	@Override
	public Registration getByTitle(String theatre) {
		// TODO Auto-generated method stub
		Registration list = registrationRepository.getByTheatreName(theatre);
		return list;
	}

}