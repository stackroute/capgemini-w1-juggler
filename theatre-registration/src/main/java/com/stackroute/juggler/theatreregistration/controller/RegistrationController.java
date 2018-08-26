package com.stackroute.juggler.theatreregistration.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.kafka.core.KafkaTemplate;
//import org.springframework.kafka.core.KafkaTemplate;
//import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.stackroute.juggler.theatreregistration.domain.Registration;
import com.stackroute.juggler.theatreregistration.exceptions.TheatreAlreadyExists;
import com.stackroute.juggler.theatreregistration.services.RegistrationService;

//@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping(value = "/api/v1/")
public class RegistrationController {

	RegistrationService registrationService;

	@Autowired
	public void registrationController(RegistrationService registrationService) {
		this.registrationService = registrationService;

	}
	   
	@RequestMapping(value = "/theatre", method = RequestMethod.POST)
	public ResponseEntity<?> saveTheatre(@RequestBody Registration theatre) throws TheatreAlreadyExists {
		Registration theatreobj = null;
		 // This is to save 
		try {
			 theatreobj=registrationService.saveTheatre(theatre);
			 return new ResponseEntity<Registration>(theatreobj, HttpStatus.OK);
	            }
	           catch(TheatreAlreadyExists m)
				{
	        	   String result=m.getMessage();
	        	   return new ResponseEntity<String>(result, HttpStatus.OK);
			}
		
		
	}
	
	@RequestMapping(value = "/theatre", method = RequestMethod.PUT)
	public ResponseEntity<Registration> updateTheatre(@RequestBody Registration theatre) {

		Registration theatreobj = registrationService.updateTheatre(theatre);

		return new ResponseEntity<Registration>(theatreobj, HttpStatus.OK);
	}
	

	@RequestMapping(value = "/theatre/{TheatreTitle}", method = RequestMethod.GET)
	public ResponseEntity<?> getByTheatreTitle(@PathVariable String TheatreTitle) {
		Registration list = registrationService.getByTitle(TheatreTitle);

		return new ResponseEntity<Registration>(list, HttpStatus.OK);

	}	
}
