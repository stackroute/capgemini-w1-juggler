package com.stackroute.juggler.distributor.services;

import org.springframework.beans.factory.annotation.Autowired;

import com.stackroute.juggler.distributor.domain.Movie;
import com.stackroute.juggler.distributor.repositary.MovieRepositary;

public class MovieServicesImpl implements  MovieServices{
	
	private MovieRepositary movieRepositary;

	@Autowired
	public MovieServicesImpl(MovieRepositary movieRepository) {
		this.movieRepositary = movieRepositary;
	}
	
	@Override
	public Movie saveMovie(Movie movie) {
		Movie savedMovie = movieRepositary.save(movie);
		return savedMovie;
	}

}
