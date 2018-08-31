package com.stackroute.juggler.recommendation.domain;

import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import org.neo4j.ogm.annotation.GeneratedValue;
import org.neo4j.ogm.annotation.Id;
import org.neo4j.ogm.annotation.NodeEntity;
import org.neo4j.ogm.annotation.Relationship;

@NodeEntity
public class User {

//	@GeneratedValue
//	private Long nodeId;
//	private String userName;
	@Id
	@GeneratedValue
private Long nodeId;
	private String name;
	private String emailId;
	private String dateOfBirth;
//	private String likes;
	private String[] LanguagesKnown;
	private String[] genre;
	private String location;
	public User(String name, String emailId, String dateOfBirth, String[] languagesKnown, String[] genre,
			String location, City city, List<Genre> genres, List<Language> languages) {
		super();
		this.name = name;
		this.emailId = emailId;
		this.dateOfBirth = dateOfBirth;
		LanguagesKnown = languagesKnown;
		this.genre = genre;
		this.location = location;
		this.city = city;
		this.genres = genres;
		this.languages = languages;
	}

	@Relationship(type = "livesIn", direction = Relationship.OUTGOING)
	private City city;
	@Relationship(type = "follows", direction = Relationship.OUTGOING)
	private List<Genre> genres;
	@Relationship(type = "preferredLanguage", direction = Relationship.OUTGOING)
	private List<Language> languages;

	public City getCity() {
		return city;
	}

	public void setCity(City city) {
		this.city = city;
	}

	public List<Genre> getGenres() {
		return genres;
	}

	public void setGenres(List<Genre> genres) {
		this.genres = genres;
	}

	public List<Language> getLanguages() {
		return languages;
	}

	public void setLanguages(List<Language> languages) {
		this.languages = languages;
	}

//	public Long getNodeId() {
//		return nodeId;
//	}
//	public void setNodeId(Long nodeId) {
//		this.nodeId = nodeId;
//	}
	public String getName() {
		return name;
	}

	public void setName(String userName) {
		this.name = userName;
	}

	public String getDateOfBirth() {
		return dateOfBirth;
	}

	public void setDateOfBirth(String dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}

//	public String getLikes() {
//		return likes;
//	}
//	public void setLikes(String likes) {
//		this.likes = likes;
//	}
	public String[] getLanguagesKnown() {
		return LanguagesKnown;
	}

	public void setLanguagesKnown(String[] languagesKnown) {
		LanguagesKnown = languagesKnown;
	}

	public String[] getGenre() {
		return genre;
	}

	public void setGenre(String[] genre) {
		this.genre = genre;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	@Override
	public String toString() {
		return "User [name=" + name + ", emailId=" + emailId + ", dateOfBirth=" + dateOfBirth + ", LanguagesKnown="
				+ Arrays.toString(LanguagesKnown) + ", genre=" + Arrays.toString(genre) + ", location=" + location
				+ "]";
	}

	public User(String userName, String emailId, String dateOfBirth, String[] languagesKnown, String[] genre,
			String location) {
		super();
		this.name = userName;
		this.emailId = emailId;
		this.dateOfBirth = dateOfBirth;
//		this.likes = likes;
		this.LanguagesKnown = languagesKnown;
		this.genre = genre;
		this.location = location;
	}

	public User() {
		super();
	}

}
