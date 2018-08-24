package com.stackroute.juggler.movieschedule.domain;

import java.util.Map;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Document
// @Data
// @NoArgsConstructor
// @AllArgsConstructor
// @Builder

public class MovieSchedule {

	@Id
	private int theatreId;
	private String theatreName;
	private String theatreLocation;
	private String theatreCity;
	private String theatreLicenseNo;
	private String numberOfSeats;
	private Map<String, Integer> seats;
	private String[] screenedmovies;
	private String[] runningmovies;

	// private TheatreDetails theatreDetails;
	private MovieDetails movieDetails;
	private int showNumbers;
	private int[] showTimings;
	private TicketPrices ticketPrices;

	// private String bookingEndDate;
	public MovieSchedule(int theatreId, String theatreName, String theatreLocation, String theatreCity,
			String theatreLicenseNo, String numberOfSeats, Map<String, Integer> seats, String[] screenedmovies,
			String[] runningmovies, MovieDetails movieDetails, int showNumbers, int[] showTimings,
			TicketPrices ticketPrices) {
		super();
		this.theatreId = theatreId;
		this.theatreName = theatreName;
		this.theatreLocation = theatreLocation;
		this.theatreCity = theatreCity;
		this.theatreLicenseNo = theatreLicenseNo;
		this.numberOfSeats = numberOfSeats;
		this.seats = seats;
		this.screenedmovies = screenedmovies;
		this.runningmovies = runningmovies;
		this.movieDetails = movieDetails;
		this.showNumbers = showNumbers;
		this.showTimings = showTimings;
		this.ticketPrices = ticketPrices;
	}

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

	public MovieDetails getMovieDetails() {
		return movieDetails;
	}

	public void setMovieDetails(MovieDetails movieDetails) {
		this.movieDetails = movieDetails;
	}

	public int getShowNumbers() {
		return showNumbers;
	}

	public void setShowNumbers(int showNumbers) {
		this.showNumbers = showNumbers;
	}

	public int[] getShowTimings() {
		return showTimings;
	}

	public void setShowTimings(int[] showTimings) {
		this.showTimings = showTimings;
	}

	public TicketPrices getTicketPrices() {
		return ticketPrices;
	}

	public void setTicketPrices(TicketPrices ticketPrices) {
		this.ticketPrices = ticketPrices;
	}

}
