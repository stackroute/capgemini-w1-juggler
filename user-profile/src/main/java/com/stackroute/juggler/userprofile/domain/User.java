package com.stackroute.juggler.userprofile.domain;

import javax.validation.constraints.Size;
import org.springframework.data.annotation.Id;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

//these are the annotations for lambok so that we wont use setters and getters
//This domain object is used to save the data ie., interact with the database
//Password is ignored and not saved into database but published in the message bus

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class User {

	// this user_id is set as id
	@Id
	private int userId;
	@Size(min = 6, max = 20)
	private String userName;
	private String emailId;
	private double mobileNo;
	@Size(min = 8, max = 20)
	private String password;
	private String gender;
	private String dateOfBirth;
	private String[] LanguagesKnown;
	private String[] genre;
	private String location;
	private String[] paymentMethods;
	private String likes;

}
