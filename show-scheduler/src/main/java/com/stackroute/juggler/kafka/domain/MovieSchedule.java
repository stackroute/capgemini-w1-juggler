package com.stackroute.juggler.kafka.domain;

import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

//Domain object for MovieSchedule details
@Document
public class MovieSchedule {
	@Id
	private String movieScheduleId;
	private String movieId;
	private String theatreName;
	private String theatreCity;
	private String movieStartDate;
	// private String[] showtimings;
	// private int count;
	// private boolean movieStatus;
	private List<Show> shows;

	// All Arguments Constructor
	public MovieSchedule(String movieScheduleId, String movieId, String theatreName, String theatreCity,
			String movieStartDate, String[] showtimings, int count, boolean movieStatus, List<Show> shows) {
		super();
		this.movieScheduleId = movieScheduleId;
		this.movieId = movieId;
		this.theatreName = theatreName;
		this.theatreCity = theatreCity;
		this.movieStartDate = movieStartDate;
		// this.showtimings = showtimings;
		// this.count = count;
		// this.movieStatus = movieStatus;
		this.shows = shows;
	}

	// List of getters and setters
	public String getMovieId() {
		return movieId;
	}

	public void setMovieId(String movieId) {
		this.movieId = movieId;
	}

	public String getTheatreName() {
		return theatreName;
	}

	public void setTheatreName(String theatreName) {
		this.theatreName = theatreName;
	}

	public String getTheatreCity() {
		return theatreCity;
	}

	public void setTheatreCity(String theatreCity) {
		this.theatreCity = theatreCity;
	}

	public String getMovieStartDate() {
		return movieStartDate;
	}

	public void setMovieStartDate(String movieStartDate) {
		this.movieStartDate = movieStartDate;
	}

//	public String[] getShowtimings() {
//		return showtimings;
//	}
//
//	public void setShowtimings(String[] showtimings) {
//		this.showtimings = showtimings;
//	}

//	public int getCount() {
//		return count;
//	}
//
//	public void setCount(int count) {
//		this.count = count;
//	}

	public List<Show> getShows() {
		return shows;
	}

	public void setShows(List<Show> shows) {
		this.shows = shows;
	}

//	public boolean isMovieStatus() {
//		return movieStatus;
//	}
//
//	public void setMovieStatus(boolean movieStatus) {
//		this.movieStatus = movieStatus;
//	}

	public String getMovieScheduleId() {
		return movieScheduleId;
	}

	public void setMovieScheduleId(String movieScheduleId) {
		this.movieScheduleId = movieScheduleId;
	}

	public MovieSchedule() {
		super();
	}

	@Override
	public String toString() {
		return "MovieSchedule [movieScheduleId=" + movieScheduleId + ", movieId=" + movieId + ", theatreName="
				+ theatreName + ", theatreCity=" + theatreCity + ", movieStartDate=" + movieStartDate + ", shows="
				+ shows + "]";
	}

}