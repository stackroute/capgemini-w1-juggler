package com.stackroute.juggler.recommendation.domain;

import java.time.LocalDate;
import java.util.List;

import org.neo4j.ogm.annotation.Id;
import org.neo4j.ogm.annotation.NodeEntity;
import org.neo4j.ogm.annotation.Relationship;
import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
@Getter
@Setter
@ToString

@AllArgsConstructor
@NodeEntity
public class Movie {
	@Id
	private int id;
	private String name;
	public Movie() {}
public int getId() {
		return id;
	}
	public void setId(int movieId) {
		this.id = movieId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
//	private int movieId;
	//	private String movieTitle;
//private String moviePoster;
//	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
//	private LocalDate releaseDate;
//
	@Relationship(type = "isTypeOf", direction = Relationship.OUTGOING)
	private List<Genre> genres;
	@Relationship(type = "releasedIn", direction = Relationship.OUTGOING)
	private List<City> cities;
	@Relationship(type = "languageType", direction = Relationship.OUTGOING)
	private List<Language> languages;
//	public Movie() {}
//	
//
//	
//
//	public Movie(int movieId, String movieTitle, String moviePoster, LocalDate releaseDate) {
//		super();
//		this.movieId = movieId;
//		this.movieTitle = movieTitle;
//		this.moviePoster = moviePoster;
//		this.releaseDate = releaseDate;
//	}
//
//
//
//
	public void releasedIn(City city) {
		cities.add(city);
	}

	public void isOfGenre(Genre genre) {
		genres.add(genre);
	}

	public void languageType(Language language) {
		languages.add(language);
	}
//
//
//
//
//	public int getMovieId() {
//		return movieId;
//	}
//
//
//
//
//	public void setMovieId(int movieId) {
//		this.movieId = movieId;
//	}
//
//
//
//
//	public String getMovieTitle() {
//		return movieTitle;
//	}
//
//
//
//
//	public void setMovieTitle(String movieTitle) {
//		this.movieTitle = movieTitle;
//	}
//
//
//
//
//	public String getMoviePoster() {
//		return moviePoster;
//	}
//
//
//
//
//	public void setMoviePoster(String moviePoster) {
//		this.moviePoster = moviePoster;
//	}
//
//
//
//
//	public LocalDate getReleaseDate() {
//		return releaseDate;
//	}
//
//
//
//
//	public void setReleaseDate(LocalDate releaseDate) {
//		this.releaseDate = releaseDate;
//	}
//
//
//
//
	public List<Genre> getGenres() {
		return genres;
	}




	public void setGenres(List<Genre> genres) {
		this.genres = genres;
	}




	public List<City> getCities() {
		return cities;
	}




	public void setCities(List<City> cities) {
		this.cities = cities;
	}




	public List<Language> getLanguages() {
		return languages;
	}




	public void setLanguages(List<Language> languages) {
		this.languages = languages;
	}
	public Movie(int movieId, String name) {
		super();
		this.id = movieId;
		this.name = name;
	}

}