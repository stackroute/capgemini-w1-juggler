package com.stackroute.juggler.ticketengine.controller;

import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Optional;

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
import com.stackroute.juggler.ticketengine.repository.ShowRepository;
import com.stackroute.juggler.ticketengine.service.SeatsService;

@CrossOrigin("*")
@RestController
@RequestMapping("/api/v1/ticket")
public class TicketController {


	private SeatsService seatService;
	private final SimpMessagingTemplate template;

	@Autowired
	public TicketController( SeatsService seatService, SimpMessagingTemplate template) {
		
		this.template = template;
		this.seatService = seatService;
	}

	   @PostMapping("/Seat")
	    public ResponseEntity<?> saveSeats(@PathVariable String showId) {
		   Show localShow = new Show();
		   localShow =seatService.getById(showId);
		   Seat seatlocal = new Seat();
		   seatlocal = seatService.findById(showId);
		   seatlocal.setBlockedSeats(localShow.getBookedSeats());
		    
		   return new ResponseEntity<Seat>(seatlocal, HttpStatus.OK);
		   
	    }
}
