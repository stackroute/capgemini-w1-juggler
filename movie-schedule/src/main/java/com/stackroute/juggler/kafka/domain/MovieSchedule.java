package com.stackroute.juggler.kafka.domain;

import java.util.Arrays;
import java.util.Map;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import com.fasterxml.jackson.annotation.JsonFormat;

//POJO of MovieScreening details

@Document
public class MovieSchedule {

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
	private Movie movie;
	private int showNumbers;
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "HH:mm")
	private String showTimings;
	private TicketPrices ticketPrices;

	// default constructor
	public MovieSchedule() {
		super();
	}

	// All arguments constructors
	public MovieSchedule(String theatreId, String theatreName, String theatreLocation, String theatreCity,
			String theatreLicenseNo, String numberOfSeats, Map<String, Integer> seats, String[] screenedmovies,
			String[] runningmovies, Movie movie, int showNumbers, String showTimings, TicketPrices ticketPrices) {

		this.theatreId = theatreId;
		this.theatreName = theatreName;
		this.theatreLocation = theatreLocation;
		this.theatreCity = theatreCity;
		this.theatreLicenseNo = theatreLicenseNo;
		this.numberOfSeats = numberOfSeats;
		this.seats = seats;
		this.screenedmovies = screenedmovies;
		this.runningmovies = runningmovies;
		this.movie = movie;
		this.showNumbers = showNumbers;
		this.showTimings = showTimings;
		this.ticketPrices = ticketPrices;
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

	public Movie getMovieDetails() {
		return movie;
	}

	public void setMovieDetails(Movie movie) {
		this.movie = movie;
	}

	public int getShowNumbers() {
		return showNumbers;
	}

	public void setShowNumbers(int showNumbers) {
		this.showNumbers = showNumbers;
	}

	public TicketPrices getTicketPrices() {
		return ticketPrices;
	}

	public void setTicketPrices(TicketPrices ticketPrices) {
		this.ticketPrices = ticketPrices;
	}

	public String getShowTimings() {
		return showTimings;
	}

	public void setShowTimings(String showTimings) {
		this.showTimings = showTimings;
	}

	@Override
	public String toString() {
		return "MovieSchedule [theatreId=" + theatreId + ", theatreName=" + theatreName + ", theatreLocation="
				+ theatreLocation + ", theatreCity=" + theatreCity + ", theatreLicenseNo=" + theatreLicenseNo
				+ ", numberOfSeats=" + numberOfSeats + ", seats=" + seats + ", screenedmovies="
				+ Arrays.toString(screenedmovies) + ", runningmovies=" + Arrays.toString(runningmovies) + ", movie="
				+ movie + ", showNumbers=" + showNumbers + ", showTimings=" + showTimings + ", ticketPrices="
				+ ticketPrices + "]";
	}

}
