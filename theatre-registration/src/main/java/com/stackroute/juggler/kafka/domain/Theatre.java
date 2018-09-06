package com.stackroute.juggler.kafka.domain;

import java.io.File;
import java.util.LinkedHashMap;
import java.util.Map;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
//Domain object for theatre-registration details given by theatre-owner

@Document

public class Theatre {
	@Id
	private String theatreId;
	private String theatreLocation;
	private String theatreCity;
	private String theatreName;
	private String theatreLicenseNo;
	private String numberOfSeats;
	private LinkedHashMap<String,String> seats;
	private String[] screenedmovies;
	private String[] runningmovies;
	private File seatLayout;


	// All Arguments Constructor
	public Theatre(String theatreId, String theatreLocation, String theatreCity, String theatreName,
			String theatreLicenseNo, String numberOfSeats, LinkedHashMap<String, String> seats, String[] screenedmovies,
			String[] runningmovies, File seatLayout) {
		super();
		this.theatreId = theatreId;
		this.theatreLocation = theatreLocation;
		this.theatreCity = theatreCity;
		this.theatreName = theatreName;
		this.theatreLicenseNo = theatreLicenseNo;
		this.numberOfSeats = numberOfSeats;
		this.seats = seats;
		this.screenedmovies = screenedmovies;
		this.runningmovies = runningmovies;
		this.seatLayout = seatLayout;
	}

	public Theatre() {
	}

	// List of getters and setters
	public String getTheatreId() {
		return theatreId;
	}

	public void setTheatreId(String theatreId) {
		this.theatreId = theatreId;
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

	public String getTheatreName() {
		return theatreName;
	}

	public void setTheatreName(String theatreName) {
		this.theatreName = theatreName;
	}

	public String getTheatreLicenseNo() {
		return theatreLicenseNo;
	}

	public void setTheatreLicenseNo(String theatreLicenseNo) {
		this.theatreLicenseNo = theatreLicenseNo;
	}

	public String getNumberOfSeats() {
		return numberOfSeats;
	}

	public void setNumberOfSeats(String numberOfSeats) {
		this.numberOfSeats = numberOfSeats;
	}

	public Map<String, String> getSeats() {
		return seats;
	}

	public void setSeats(LinkedHashMap<String, String> seats) {
		this.seats = seats;
	}

	public String[] getScreenedmovies() {
		return screenedmovies;
	}

	public void setScreenedmovies(String[] screenedmovies) {
		this.screenedmovies = screenedmovies;
	}

	public String[] getRunningmovies() {
		return runningmovies;
	}

	public void setRunningmovies(String[] runningmovies) {
		this.runningmovies = runningmovies;
	}

	public File getSeatLayout() {
		return seatLayout;
	}

	public void setSeatLayout(File seatLayout) {
		this.seatLayout = seatLayout;
	}

	public void setComments(String string) {
		// TODO Auto-generated method stub

	}

	public Object getComments() {
		// TODO Auto-generated method stub
		return null;
	}
}
