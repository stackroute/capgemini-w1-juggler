package com.stackroute.juggler.kafka.domain;

import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import org.neo4j.ogm.annotation.Id;
import org.neo4j.ogm.annotation.NodeEntity;
import org.neo4j.ogm.annotation.Relationship;

@NodeEntity
public class User {
	private String userName;
	private String dateOfBirth;
	private String likes;
	private String[] LanguagesKnown;
	private String[] genre;
	private String location;

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

	public User(String userName, String dateOfBirth, String likes, String[] languagesKnown, String[] genre,
			String location) {
		super();
		this.userName = userName;
		this.dateOfBirth = dateOfBirth;
		this.likes = likes;
		LanguagesKnown = languagesKnown;
		this.genre = genre;
		this.location = location;
	}
	@Override
    public String toString() {
        return "InputUser [userName=" + userName + ", dateOfBirth=" + dateOfBirth + ", LanguagesKnown="
                + Arrays.toString(LanguagesKnown) + ", genre=" + Arrays.toString(genre) + ", location=" + location
                +  ", likes=" + likes + "]";
    }

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getDateOfBirth() {
		return dateOfBirth;
	}

	public void setDateOfBirth(String dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}

	public String getLikes() {
		return likes;
	}

	public void setLikes(String likes) {
		this.likes = likes;
	}

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

}
