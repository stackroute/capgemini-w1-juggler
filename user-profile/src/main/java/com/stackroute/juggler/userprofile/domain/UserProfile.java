package com.stackroute.juggler.userprofile.domain;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.stackroute.juggler.userprofile.domain.User.UserBuilder;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/*This domain object is used to update the profile fields which are not 
allowed to change does not exist in it to be safe*/

@Document
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class UserProfile {

	@Id
	private int userid;
	// @JsonFormat(shape=JsonFormat.Shape.STRING, pattern="dd-MM-yyyy")
	private String date_of_birth;
	private String[] Languages_known;
	private String[] genre;
	private String location;
	private String[] payment_methods;
	private String[] likes;

}
