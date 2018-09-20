package com.stackroute.juggler.ticketengine.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.messaging.handler.annotation.MessageMapping;
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

import com.stackroute.juggler.ticketengine.domain.RedisObject;
import com.stackroute.juggler.ticketengine.domain.Seat;
import com.stackroute.juggler.ticketengine.domain.Show;
import com.stackroute.juggler.ticketengine.service.RedisServices;
import com.stackroute.juggler.ticketengine.service.SeatsService;
import com.stackroute.juggler.ticketengine.service.ShowService;

@CrossOrigin("*")
@RestController
@RequestMapping("/api/v1/ticket")
public class TicketController {

	private SeatsService seatService;
	private ShowService showService;
	private final SimpMessagingTemplate template;
	private RedisServices redisServcie;

	@Autowired
	public TicketController(SeatsService seatService, ShowService showService, SimpMessagingTemplate template,
			RedisServices redisServices) {
		this.seatService = seatService;
		this.showService = showService;
		this.template = template;
		this.redisServcie = redisServices;
	}

	@MessageMapping("/message")
	public void onReceiveMessage(String message) throws Exception {
		System.out.println("data incoming is " + message);
		this.template.convertAndSend("/chat", message);
	}

	// @MessageMapping("/message")
	// @SendTo("/movie")
	// public Seat seat(Seat seat) {
	// return seat;
	// }

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

	@PostMapping("/show")
	public ResponseEntity<?> saveSeats(@RequestBody RedisObject seats) {
		return new ResponseEntity<RedisObject>(redisServcie.save(seats), HttpStatus.OK);
	}

	@GetMapping("/shows")
	public ResponseEntity<?> getAllSeats() {
		return new ResponseEntity<List<RedisObject>>(redisServcie.getAll(), HttpStatus.OK);
	}

	@GetMapping("/show/{id}")
	public ResponseEntity<?> getbyId(@PathVariable String id) {
		return new ResponseEntity<RedisObject>(redisServcie.getById(id), HttpStatus.OK);
	}

	@DeleteMapping("/show/{id}")
	public ResponseEntity<?> deleteById(@PathVariable String id) {
		redisServcie.delete(id);
		return new ResponseEntity<String>("deleted", HttpStatus.OK);
	}

	@PutMapping("/show/update")
	public ResponseEntity<?> updateSeats(@RequestBody RedisObject seats) {
		return new ResponseEntity<RedisObject>(redisServcie.save(seats), HttpStatus.OK);
	}

}
