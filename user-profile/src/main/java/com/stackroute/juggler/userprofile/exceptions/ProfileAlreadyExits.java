package com.stackroute.juggler.userprofile.exceptions;

//This exception is thrown when the User want to create the profile
//which already exits in the database
public class ProfileAlreadyExits extends Exception {

	public ProfileAlreadyExits(String s) {
		super(s);
	}

}
