package com.stackroute.juggler.ticketengine.domain;

import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.redis.core.RedisHash;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.stackroute.juggler.kafka.domain.MovieSchedule;
import com.stackroute.juggler.kafka.domain.Seats;

@RedisHash("Seats")
public class RedisObject {

	
	private String Id;
	private String theatreId;
	private String email;
	private String theatreLocation;
	private String theatreCity;
	private String theatreName;
	private String theatreLicenseNo;
	private String totalnumberOfSeats;
	private String[] screenedmovies;
	private String[] runningmovies;
	private Seats seatLayout;
	private String[] typesOfSeats;
	private int[] numberOfSeats;
	public String movieId;
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
	private int[] weekends_Price;
	private int[] weekdays_Price;
	private List<Integer> bookedSeats;
	private List<Integer> blockedSeats;

	public RedisObject() {

	}

	public RedisObject(MovieSchedule movieSchedule) {

		this.theatreId = movieSchedule.getTheatreId();
		this.email = movieSchedule.getEmail();
		this.theatreLocation = movieSchedule.getTheatreLocation();
		this.theatreCity = movieSchedule.getTheatreCity();
		this.theatreName = movieSchedule.getTheatreName();
		this.theatreLicenseNo = movieSchedule.getTheatreLicenseNo();
		this.totalnumberOfSeats = movieSchedule.getTotalnumberOfSeats();
		this.screenedmovies = movieSchedule.getScreenedmovies();
		this.runningmovies = movieSchedule.getRunningmovies();
		this.seatLayout = movieSchedule.getSeatLayout();
		this.typesOfSeats = movieSchedule.getTypesOfSeats();
		this.numberOfSeats = movieSchedule.getNumberOfSeats();
		this.movieId = movieSchedule.getId();
		this.movieName = movieSchedule.getMovieName();
		this.moviePoster = movieSchedule.getMoviePoster();
		this.actors = movieSchedule.getActors();
		this.actress = movieSchedule.getActress();
		this.directors = movieSchedule.getDirectors();
		this.movieGenres = movieSchedule.getMovieGenres();
		this.synopsis = movieSchedule.getSynopsis();
		this.format = movieSchedule.getFormat();
		this.languages = movieSchedule.getLanguages();
		this.movieDuration = movieSchedule.getMovieDuration();
		this.movieReleaseDate = movieSchedule.getMovieReleaseDate();
		this.showNumbers = movieSchedule.getShowNumbers();
		this.showTimings = movieSchedule.getShowTimings();
		this.weekends_Price = movieSchedule.getWeekends_Price();
		this.weekdays_Price = movieSchedule.getWeekdays_Price();
		this.blockedSeats = null;
		this.bookedSeats = null;
	}

	public RedisObject(String Id, String theatreId, String email, String theatreLocation, String theatreCity,
			String theatreName, String theatreLicenseNo, String totalnumberOfSeats, String[] screenedmovies,
			String[] runningmovies, Seats seatLayout, String[] typesOfSeats, int[] numberOfSeats, String id,
			String movieName, String moviePoster, String actors, String actress, String directors, String movieGenres,
			String synopsis, String format, String languages, String movieDuration, String movieReleaseDate,
			int showNumbers, String showTimings, int[] weekends_Price, int[] weekdays_Price, List<Integer> bookedSeats,
			List<Integer> blockedSeats) {
		this.Id = Id;
		this.theatreId = theatreId;
		this.email = email;
		this.theatreLocation = theatreLocation;
		this.theatreCity = theatreCity;
		this.theatreName = theatreName;
		this.theatreLicenseNo = theatreLicenseNo;
		this.totalnumberOfSeats = totalnumberOfSeats;
		this.screenedmovies = screenedmovies;
		this.runningmovies = runningmovies;
		this.seatLayout = seatLayout;
		this.typesOfSeats = typesOfSeats;
		this.numberOfSeats = numberOfSeats;
		this.movieId = id;
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
		this.bookedSeats = bookedSeats;
		this.blockedSeats = blockedSeats;
	}

	public String getId() {
		return Id;
	}

	public void setId(String id) {
		Id = id;
	}

	public String getTheatreId() {
		return theatreId;
	}

	public void setTheatreId(String theatreId) {
		this.theatreId = theatreId;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
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

	public String getTotalnumberOfSeats() {
		return totalnumberOfSeats;
	}

	public void setTotalnumberOfSeats(String totalnumberOfSeats) {
		this.totalnumberOfSeats = totalnumberOfSeats;
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

	public Seats getSeatLayout() {
		return seatLayout;
	}

	public void setSeatLayout(Seats seatLayout) {
		this.seatLayout = seatLayout;
	}

	public String[] getTypesOfSeats() {
		return typesOfSeats;
	}

	public void setTypesOfSeats(String[] typesOfSeats) {
		this.typesOfSeats = typesOfSeats;
	}

	public int[] getNumberOfSeats() {
		return numberOfSeats;
	}

	public void setNumberOfSeats(int[] numberOfSeats) {
		this.numberOfSeats = numberOfSeats;
	}

	public String getMovieId() {
		return movieId;
	}

	public void setMovieId(String id) {
		this.movieId = id;
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

	public int[] getWeekends_Price() {
		return weekends_Price;
	}

	public void setWeekends_Price(int[] weekends_Price) {
		this.weekends_Price = weekends_Price;
	}

	public int[] getWeekdays_Price() {
		return weekdays_Price;
	}

	public void setWeekdays_Price(int[] weekdays_Price) {
		this.weekdays_Price = weekdays_Price;
	}

	public List<Integer> getBookedSeats() {
		return bookedSeats;
	}

	public void setBookedSeats(List<Integer> bookedSeats) {
		this.bookedSeats = bookedSeats;
	}

	public List<Integer> getBlockedSeats() {
		return blockedSeats;
	}

	public void setBlockedSeats(List<Integer> blockedSeats) {
		this.blockedSeats = blockedSeats;
	}

}
