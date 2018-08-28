package com.stackroute.juggler.recommendation.domain;


import java.util.Calendar;
import java.util.Date;
import java.util.List;

import org.neo4j.ogm.annotation.Id;
import org.neo4j.ogm.annotation.NodeEntity;
import org.neo4j.ogm.annotation.Relationship;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@NodeEntity
public class User {

	private int userId;
	@Id
	private String userName;
	private Date date_of_birth;
	
public int calculateAge(Date date) {
    if (date == null)
        return 0;
    Calendar cal1 = Calendar.getInstance();
    cal1.setTime(date);
    Calendar cal2 = Calendar.getInstance();
    int i = 0;
    while (cal1.before(cal2)) {
        cal1.add(Calendar.YEAR, 1);
        i += 1;
    }
    return i;
}
public User(int userId, String userName, Date date_of_birth, City city) {
	super();
	this.setUserId(userId);
	this.setUserName(userName);
	this.date_of_birth = date_of_birth;
	this.city = city;
}
public int getUserId() {
	return userId;
}
public void setUserId(int userId) {
	this.userId = userId;
}
public String getUserName() {
	return userName;
}
public void setUserName(String userName) {
	this.userName = userName;
}
int age=calculateAge(date_of_birth);
@Relationship(type = "follows", direction = Relationship.OUTGOING)
private List<Genre> genres;
@Relationship(type = "livesIn", direction = Relationship.OUTGOING)
private City city;
@Relationship(type = "prefferedLanguage", direction = Relationship.OUTGOING)
private List<Language> languages;

}
