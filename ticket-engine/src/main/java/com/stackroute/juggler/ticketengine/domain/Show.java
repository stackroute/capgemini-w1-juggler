package com.stackroute.juggler.ticketengine.domain;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Map;

import org.springframework.data.annotation.Id;

public class Show implements Serializable{

	private static final long serialVersionUID = 1L;
    
	@Id
	private String showId;
	private int seatsRemaining;
	private int price;
	private LocalTime startTime;
	private LocalDate date;
	private int movieEventId;
	private Boolean status;
	private Map<Integer, String> seats;
	
	public Show() {}

	public Show(String showId, int seatsRemaining, int price, LocalTime startTime, LocalDate date, int movieEventId,
			Boolean status, Map<Integer, String> seats) {
		this.showId = showId;
		this.seatsRemaining = seatsRemaining;
		this.price = price;
		this.startTime = startTime;
		this.date = date;
		this.movieEventId = movieEventId;
		this.status = status;
		this.seats = seats;
	}

	public String getShowId() {
		return showId;
	}

	public void setShowId(String showId) {
		this.showId = showId;
	}

	public int getSeatRemaining() {
		return seatsRemaining;
	}

	public void setSeatsRemaining(int seatsRemaining) {
		this.seatsRemaining = seatsRemaining;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public LocalTime getStartTime() {
		return startTime;
	}

	public void setStartTime(LocalTime startTime) {
		this.startTime = startTime;
	}

	public LocalDate getDate() {
		return date;
	}

	public void setDate(LocalDate date) {
		this.date = date;
	}

	public int getMovieEventId() {
		return movieEventId;
	}

	public void setMovieEventId(int movieEventId) {
		this.movieEventId = movieEventId;
	}

	public Boolean getStatus() {
		return status;
	}

	public void setStatus(Boolean status) {
		this.status = status;
	}

	public Map<Integer, String> getSeats() {
		return seats;
	}

	public void setSeats(Map<Integer, String> seats) {
		this.seats = seats;
	}

	@Override
	public String toString() {
		return "Show [showId=" + showId + ", seatRemaining=" + seatsRemaining + ", price=" + price + ", startTime="
				+ startTime + ", date=" + date + ", movieEventId=" + movieEventId + ", status=" + status + ", seats="
				+ seats + "]";
	}
	
}
