package com.stackroute.juggler.theatreregistration.exceptions;

public class TheatreAlreadyExists extends Exception {

	// throws TTheatreAlreadyExists exception, if the theatre if same name is posted
	public TheatreAlreadyExists(String s) {
		super(s);
	}

}