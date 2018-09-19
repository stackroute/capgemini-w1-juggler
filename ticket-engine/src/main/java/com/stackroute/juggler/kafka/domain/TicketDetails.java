package com.stackroute.juggler.kafka.domain;

import java.util.List;

import org.springframework.data.annotation.Id;

import com.fasterxml.jackson.annotation.JsonFormat;

public class TicketDetails {
	
    private String bookingId;
    private String theatreName;
    private String ShowId;
    private String movieName;
    private List<Integer> bookedSeats;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "HH:mm")
    private String showTiming;
    private String bookingStatus;
    
	public String getBookingId() {
		
		return bookingId;
	}
	public void setBookingId(String bookingId) {
		this.bookingId = bookingId;
	}
	public String getTheatreName() {
		return theatreName;
	}
	public void setTheatreName(String theatreName) {
		this.theatreName = theatreName;
	}
	public String getShowId() {
		return ShowId;
	}
	public void setShowId(String showId) {
		ShowId = showId;
	}
	public String getMovieName() {
		return movieName;
	}
	public void setMovieName(String movieName) {
		this.movieName = movieName;
	}
	public List<Integer> getBookedSeats() {
		return bookedSeats;
	}
	public void setBookedSeats(List<Integer> bookedSeats) {
		this.bookedSeats = bookedSeats;
	}
	public String getShowTiming() {
		return showTiming;
	}
	public void setShowTiming(String showTiming) {
		this.showTiming = showTiming;
	}
	public String getBookingStatus() {
		return bookingStatus;
	}
	public void setBookingStatus(String bookingStatus) {
		this.bookingStatus = bookingStatus;
	}
	public TicketDetails(String bookingId, String theatreName, String showId, String movieName,
			List<Integer> bookedSeats, String showTiming, String bookingStatus) {
		super();
		this.bookingId = bookingId;
		this.theatreName = theatreName;
		ShowId = showId;
		this.movieName = movieName;
		this.bookedSeats = bookedSeats;
		this.showTiming = showTiming;
		this.bookingStatus = bookingStatus;
	}
	public TicketDetails() {
		super();
	}

    
    
}
