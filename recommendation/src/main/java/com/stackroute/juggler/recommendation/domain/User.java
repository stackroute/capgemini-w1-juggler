package com.stackroute.juggler.recommendation.domain;

import java.util.Arrays;
import java.util.List;

import org.neo4j.ogm.annotation.GeneratedValue;
import org.neo4j.ogm.annotation.Id;
import org.neo4j.ogm.annotation.NodeEntity;
import org.neo4j.ogm.annotation.Relationship;

@NodeEntity
public class User {
	@Id
	private String emailId;
	private String name;
	private String dateOfBirth;
//	private String[] LanguagesKnown;
//	private String[] genre;
//	private String location;
	@Relationship(type = "livesIn", direction = Relationship.OUTGOING)
	private City city;
	@Relationship(type = "follows", direction = Relationship.OUTGOING)
	private List<Genre> genres;
	@Relationship(type = "preferredLanguage", direction = Relationship.OUTGOING)
	private List<Language> languages;

//
//	public int calculateAge(Date date) {
//		if (date == null)
//			return 0;
//		Calendar cal1 = Calendar.getInstance();
//		cal1.setTime(date);
//		Calendar cal2 = Calendar.getInstance();
//		int i = 0;
//		while (cal1.before(cal2)) {
//			cal1.add(Calendar.YEAR, 1);
//			i += 1;
//		}
//		return i;
//	}
//
//	int age = calculateAge(date_of_birth);
	public User() {
	}

	public String getEmailId() {
		return emailId;
	}

	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}

//	public Long getUserId() {
//		return userId;
//	}
//
//	public void setUserId(Long userId) {
//		this.userId = userId;
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

//	public String[] getLanguagesKnown() {
//		return LanguagesKnown;
//	}
//
//	public void setLanguagesKnown(String[] languagesKnown) {
//		LanguagesKnown = languagesKnown;
//	}
//
//	public String[] getGenre() {
//		return genre;
//	}
//
//	public void setGenre(String[] genre) {
//		this.genre = genre;
//	}
//
//	public String getLocation() {
//		return location;
//	}
//
//	public void setLocation(String location) {
//		this.location = location;
//	}

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

	public User(String name, String emailId, String dateOfBirth, City city, List<Genre> genres, List<Language> languages) {
		super();
		this.name = name;
		this.emailId = emailId;
		this.dateOfBirth = dateOfBirth;
//		LanguagesKnown = languagesKnown;
//		this.genre = genre;
//		this.location = location;
		this.city = city;
		this.genres = genres;
		this.languages = languages;
	}

	@Override
	public String toString() {
		return "User [name=" + name + ", emailId=" + emailId + ", dateOfBirth=" + dateOfBirth + ", city=" + city
				+ ", genres=" + genres + ", languages=" + languages + "]";
	}

//	public User(String userName, String emailId, String dateOfBirth, String[] languagesKnown, String[] genre,
//			String location) {
//		super();
//		this.userId = userId;
//		this.name = userName;
//		this.emailId = emailId;
//		this.dateOfBirth = dateOfBirth;
//		this.LanguagesKnown = languagesKnown;
//		this.genre = genre;
//		this.location = location;
//	}

//	@Override
//	public String toString() {
//		return "User [userName=" + name + ", dateOfBirth=" + dateOfBirth + ", LanguagesKnown="
//				+ Arrays.toString(LanguagesKnown) + ", genre=" + Arrays.toString(genre) + ", location=" + location
//				+ "]";
//	}

}
