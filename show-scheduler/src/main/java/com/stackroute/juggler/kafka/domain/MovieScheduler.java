package com.stackroute.juggler.kafka.domain;

import java.util.List;

public class MovieScheduler {

	private String movieScheduleId;
	private String movieId;
	private String theatreName;
	private String theatreCity;
	private String movieStartDate;
	private List<Show> shows;

	public MovieScheduler(String movieScheduleId, String movieId, String theatreName, String theatreCity,
			String movieStartDate, List<Show> shows) {
		super();
		this.movieScheduleId = movieScheduleId;
		this.movieId = movieId;
		this.theatreName = theatreName;
		this.theatreCity = theatreCity;
		this.movieStartDate = movieStartDate;
		this.shows = shows;
	}

	public String getMovieScheduleId() {
		return movieScheduleId;
	}

	public void setMovieScheduleId(String movieScheduleId) {
		this.movieScheduleId = movieScheduleId;
	}

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

	public List<Show> getShows() {
		return shows;
	}

	public void setShows(List<Show> shows) {
		this.shows = shows;
	}

	@Override
	public String toString() {
		return "MovieScheduler [movieScheduleId=" + movieScheduleId + ", movieId=" + movieId + ", theatreName="
				+ theatreName + ", theatreCity=" + theatreCity + ", movieStartDate=" + movieStartDate + ", shows="
				+ shows + "]";
	}

}
