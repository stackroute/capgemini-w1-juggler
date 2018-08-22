package com.stackroute.juggler.services;

import java.util.List;

import com.stackroute.juggler.domain.Movie;

public interface MovieSearchService {
	
	public List<Movie> getByTitle(String movieName);
}
