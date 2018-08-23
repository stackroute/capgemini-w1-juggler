package com.stackroute.juggler.distributor.domain;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;



//Domain object for movie details given by the distributor
@Document
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Movie {
	@Id
	public String id;
	private String movieName;
	private String moviePoster;
	private String movieReleaseDate;
	private String movieDuration;
	private String hero;
	private String heroine;
	private String director;
	private String[] movieGenre;
	private String synopsis;
	private String format;
	private String[] language;
		
	
	public Movie(String id, String movieName, String moviePoster, String movieReleaseDate, String movieDuration,
			String hero, String heroine, String director, String[] movieGenre, String synopsis, String format,
			String[] language) {
		this.id = id;
		this.movieName = movieName;
		this.moviePoster = moviePoster;
		this.movieReleaseDate = movieReleaseDate;
		this.movieDuration = movieDuration;
		this.hero = hero;
		this.heroine = heroine;
		this.director = director;
		this.movieGenre = movieGenre;
		this.synopsis = synopsis;
		this.format = format;
		this.language = language;
	}
	
	public Movie() {
		
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
	public String getMovieReleaseDate() {
		return movieReleaseDate;
	}
	public void setMovieReleaseDate(String movieReleaseDate) {
		this.movieReleaseDate = movieReleaseDate;
	}
	public String getMovieDuration() {
		return movieDuration;
	}
	public void setMovieDuration(String movieDuration) {
		this.movieDuration = movieDuration;
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
	public String[] getMovieGenre() {
		return movieGenre;
	}
	public void setMovieGenre(String[] movieGenre) {
		this.movieGenre = movieGenre;
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
	public String[] getLanguage() {
		return language;
	}
	public void setLanguage(String[] language) {
		this.language = language;
	}
	
	
}
