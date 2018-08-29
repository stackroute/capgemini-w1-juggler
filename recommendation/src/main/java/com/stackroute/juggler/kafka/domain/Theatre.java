package com.stackroute.juggler.kafka.domain;

import java.util.List;

import org.springframework.data.annotation.Id;

public class Theatre {
	@Id
	private int theatreId;
	private String theatreName;
	private String theatreLocation;
	private String theatreCity;
	private String seatLayout;
	private List<Show> shows;
	public int getTheatreId() {
		return theatreId;
	}
	public void setTheatreId(int theatreId) {
		this.theatreId = theatreId;
	}
	public String getTheatreName() {
		return theatreName;
	}
	public void setTheatreName(String theatreName) {
		this.theatreName = theatreName;
	}
	public String getTheatreLocation() {
		return theatreLocation;
	}
	public void setTheatreLocation(String theatreLocation) {
		this.theatreLocation = theatreLocation;
	}
	public String getTheatreCity() {
		return theatreCity;
	}
	public void setTheatreCity(String theatreCity) {
		this.theatreCity = theatreCity;
	}
	public String getSeatLayout() {
		return seatLayout;
	}
	public void setSeatLayout(String seatLayout) {
		this.seatLayout = seatLayout;
	}
	public List<Show> getShows() {
		return shows;
	}
	public void setShows(List<Show> shows) {
		this.shows = shows;
	}
}
