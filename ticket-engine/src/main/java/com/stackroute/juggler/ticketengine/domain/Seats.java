package com.stackroute.juggler.ticketengine.domain;

import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.redis.core.RedisHash;

@RedisHash("Seats")
public class Seats {

	@Id
	private String id;
    
	private String showId;
	private List<Integer> seats;
	private String status;
	private String userName;
	private String guestUserEmailId;
	private int movieEventId;
    
	public Seats() {}

	public Seats(String id, String showId, List<Integer> seats, String status, String userName, String guestUserEmailId,
			int movieEventId) {
		this.id = id;
		this.showId = showId;
		this.seats = seats;
		this.status = status;
		this.userName = userName;
		this.guestUserEmailId = guestUserEmailId;
		this.movieEventId = movieEventId;
	}

	public String getShowId() {
		return showId;
	}

	public void setShowId(String showId) {
		this.showId = showId;
	}

	public List<Integer> getSeats() {
		return seats;
	}

	public void setSeats(List<Integer> seats) {
		this.seats = seats;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getGuestUserEmailId() {
		return guestUserEmailId;
	}

	public void setGuestUserEmailId(String guestUserEmailId) {
		this.guestUserEmailId = guestUserEmailId;
	}

	public int getMovieEventId() {
		return movieEventId;
	}

	public void setMovieEventId(int movieEventId) {
		this.movieEventId = movieEventId;
	}

	@Override
	public String toString() {
		return "Seats [id=" + id + ", showId=" + showId + ", seats=" + seats + ", status=" + status + ", userName="
				+ userName + ", guestUserEmailId=" + guestUserEmailId + ", movieEventId=" + movieEventId + "]";
	}
	
}
