package com.stackroute.juggler.userprofile.exceptions;

//This exception is thrown when the User want to view the profile
//which does not exits in the database
public class UserDoesNotExists extends Exception {
	
	public UserDoesNotExists(String s)
	{
		super(s);
	}

}
