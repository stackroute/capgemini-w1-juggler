package com.stackroute.juggler.theatreregistration.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.stackroute.juggler.kafka.domain.Theatre;
import com.stackroute.juggler.theatreregistration.exceptions.TheatreAlreadyExistsException;
import com.stackroute.juggler.theatreregistration.exceptions.TheatreNotFoundException;
import com.stackroute.juggler.theatreregistration.services.TheatreService;

@CrossOrigin(origins = "http://localhost:4200")
@RestController

// class level request mapping
@RequestMapping(value = "/api/v1/")
public class TheatreController {

	// creating an instance of service
	TheatreService theatreService;

	@Autowired
	public void registrationController(TheatreService theatreService) {
		this.theatreService = theatreService;

	}

//	@Autowired
//	private KafkaTemplate<String, Theatre> kafkaTemplate; // This is the topic name it wont be changed so "final
//															// static"
//	private static final String TOPIC = "testkafka";

	// saves the theatre details
	@RequestMapping(value = "/theatre", method = RequestMethod.POST)
	public ResponseEntity<?> saveTheatre(@RequestBody Theatre theatre) throws TheatreAlreadyExistsException {

		Theatre theatreobj = null;
		System.out.println(theatre.getTheatreCity());
		System.out.println(theatre.getSeats());
//		kafkaTemplate.send(TOPIC, theatre);
		// This is to save
		try {
			theatreobj = theatreService.saveTheatre(theatre);
			System.out.println(theatreobj.getSeats());
			return new ResponseEntity<Theatre>(theatreobj, HttpStatus.OK);
		} catch (TheatreAlreadyExistsException m) {
			String result = m.getMessage();
			return new ResponseEntity<String>(result, HttpStatus.OK);
		}

	}

	// get the particular theatre from database by using theatre name
	@RequestMapping(value = "/theatre", method = RequestMethod.PUT)
	public ResponseEntity<Theatre> updateTheatre(@RequestBody Theatre theatre) throws TheatreNotFoundException {

		Theatre theatreobj = theatreService.updateTheatre(theatre);

		return new ResponseEntity<Theatre>(theatreobj, HttpStatus.OK);
	}

	// To update the theatre details using theatre name
	@RequestMapping(value = "/theatre/{TheatreTitle}", method = RequestMethod.GET)
	public ResponseEntity<?> getByTheatreTitle(@PathVariable String TheatreTitle) throws TheatreNotFoundException {
		Theatre list = theatreService.getTheatre(TheatreTitle);

		return new ResponseEntity<Theatre>(list, HttpStatus.OK);

	}
}
