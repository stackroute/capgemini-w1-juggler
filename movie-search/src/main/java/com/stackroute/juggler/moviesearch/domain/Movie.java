package com.stackroute.juggler.moviesearch.domain;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

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
	private String actors;
	private String actress;
	private String directors;
	private String movieGenres;
	private String synopsis;
	private String format;
	private String languages;
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "HH:mm:ss")
	private String movieDuration;
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
	private String movieReleaseDate;
	private List<Theatre> theatres;
	public Movie(String id, String movieName, String moviePoster, String actors, String actress, String directors,
			String movieGenres, String synopsis, String format, String languages, String movieDuration,
			String movieReleaseDate, List<Theatre> theatres) {
		super();
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
		this.theatres = theatres;
	}
	public Movie() {
		super();
		// TODO Auto-generated constructor stub
	}
}
	
	