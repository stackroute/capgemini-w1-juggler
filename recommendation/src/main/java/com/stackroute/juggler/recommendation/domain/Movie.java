package com.stackroute.juggler.recommendation.domain;

import java.io.File;
import java.time.LocalDate;
import java.util.List;

import org.neo4j.ogm.annotation.Relationship;
import org.springframework.data.annotation.Id;

public class Movie {
	@Id
	private String movieId;
	private String name;
	private File moviePoster;
	private String synopsis;
	private String movieReleasedate;
	private String movieDuration;
	private String format;
	private String hero;
	private String heroine;
	private String director;
	@Relationship(type = "releasedIn", direction = Relationship.OUTGOING)
	private City city;
	@Relationship(type = "isTypeOf", direction = Relationship.OUTGOING)
	private Genre genre;
	@Relationship(type = "LanguageType", direction = Relationship.OUTGOING)
	private Language languages;
//	private List<Theatre> theatres;

	// All Arguments constructor
	public Movie(String movieId, String movieName, File moviePoster, String synopsis, String movieReleasedate,
			String movieDuration,String format, String hero, String heroine,
			String director) {
		super();
		this.movieId = movieId;
		this.name = movieName;
		this.moviePoster = moviePoster;
		this.synopsis = synopsis;
		this.movieReleasedate = movieReleasedate;
		this.movieDuration = movieDuration;
//		this.language = language;
//		this.movieGenre = movieGenre;
		this.format = format;
		this.hero = hero;
		this.heroine = heroine;
		this.director = director;
//		this.theatres = theatres;
	}
	public Movie() {
		super();
	}
	// List of all getters and setters
	public String getName() {
		return name;
	}

	public void setName(String movieName) {
		this.name = movieName;
	}

	public File getMoviePoster() {
		return moviePoster;
	}

	public void setMoviePoster(File moviePoster) {
		this.moviePoster = moviePoster;
	}

	public String getSynopsis() {
		return synopsis;
	}

	public void setSynopsis(String synopsis) {
		this.synopsis = synopsis;
	}

	public String getMovieReleasedate() {
		return movieReleasedate;
	}

	public void setMovieReleasedate(String movieReleasedate) {
		this.movieReleasedate = movieReleasedate;
	}

	public String getMovieDuration() {
		return movieDuration;
	}

	public void setMovieDuration(String movieDuration) {
		this.movieDuration = movieDuration;
	}

	
	public String getMovieId() {
		return movieId;
	}
	public void setMovieId(String movieId) {
		this.movieId = movieId;
	}
	public City getCity() {
		return city;
	}
	public void setCity(City city) {
		this.city = city;
	}
	public Genre getGenre() {
		return genre;
	}
	public void setGenre(Genre genre) {
		this.genre = genre;
	}
	public Language getLanguages() {
		return languages;
	}
	public void setLanguages(Language languages) {
		this.languages = languages;
	}
	public String getFormat() {
		return format;
	}

	public void setFormat(String format) {
		this.format = format;
	}

	public String getHero() {
		return hero;
	}

	public void setHero(String hero) {
		this.hero = hero;
	}

	public String getHeroine() {
		return heroine;
	}

	public void setHeroine(String heroine) {
		this.heroine = heroine;
	}

	public String getDirector() {
		return director;
	}

	public void setDirector(String director) {
		this.director = director;
	}
	public Movie(String movieId, String name, File moviePoster, String synopsis, String movieReleasedate,
			String movieDuration, String format, String hero, String heroine, String director, City city, Genre genre,
			Language languages) {
		super();
		this.movieId = movieId;
		this.name = name;
		this.moviePoster = moviePoster;
		this.synopsis = synopsis;
		this.movieReleasedate = movieReleasedate;
		this.movieDuration = movieDuration;
		this.format = format;
		this.hero = hero;
		this.heroine = heroine;
		this.director = director;
		this.city = city;
		this.genre = genre;
		this.languages = languages;
	}
	@Override
	public String toString() {
		return "Movie [movieId=" + movieId + ", name=" + name + ", moviePoster=" + moviePoster + ", synopsis="
				+ synopsis + ", movieReleasedate=" + movieReleasedate + ", movieDuration=" + movieDuration + ", format="
				+ format + ", hero=" + hero + ", heroine=" + heroine + ", director=" + director + ", city=" + city
				+ ", genre=" + genre + ", languages=" + languages + "]";
	}

//	public List<Theatre> getTheatres() {
//		return theatres;
//	}
//
//	public void setTheatres(List<Theatre> theatres) {
//		this.theatres = theatres;
//	}

	

	
}