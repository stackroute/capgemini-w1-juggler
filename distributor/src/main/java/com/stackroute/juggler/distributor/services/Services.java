package com.stackroute.juggler.distributor.services;

import java.util.List;

import com.stackroute.juggler.distributor.domain.Movie;

public interface Services {

	public Movie saveMovie(Movie movie);

	public List<Movie> getByMovieTitle(String movieTitle);

	public List<Movie> getAllMovies();

}
