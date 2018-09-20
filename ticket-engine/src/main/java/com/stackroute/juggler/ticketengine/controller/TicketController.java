package com.stackroute.juggler.ticketengine.controller;

import java.util.Iterator;
import java.util.List;
import java.util.Map;

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
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.stackroute.juggler.ticketengine.domain.Seat;
import com.stackroute.juggler.ticketengine.domain.Show;
import com.stackroute.juggler.ticketengine.service.SeatsService;
import com.stackroute.juggler.ticketengine.service.ShowService;

@CrossOrigin("*")
@RestController
@RequestMapping("/api/v1/ticket")
public class TicketController {

	private SeatsService seatService;
	private ShowService showService;
	private final SimpMessagingTemplate template;

	@Autowired
	public TicketController(SeatsService seatService, ShowService showService, SimpMessagingTemplate template) {
		this.seatService = seatService;
		this.showService = showService;
		this.template = template;
	}

	@MessageMapping("/message")
    @SendTo("/movie")
	public Seat seat(Seat seat) {
		return seat;
	}
	
	@GetMapping("/Seat/{showId}")
	public ResponseEntity<?> saveSeats(@PathVariable String showId) {
		
		Show localShow = new Show();
		localShow = showService.getById(showId);
		Seat seatlocal = new Seat();
		seatlocal = seatService.findById(showId);
		seatlocal.setBlockedSeats(localShow.getBookedSeats());
		seatService.save(seatlocal);
		return new ResponseEntity<Seat>(seatlocal, HttpStatus.OK);

	
	}


	
}
