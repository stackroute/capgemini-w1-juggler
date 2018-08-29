package com.stackroute.juggler.theatreregistration.exceptions;

public class TheatreAlreadyExists extends Exception {

	// throws TheatreAlreadyExists exception, if the theatre with same name is posted
	public TheatreAlreadyExists(String s) {
		super(s);
	}

}