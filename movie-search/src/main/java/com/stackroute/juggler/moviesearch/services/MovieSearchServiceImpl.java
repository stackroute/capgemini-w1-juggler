package com.stackroute.juggler.moviesearch.services;

import java.util.Iterator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

import com.stackroute.juggler.kafka.domain.City;
import com.stackroute.juggler.kafka.domain.Movie;
import com.stackroute.juggler.moviesearch.exceptions.MovieNotFound;
import com.stackroute.juggler.moviesearch.repository.CityRepository;
import com.stackroute.juggler.moviesearch.repository.MovieRepository;

@Service
public class MovieSearchServiceImpl implements MovieSearchService {

	MovieRepository movieRepository;
	CityRepository cityRepository;
	Movie movie;

	@Autowired
	public MovieSearchServiceImpl(MovieRepository movieRepository, CityRepository cityrepository) {

		this.movieRepository = movieRepository;
		this.cityRepository = cityrepository;
	}

	// save the movie and theaters in city
	@Override
	public String saveCity(City cities) {
		City cityToBeSave = cityRepository.save(cities);
		List<Movie> movies = convertcitytomovie(cities);

		for (Iterator iterator = movies.iterator(); iterator.hasNext();) {
			Movie movie = (Movie) iterator.next();
			Movie moviesaved = movieRepository.save(movie);
		}

		return "saved";

	}

	private List<Movie> convertcitytomovie(City cities) {
		List<Movie> movies = cities.getMovieList();
		return movies;
	}

	// get city by cityName
	@Override
	public City getByCity(String city) {
		City list = cityRepository.getBycityName(city);
		return list;

	}

	// get movie by movieName
	@Override
	public List<Movie> getByTitle(String movieName) throws MovieNotFound {
		boolean result = movieRepository.existsByMovieName(movieName);
		if (result) {
			List<Movie> list = movieRepository.getBymovieName(movieName);
			return list;
		} else
			throw new MovieNotFound("movie not found");

	}

	@Override
	@KafkaListener(topics = "searchdetails", groupId = "user")
	public City consumeKafka(City city) {
		System.out.println(""+city.getCityName());
		return city;

	}

}
