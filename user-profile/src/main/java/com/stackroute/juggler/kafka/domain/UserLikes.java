package com.stackroute.juggler.kafka.domain;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;


//@Data
//@NoArgsConstructor
//@AllArgsConstructor
//@Builder
@Document
public class UserLikes {
	

	@Id
	private int userId;
	private String movie;
	
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public String getMovie() {
		return movie;
	}
	public void setMovie(String movie) {
		this.movie = movie;
	}
	@Override
	public String toString() {
		return "UserLikes [userId=" + userId + ", movie=" + movie + "]";
	}
	public UserLikes(int userId, String movie) {
		super();
		this.userId = userId;
		this.movie = movie;
	}
	public UserLikes() {
		super();
	}
	

}
