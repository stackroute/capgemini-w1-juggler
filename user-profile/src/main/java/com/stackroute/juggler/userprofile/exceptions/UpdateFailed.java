package com.stackroute.juggler.userprofile.exceptions;
//This exception is thrown when the User want to update the profile
//which does not exits in the database
public class UpdateFailed extends Exception{
	
	public UpdateFailed(String s)
	{
		super(s);
	}
}
