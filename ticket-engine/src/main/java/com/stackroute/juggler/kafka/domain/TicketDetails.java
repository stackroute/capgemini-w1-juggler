package com.stackroute.juggler.kafka.domain;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonFormat;

public class TicketDetails {

	private String bookingId;
	private String theatreName;
	private String showId;
	private String movieName;
	private List<Integer> bookedSeats;
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "HH:mm")
	private String showTiming;
	private String bookingStatus;

	public TicketDetails() {
	}

	public TicketDetails(String bookingId, String theatreName, String showId, String movieName, String showTiming,
			String bookingStatus, List<Integer> bookedSeats) {
		this.bookingId = bookingId;
		this.setTheatreName(theatreName);
		this.setShowId(showId);
		this.setMovieName(movieName);
		this.setBookedSeats(bookedSeats);
		this.showTiming = showTiming;
		this.setBookingStatus(bookingStatus);
	}

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
		return showId;
	}

	public void setShowId(String showId) {
		this.showId = showId;
	}

	public List<Integer> getBookedSeats() {
		return bookedSeats;
	}

	public void setBookedSeats(List<Integer> bookedSeats) {
		this.bookedSeats = bookedSeats;
	}

	public String getMovieName() {
		return movieName;
	}

	public void setMovieName(String movieName) {
		this.movieName = movieName;
	}

	public String getBookingStatus() {
		return bookingStatus;
	}

	public void setBookingStatus(String bookingStatus) {
		this.bookingStatus = bookingStatus;
	}

}
