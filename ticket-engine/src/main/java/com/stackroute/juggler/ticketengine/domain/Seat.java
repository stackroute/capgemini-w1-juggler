package com.stackroute.juggler.ticketengine.domain;

import java.util.Date;
import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.redis.core.RedisHash;

@RedisHash("Seats")
public class Seat {

	@Id
	private String id;

	private String showSlot;
	// private String theatreName;
	// private String movieName;
	private Date date;
	// private Seats seatLayout;
	// private List<Integer> seats;
	private List<Integer> blockedSeats;
	private List<Integer> bookedSeats;

	public String getId() {
		return id;
	}

	public String getShowSlot() {
		return showSlot;
	}

	public void setShowSlot(String showSlot) {
		this.showSlot = showSlot;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public List<Integer> getBlockedSeats() {
		return blockedSeats;
	}

	public void setBlockedSeats(List<Integer> blockedSeats) {
		this.blockedSeats = blockedSeats;
	}

	public List<Integer> getBookedSeats() {
		return bookedSeats;
	}

	public void setBookedSeats(List<Integer> bookedSeats) {
		this.bookedSeats = bookedSeats;
	}

	public void setId(String id) {
		this.id = id;
	}

	public Seat(String id, String showSlot, Date date, List<Integer> blockedSeats, List<Integer> bookedSeats) {
		super();
		this.id = id;
		this.showSlot = showSlot;
		this.date = date;
		this.blockedSeats = blockedSeats;
		this.bookedSeats = bookedSeats;
	}

	public Seat() {
		// TODO Auto-generated constructor stub
	}

}
