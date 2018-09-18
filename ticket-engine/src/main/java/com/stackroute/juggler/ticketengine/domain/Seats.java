package com.stackroute.juggler.ticketengine.domain;

import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.redis.core.RedisHash;

@RedisHash("Seats")
public class Seats {

	@Id
	private String id;

	private String showSlot;
	private String theatreName;
	private String movieName;
	private String date;
	private LayoutInfo seatLayout;
	private List<Integer> openSeats;
	private List<Integer> blockedSeats;
	private List<Integer> bookedSeats;
//	private String status;

	public Seats() {
	}

	public Seats(String id, String showSlot, String theatreName, String movieName, String date, LayoutInfo seatLayout,
			List<Integer> openSeats, List<Integer> bookedSeats, List<Integer> blockedSeats) {
		super();
		this.id = id;
		this.showSlot = showSlot;
		this.theatreName = theatreName;
		this.movieName = movieName;
		this.date = date;
		this.seatLayout = seatLayout;
		this.openSeats = openSeats;
		this.bookedSeats = bookedSeats;
		this.blockedSeats = blockedSeats;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getShowSlot() {
		return showSlot;
	}

	public void setShowSlot(String showSlot) {
		this.showSlot = showSlot;
	}

	public String getTheatreName() {
		return theatreName;
	}

	public void setTheatreName(String theatreName) {
		this.theatreName = theatreName;
	}

	public String getMovieName() {
		return movieName;
	}

	public void setMovieName(String movieName) {
		this.movieName = movieName;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public LayoutInfo getSeatLayout() {
		return seatLayout;
	}

	public void setSeatLayout(LayoutInfo seatLayout) {
		this.seatLayout = seatLayout;
	}

	public List<Integer> getOpenSeats() {
		return openSeats;
	}

	public void setOpenSeats(List<Integer> openSeats) {
		this.openSeats = openSeats;
	}

	public List<Integer> getBookedSeats() {
		return bookedSeats;
	}

	public void setBookedSeats(List<Integer> bookedSeats) {
		this.bookedSeats = bookedSeats;
	}

	public List<Integer> getBlockedSeats() {
		return blockedSeats;
	}

	public void setBlockedSeats(List<Integer> blockedSeats) {
		this.blockedSeats = blockedSeats;
	}
	
}
