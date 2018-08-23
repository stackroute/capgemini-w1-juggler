package com.stackroute.juggler.userprofile.domain;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.stackroute.juggler.userprofile.domain.User.UserBuilder;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Document
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class UserProfile {

	@Id
//	@JsonIgnore
	private int userid;
	// @JsonFormat(shape=JsonFormat.Shape.STRING, pattern="dd-MM-yyyy")
	private String date_of_birth;
	private String[] Languages_known;
	private String[] genre;
	private String location;
	private String[] payment_methods;
	private String[] likes;

}
