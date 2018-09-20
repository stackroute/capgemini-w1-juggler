package com.stackroute.juggler.ticketengine.domain;

import java.util.Date;
import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class Show {
    
	@Id
	private String showId;
	private String movieName;
	private String theatreName;
	private Date date;
	private String slot;
	private Boolean status;
	private List<Integer> bookedSeats;
	public String getShowId() {
		return showId;
	}
	public void setShowId(String showId) {
		this.showId = showId;
	}
	public String getMovieName() {
		return movieName;
	}
	public void setMovieName(String movieName) {
		this.movieName = movieName;
	}
	public String getTheatreName() {
		return theatreName;
	}
	public void setTheatreName(String theatreName) {
		this.theatreName = theatreName;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	public String getSlot() {
		return slot;
	}
	public void setSlot(String slot) {
		this.slot = slot;
	}
	public Boolean getStatus() {
		return status;
	}
	public void setStatus(Boolean status) {
		this.status = status;
	}
	public List<Integer> getBookedSeats() {
		return bookedSeats;
	}
	public void setBookedSeats(List<Integer> bookedSeats) {
		this.bookedSeats = bookedSeats;
	}
	public Show(String showId, String movieName, String theatreName, Date date, String slot, Boolean status,
			List<Integer> bookedSeats) {
		super();
		this.showId = showId;
		this.movieName = movieName;
		this.theatreName = theatreName;
		this.date = date;
		this.slot = slot;
		this.status = status;
		this.bookedSeats = bookedSeats;
	}
	public Show() {
		super();
	}
	
	
	
	
}
