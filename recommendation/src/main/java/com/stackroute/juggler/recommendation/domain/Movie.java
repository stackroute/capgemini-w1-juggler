package com.stackroute.juggler.recommendation.domain;

import java.time.LocalDate;
import java.util.List;

import org.neo4j.ogm.annotation.Id;
import org.neo4j.ogm.annotation.NodeEntity;
import org.neo4j.ogm.annotation.Relationship;
import com.fasterxml.jackson.annotation.JsonFormat;



@NodeEntity
public class Movie {
	@Id
	
	private String name;
	public Movie() {}
//public int getId() {
//		return id;
//	}
//	public void setId(int movieId) {
//		this.id = movieId;
//	}
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
	


	public void releasedIn(City city) {
		cities.add(city);
	}

	public void isOfGenre(Genre genre) {
		genres.add(genre);
	}

	public void languageType(Language language) {
		languages.add(language);
	}

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
	public Movie( String name) {
		super();

		this.name = name;
	}

}