package com.stackroute.juggler.ticketengine.controller;

import java.util.Iterator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.stackroute.juggler.ticketengine.domain.Seats;
import com.stackroute.juggler.ticketengine.service.SeatsService;

@CrossOrigin("*")
@RestController
@RequestMapping("/api/v1/ticket")
public class TicketController {

	private SeatsService seatService;
	private final SimpMessagingTemplate template;

	@Autowired
	public TicketController(SeatsService seatService, SimpMessagingTemplate template) {

		this.template = template;
		this.seatService = seatService;
	}

	@GetMapping("/")
	public String message() {
		System.out.println("Hai.....Welcome");
		return "Hello....it's working";
	}

	@MessageMapping("/message/{name}/{date}/{slot}")
	@SendTo("/movie")
	public Seats seats(Seats seats, @PathVariable String name, @PathVariable String date, @PathVariable String slot) {

		List<Seats> seatsR = seatService.getAll();
		for (Iterator iterator = seatsR.iterator(); iterator.hasNext();) {
			Seats seats2 = (Seats) iterator.next();
			if (seats2.getTheatreName().equals(name) && seats2.getDate().equals(date)
					&& seats2.getShowSlot().equals(slot)) {
				return seats2;
			}
		}
		return null;
	}

	@PostMapping("/seats")
	public ResponseEntity<?> saveSeats(@RequestBody Seats seats) {
		return new ResponseEntity<Seats>(seatService.save(seats), HttpStatus.OK);
	}

	@GetMapping("/allSeats")
	public ResponseEntity<?> getAllSeats() {
		return new ResponseEntity<List<Seats>>(seatService.getAll(), HttpStatus.OK);
	}

	@GetMapping("/seats/name/{name}/{date}/{slot}")
	public ResponseEntity<?> getSeatByName(@PathVariable String name, @PathVariable String date,
			@PathVariable String slot) {
		List<Seats> seats = seatService.getAll();
		for (Iterator iterator = seats.iterator(); iterator.hasNext();) {
			Seats seats2 = (Seats) iterator.next();
			if (seats2.getTheatreName().equals(name) && seats2.getDate().equals(date)
					&& seats2.getShowSlot().equals(slot)) {
				return new ResponseEntity<Seats>(seats2, HttpStatus.OK);
			}
		}
		return new ResponseEntity<String>("seatService.getByName(name).get()", HttpStatus.OK);
	}

	@GetMapping("/seats/{id}")
	public ResponseEntity<?> getSeatById(@PathVariable String id) {
		return new ResponseEntity<Seats>(seatService.getById(id).get(), HttpStatus.OK);
	}

	@DeleteMapping("/seats/{id}")
	public ResponseEntity<?> delBlockedSeats(@PathVariable String id) {
		seatService.delete(id);
		return new ResponseEntity<String>("Deleted", HttpStatus.OK);
	}

}
