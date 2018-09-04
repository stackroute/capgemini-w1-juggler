package com.stackroute.juggler.kafka.domain;

import java.util.Arrays;
import java.util.Map;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

//POJO of Theatre details 

@Document
public class Theatre {

	@Id
	private String theatreId;
	private String theatreName;
	private String theatreLocation;
	private String theatreCity;
	private String theatreLicenseNo;
	private String numberOfSeats;
	private Map<String, Integer> seats;
	private String[] screenedmovies;
	private String[] runningmovies;

	// All arguments constructors
	public Theatre(String theatreId, String theatreName, String theatreLocation, String theatreCity,
			String theatreLicenseNo, String numberOfSeats, Map<String, Integer> seats, String[] screenedmovies,
			String[] runningmovies) {

		this.theatreId = theatreId;
		this.theatreName = theatreName;
		this.theatreLocation = theatreLocation;
		this.theatreCity = theatreCity;
		this.theatreLicenseNo = theatreLicenseNo;
		this.numberOfSeats = numberOfSeats;
		this.seats = seats;
		this.screenedmovies = screenedmovies;
		this.runningmovies = runningmovies;
	}

	// List of all getters and setters
	public String getTheatreId() {
		return theatreId;
	}

	public void setTheatreId(String theatreId) {
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

	public Map<String, Integer> getSeats() {
		return seats;
	}

	public void setSeats(Map<String, Integer> seats) {
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

	// default constructor
	public Theatre() {

	}

	@Override
	public String toString() {
		return "Theatre [theatreId=" + theatreId + ", theatreName=" + theatreName + ", theatreLocation="
				+ theatreLocation + ", theatreCity=" + theatreCity + ", theatreLicenseNo=" + theatreLicenseNo
				+ ", numberOfSeats=" + numberOfSeats + ", seats=" + seats + ", screenedmovies="
				+ Arrays.toString(screenedmovies) + ", runningmovies=" + Arrays.toString(runningmovies) + "]";
	}

}
