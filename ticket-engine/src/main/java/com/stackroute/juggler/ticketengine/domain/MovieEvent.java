package com.stackroute.juggler.ticketengine.domain;

import java.util.List;

import org.springframework.data.annotation.Id;

public class MovieEvent {
	
	@Id
	private int movieEventId;
	
	private int movieId;
	private int theatreId;
	private int showCount;
	private String showTimes;
	private String city;
	private String userName;
	private List<Show> shows;
	private int week;
	
	public MovieEvent() {}
	
	public MovieEvent(int movieEventId, int movieId, int theatreId, int showCount, String showTimes, String city,
			String userName, List<Show> shows, int week) {
		this.movieEventId = movieEventId;
		this.movieId = movieId;
		this.theatreId = theatreId;
		this.showCount = showCount;
		this.showTimes = showTimes;
		this.city = city;
		this.userName = userName;
		this.shows = shows;
		this.week = week;
	}

	public int getMovieId() {
		return movieId;
	}
	public void setMovieId(int movieId) {
		this.movieId = movieId;
	}
	public int getTheatreId() {
		return theatreId;
	}
	public void setTheatreId(int theatreId) {
		this.theatreId = theatreId;
	}
	public int getShowCount() {
		return showCount;
	}
	public void setShowCount(int showCount) {
		this.showCount = showCount;
	}
	public String getShowTimes() {
		return showTimes;
	}
	public void setShowTimes(String showTimes) {
		this.showTimes = showTimes;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public List<Show> getShows() {
		return shows;
	}
	public void setShows(List<Show> shows) {
		this.shows = shows;
	}
	public int getWeek() {
		return week;
	}
	public void setWeek(int week) {
		this.week = week;
	}

	@Override
	public String toString() {
		return "MovieEvent [movieEventId=" + movieEventId + ", movieId=" + movieId + ", theatreId=" + theatreId
				+ ", showCount=" + showCount + ", showTimes=" + showTimes + ", city=" + city + ", userName=" + userName
				+ ", shows=" + shows + ", week=" + week + "]";
	}
	
}
