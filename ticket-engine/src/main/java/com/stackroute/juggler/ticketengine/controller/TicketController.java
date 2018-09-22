package com.stackroute.juggler.ticketengine.controller;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.stackroute.juggler.ticketengine.domain.Show;
import com.stackroute.juggler.ticketengine.service.ShowService;

@CrossOrigin("*")
@RestController
@RequestMapping("/api/v1/ticket")
public class TicketController {

	private ShowService showService;
	private final SimpMessagingTemplate template;

	@Autowired
	public TicketController(ShowService showService, SimpMessagingTemplate template) {

		this.showService = showService;
		this.template = template;
	}

	@MessageMapping("/message")
	public void seat(String message) throws IOException {
		
		System.out.println(message);
		ObjectMapper objectMapper = new ObjectMapper();
		Show json = objectMapper.readValue(message, Show.class);
		showService.updateBlocked(json);
		showService.getById(json.getShowId());
		this.template.convertAndSend("/movie", message);
	}

//	// updating
//	@PutMapping("/show")
//	public ResponseEntity<?> update(@RequestBody Show show) {
//		showService.update(show);
//		return new ResponseEntity<Show>(show, HttpStatus.OK);
//	}

	// get all
	@GetMapping("/shows")
	public ResponseEntity<?> getAllShows() {
		return new ResponseEntity<Iterable<Show>>(showService.getAll(), HttpStatus.OK);
	}
	
	@GetMapping("/layout/{showid}")
	public ResponseEntity<?> getLayout(@PathVariable String showid) {
		Show localshow = showService.getById(showid);
		return new ResponseEntity<Show>(localshow, HttpStatus.OK);
	}
	
	// get id
	@GetMapping("/show/{id}")
	public ResponseEntity<?> getById(@PathVariable String id) {
		return new ResponseEntity<Show>(showService.getById(id), HttpStatus.OK);
	}

	// Deleting
	@DeleteMapping("/show/{showId}")
	public String delShow(@PathVariable String showId) {
		showService.delete(showId);
		return "show deleted";
	}
}
