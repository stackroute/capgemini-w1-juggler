package com.stackroute.juggler.userprofile.domain;

import java.util.Arrays;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

/*This domain object is used to update the profile fields which are not 
allowed to change does not exist in it to be safe*/

@Document
public class UserProfile {

	@Id
	private int userd;
	private String dateOfBirth;
	private String[] LanguagesKnown;
	private String[] genre;
	private String location;
	private String[] paymentMethods;
	private String[] likes;
	public int getUserd() {
		return userd;
	}
	public void setUserd(int userd) {
		this.userd = userd;
	}
	public String getDateOfBirth() {
		return dateOfBirth;
	}
	public void setDateOfBirth(String dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
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
	public String[] getPaymentMethods() {
		return paymentMethods;
	}
	public void setPaymentMethods(String[] paymentMethods) {
		this.paymentMethods = paymentMethods;
	}
	public String[] getLikes() {
		return likes;
	}
	public void setLikes(String[] likes) {
		this.likes = likes;
	}
	@Override
	public String toString() {
		return "UserProfile [userd=" + userd + ", dateOfBirth=" + dateOfBirth + ", LanguagesKnown="
				+ Arrays.toString(LanguagesKnown) + ", genre=" + Arrays.toString(genre) + ", location=" + location
				+ ", paymentMethods=" + Arrays.toString(paymentMethods) + ", likes=" + Arrays.toString(likes) + "]";
	}
	public UserProfile(int userd, String dateOfBirth, String[] languagesKnown, String[] genre, String location,
			String[] paymentMethods, String[] likes) {
		super();
		this.userd = userd;
		this.dateOfBirth = dateOfBirth;
		LanguagesKnown = languagesKnown;
		this.genre = genre;
		this.location = location;
		this.paymentMethods = paymentMethods;
		this.likes = likes;
	}
	public UserProfile() {
		super();
	}
	

}
