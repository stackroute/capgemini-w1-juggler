package com.stackroute.juggler.moviesearch.services;

import java.util.List;

import com.stackroute.juggler.kafka.domain.City;
import com.stackroute.juggler.kafka.domain.Movie;
import com.stackroute.juggler.moviesearch.exceptions.MovieNotFound;

public interface MovieSearchService {

	public String saveCity(City city);

	public City getByCity(String city);

	public List<Movie> getByTitle(String movieName) throws MovieNotFound;

	public City consumeKafka(City city);
}
