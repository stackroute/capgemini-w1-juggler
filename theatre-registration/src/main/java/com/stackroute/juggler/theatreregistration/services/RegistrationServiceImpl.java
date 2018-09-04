package com.stackroute.juggler.theatreregistration.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import com.stackroute.juggler.kafka.domain.Theatre;
import com.stackroute.juggler.theatreregistration.exceptions.TheatreAlreadyExists;
import com.stackroute.juggler.theatreregistration.repository.RegistrationRepository;

@Service
public class RegistrationServiceImpl implements RegistrationService {

	private RegistrationRepository registrationRepository;

	// instance of repository
	@Autowired
	public RegistrationServiceImpl(RegistrationRepository registrationRepository) {

		this.registrationRepository = registrationRepository;
	}

	@Autowired
	// This is the topic name it wont be changed so "final static"
	private KafkaTemplate<String, Theatre> kafkaTemplate;
	private static final String TOPIC = "theatredetails";

	// saves the theatre details to database
	@Override
	public Theatre saveTheatre(Theatre theatre) throws TheatreAlreadyExists {
		kafkaTemplate.send(TOPIC, theatre);
		if (!registrationRepository.existsByTheatreName(theatre.getTheatreName())) {
			Theatre theatreSaved = registrationRepository.save(theatre);
			return theatreSaved;
		} else
			throw new TheatreAlreadyExists("theatre already exists");
	}

	// to update the theatre details
	@Override
	public Theatre updateTheatre(Theatre theatre) {
//		kafkaTemplate.send(TOPIC, theatre);
		Theatre theatreUpdated = registrationRepository.save(theatre);

		return theatreUpdated;
	}

	// To the theatre by using theatre title from database
	@Override
	public Theatre getByTitle(String theatre) {
		Theatre list = registrationRepository.getByTheatreName(theatre);
		return list;
	}

}