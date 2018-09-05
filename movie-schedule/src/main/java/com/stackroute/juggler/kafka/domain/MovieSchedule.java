package com.stackroute.juggler.kafka.domain;

import java.io.File;
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
	private File seatLayout;
	private String[] screenedmovies;
	private String[] runningmovies;
	public String id;
	private String movieName;
	private String moviePoster;
	private String actors;
	private String actress;
	private String directors;
	private String movieGenres;
	private String synopsis;
	private String format;
	private String languages;
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "HH:mm:ss")
	private String movieDuration;
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yyy")
	private String movieReleaseDate;

	private int showNumbers;
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "HH:mm")
	private String showTimings;
	private int weekends_Price;
	private int weekdays_Price;

	// default constructor
	public MovieSchedule() {
		super();
	}

	// All arguments constructors
	public MovieSchedule(String theatreId, String theatreName, String theatreLocation, String theatreCity,
			String theatreLicenseNo, String numberOfSeats, Map<String, Integer> seats, File seatLayout,
			String[] screenedmovies, String[] runningmovies, String id, String movieName, String moviePoster,
			String actors, String actress, String directors, String movieGenres, String synopsis, String format,
			String languages, String movieDuration, String movieReleaseDate, int showNumbers, String showTimings,
			int weekends_Price, int weekdays_Price) {
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
		this.id = id;
		this.movieName = movieName;
		this.moviePoster = moviePoster;
		this.actors = actors;
		this.actress = actress;
		this.directors = directors;
		this.movieGenres = movieGenres;
		this.synopsis = synopsis;
		this.format = format;
		this.languages = languages;
		this.movieDuration = movieDuration;
		this.movieReleaseDate = movieReleaseDate;
		this.showNumbers = showNumbers;
		this.showTimings = showTimings;
		this.weekends_Price = weekends_Price;
		this.weekdays_Price = weekdays_Price;
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

	public File getSeatLayout() {
		return seatLayout;
	}

	public void setSeatLayout(File seatLayout) {
		this.seatLayout = seatLayout;
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

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getMovieName() {
		return movieName;
	}

	public void setMovieName(String movieName) {
		this.movieName = movieName;
	}

	public String getMoviePoster() {
		return moviePoster;
	}

	public void setMoviePoster(String moviePoster) {
		this.moviePoster = moviePoster;
	}

	public String getActors() {
		return actors;
	}

	public void setActors(String actors) {
		this.actors = actors;
	}

	public String getActress() {
		return actress;
	}

	public void setActress(String actress) {
		this.actress = actress;
	}

	public String getDirectors() {
		return directors;
	}

	public void setDirectors(String directors) {
		this.directors = directors;
	}

	public String getMovieGenres() {
		return movieGenres;
	}

	public void setMovieGenres(String movieGenres) {
		this.movieGenres = movieGenres;
	}

	public String getSynopsis() {
		return synopsis;
	}

	public void setSynopsis(String synopsis) {
		this.synopsis = synopsis;
	}

	public String getFormat() {
		return format;
	}

	public void setFormat(String format) {
		this.format = format;
	}

	public String getLanguages() {
		return languages;
	}

	public void setLanguages(String languages) {
		this.languages = languages;
	}

	public String getMovieDuration() {
		return movieDuration;
	}

	public void setMovieDuration(String movieDuration) {
		this.movieDuration = movieDuration;
	}

	public String getMovieReleaseDate() {
		return movieReleaseDate;
	}

	public void setMovieReleaseDate(String movieReleaseDate) {
		this.movieReleaseDate = movieReleaseDate;
	}

	public int getShowNumbers() {
		return showNumbers;
	}

	public void setShowNumbers(int showNumbers) {
		this.showNumbers = showNumbers;
	}

	public String getShowTimings() {
		return showTimings;
	}

	public void setShowTimings(String showTimings) {
		this.showTimings = showTimings;
	}

	public int getWeekends_Price() {
		return weekends_Price;
	}

	public void setWeekends_Price(int weekends_Price) {
		this.weekends_Price = weekends_Price;
	}

	public int getWeekdays_Price() {
		return weekdays_Price;
	}

	public void setWeekdays_Price(int weekdays_Price) {
		this.weekdays_Price = weekdays_Price;
	}

	@Override
	public String toString() {
		return "MovieSchedule [theatreId=" + theatreId + ", theatreName=" + theatreName + ", theatreLocation="
				+ theatreLocation + ", theatreCity=" + theatreCity + ", theatreLicenseNo=" + theatreLicenseNo
				+ ", numberOfSeats=" + numberOfSeats + ", seats=" + seats + ", seatLayout=" + seatLayout
				+ ", screenedmovies=" + Arrays.toString(screenedmovies) + ", runningmovies="
				+ Arrays.toString(runningmovies) + ", id=" + id + ", movieName=" + movieName + ", moviePoster="
				+ moviePoster + ", actors=" + actors + ", actress=" + actress + ", directors=" + directors
				+ ", movieGenres=" + movieGenres + ", synopsis=" + synopsis + ", format=" + format + ", languages="
				+ languages + ", movieDuration=" + movieDuration + ", movieReleaseDate=" + movieReleaseDate
				+ ", showNumbers=" + showNumbers + ", showTimings=" + showTimings + ", weekends_Price=" + weekends_Price
				+ ", weekdays_Price=" + weekdays_Price + "]";
	}

}
