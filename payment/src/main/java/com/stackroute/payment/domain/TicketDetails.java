package com.stackroute.payment.domain;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import com.fasterxml.jackson.annotation.JsonFormat;

@Document
public class TicketDetails {

	@Id
	private String bookingId;
	private String theatreName;
	private String movieName;
	private String[] bookedSeats;
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "HH:mm")
	private String showTiming;
	private String bookingStatus;

	public TicketDetails() {
		super();
	}

	public TicketDetails(String bookingId, String theatreName, String movieName, String[] bookedSeats,
			String showTiming, String bookingStatus) {
		super();
		this.bookingId = bookingId;
		this.theatreName = theatreName;
		this.movieName = movieName;
		this.bookedSeats = bookedSeats;
		this.showTiming = showTiming;
		this.bookingStatus = bookingStatus;
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

	public String getMovieName() {
		return movieName;
	}

	public void setMovieName(String movieName) {
		this.movieName = movieName;
	}

	public String[] getBookedSeats() {
		return bookedSeats;
	}

	public void setBookedSeats(String[] bookedSeats) {
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

}
