package com.stackroute.juggler.services;

import java.util.List;

import com.stackroute.juggler.domain.City;
import com.stackroute.juggler.domain.Movie;

public interface MovieSearchService {
	
//	public List<Movie> getByTitle(String movieName);
	public Movie saveMovie(Movie movie);
	public City saveCity(City city);
//	public List<City> getByCity(String city);
//	public List<Movie> getAllMovies();
}
