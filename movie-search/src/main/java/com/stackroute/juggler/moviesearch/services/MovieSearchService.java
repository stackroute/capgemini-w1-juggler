package com.stackroute.juggler.moviesearch.services;

import java.util.List;

import com.stackroute.juggler.moviesearch.domain.City;
import com.stackroute.juggler.moviesearch.domain.Movie;



public interface MovieSearchService {
	public City saveCity(City city);
	public List<City> getByCity(String city);
	public List<Movie> getByTitle(String movieName);
	public City consumeKafka(City city);
}
