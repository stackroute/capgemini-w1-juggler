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
	private List<Integer> seats;
	private List<Integer> blockedSeats;
	private List<Integer> bookedSeats;

	public Seats() {}

	public Seats( String id, String showSlot, String theatreName, String movieName, String date, LayoutInfo seatLayout,
			List<Integer> seats, List<Integer> blockedSeats, List<Integer> bookedSeats) {
		super();
		this.id = id;
		this.showSlot = showSlot;
		this.theatreName = theatreName;
		this.movieName = movieName;
		this.date = date;
		this.seatLayout = seatLayout;
		this.seats = seats;
		this.blockedSeats = blockedSeats;
		this.bookedSeats = bookedSeats;
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

	public List<Integer> getSeats() {
		return seats;
	}

	public void setSeats(List<Integer> seats) {
		this.seats = seats;
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
	
	public LayoutInfo getSeatLayout() {
		return seatLayout;
	}

	public void setSeatLayout(LayoutInfo seatLayout) {
		this.seatLayout = seatLayout;
	}

	@Override
	public String toString() {
		return "Seats [id=" + id + ", showSlot=" + showSlot + ", theatreName=" + theatreName + ", movieName="
				+ movieName + ", date=" + date + ", seatLayout=" + seatLayout + ", seats=" + seats + ", blockedSeats="
				+ blockedSeats + ", bookedSeats=" + bookedSeats + "]";
	}
	
}
