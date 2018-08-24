package com.stackroute.juggler.domain;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;


/*
 * pojo for movie
 */

@Document

public class Movie {
	
	@Id
	private int id;
	private String movieName;
	private String moviePoster;
	private String synopsis;
	private LocalDate movieReleasedate;
	private String movieDuration;
	private String[] language;
	private String[] movieGenre;
	private String format;
	private String hero;
	private String heroine;
	private String director;
	private List<Theatre> theatres;
	
	
	


	public int getId() {
		return id;
	}

	public void setId(int id) {
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

	public String getSynopsis() {
		return synopsis;
	}

	public void setSynopsis(String synopsis) {
		this.synopsis = synopsis;
	}

	public LocalDate getMovieReleasedate() {
		return movieReleasedate;
	}

	public void setMovieReleasedate(LocalDate movieReleasedate) {
		this.movieReleasedate = movieReleasedate;
	}

	public String getMovieDuration() {
		return movieDuration;
	}

	public void setMovieDuration(String movieDuration) {
		this.movieDuration = movieDuration;
	}

	public String[] getLanguage() {
		return language;
	}

	public void setLanguage(String[] language) {
		this.language = language;
	}

	public String[] getMovieGenre() {
		return movieGenre;
	}

	public void setMovieGenre(String[] movieGenre) {
		this.movieGenre = movieGenre;
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

	public List<Theatre> getTheatres() {
		return theatres;
	}

	public void setTheatres(List<Theatre> theatres) {
		this.theatres = theatres;
	}

	@Override
	public String toString() {
		return "Movie [id=" + id + ", movieName=" + movieName + ", moviePoster=" + moviePoster + ", synopsis="
				+ synopsis + ", movieReleasedate=" + movieReleasedate + ", movieDuration=" + movieDuration
				+ ", language=" + Arrays.toString(language) + ", movieGenre=" + Arrays.toString(movieGenre)
				+ ", format=" + format + ", hero=" + hero + ", heroine=" + heroine + ", director=" + director
				+ ", theatres=" + theatres + "]";
	}



	

	
	


}
