package com.stackroute.juggler.moviesearch.exceptions;

public class MovieNotFound extends Exception {
	// throws MovieNotFound exception, if Movie is not found
		public MovieNotFound(String s) {
			super(s);
		}
}
