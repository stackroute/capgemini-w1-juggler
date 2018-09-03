//package com.stackroute.juggler.recommendation.domain;
//
//import java.io.File;
//import java.util.List;
//import java.util.Map;
//
//import org.springframework.data.annotation.Id;
//import com.fasterxml.jackson.annotation.JsonFormat;
//
//public class Theatre {
//	@Id
//	private String theatreId;
//	private String theatreName;
//	private String theatreLocation;
//
//	private File seatLayout;
//	private int showNumbers;
//	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "HH:mm")
//	private String showTimings;
//	private int weekends_Price;
//	private int weekdays_Price;
//	private Map<String, Integer> seats;
//	private String[] screenedmovies;
//	private String[] runningmovies;
//
//	// All Arguments constructor
//	
//
//	public Theatre(String theatreId, String theatreName, String theatreLocation, File seatLayout, int showNumbers,
//			String showTimings, int weekends_Price, int weekdays_Price, Map<String, Integer> seats,
//			String[] screenedmovies, String[] runningmovies) {
//		super();
//		this.theatreId = theatreId;
//		this.theatreName = theatreName;
//		this.theatreLocation = theatreLocation;
//		this.seatLayout = seatLayout;
//		this.showNumbers = showNumbers;
//		this.showTimings = showTimings;
//		this.weekends_Price = weekends_Price;
//		this.weekdays_Price = weekdays_Price;
//		this.seats = seats;
//		this.screenedmovies = screenedmovies;
//		this.runningmovies = runningmovies;
//	}
//
//	// List of all getters and setters
//
//	public String getTheatreId() {
//		return theatreId;
//	}
//
//	public void setTheatreId(String theatreId) {
//		this.theatreId = theatreId;
//	}
//
//	public String getTheatreName() {
//		return theatreName;
//	}
//
//	public void setTheatreName(String theatreName) {
//		this.theatreName = theatreName;
//	}
//
//	public String getTheatreLocation() {
//		return theatreLocation;
//	}
//
//	public void setTheatreLocation(String theatreLocation) {
//		this.theatreLocation = theatreLocation;
//	}
//
//	public File getSeatLayout() {
//		return seatLayout;
//	}
//
//	public void setSeatLayout(File seatLayout) {
//		this.seatLayout = seatLayout;
//	}
//
//	public int getShowNumbers() {
//		return showNumbers;
//	}
//
//	public void setShowNumbers(int showNumbers) {
//		this.showNumbers = showNumbers;
//	}
//
//	public String getShowTimings() {
//		return showTimings;
//	}
//
//	public void setShowTimings(String showTimings) {
//		this.showTimings = showTimings;
//	}
//
//	public int getWeekends_Price() {
//		return weekends_Price;
//	}
//
//	public void setWeekends_Price(int weekends_Price) {
//		this.weekends_Price = weekends_Price;
//	}
//
//	public int getWeekdays_Price() {
//		return weekdays_Price;
//	}
//
//	public void setWeekdays_Price(int weekdays_Price) {
//		this.weekdays_Price = weekdays_Price;
//	}
//
//	public Map<String, Integer> getSeats() {
//		return seats;
//	}
//
//	public void setSeats(Map<String, Integer> seats) {
//		this.seats = seats;
//	}
//
//	public String[] getScreenedmovies() {
//		return screenedmovies;
//	}
//
//	public void setScreenedmovies(String[] screenedmovies) {
//		this.screenedmovies = screenedmovies;
//	}
//
//	public String[] getRunningmovies() {
//		return runningmovies;
//	}
//
//	public void setRunningmovies(String[] runningmovies) {
//		this.runningmovies = runningmovies;
//	}
//	
//
//	public Theatre() {
//		super();
//	}
//
//
//}