package com.stackroute.juggler.userprofile.domain;

//import java.util.Date;
//import javax.annotation.Generated;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
//import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

//these are the annotations for lambok so that we wont use setters and getters

@Document
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class User {
	
	//this user_id is set as id
	@Id
	private int userid;
	private String user_name;
	private String email_id;
	private double mobile_no;
	private String password;
	private String gender;
	//@JsonFormat(shape=JsonFormat.Shape.STRING, pattern="dd-MM-yyyy")
	private String date_of_birth;
	private String[] Languages_known;
	private String[] genre;
	private String location;
	private String[] payment_methods;        
	private String[] likes;

}
