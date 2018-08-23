package com.stackroute.juggler.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.stackroute.juggler.domain.City;
import com.stackroute.juggler.domain.Movie;
import com.stackroute.juggler.repository.CityRepository;
import com.stackroute.juggler.repository.MovieRepository;

@Service
public class MovieSearchServiceImpl implements MovieSearchService {

	MovieRepository movieRepository;
	CityRepository cityRepository;

	@Autowired
	public MovieSearchServiceImpl(MovieRepository movieRepository, CityRepository cityrepository) {

		this.movieRepository = movieRepository;
		this.cityRepository = cityrepository;
	}

	@Override
	public List<Movie> getByTitle(String movieName) {

		List<Movie> list = movieRepository.getBymovieName(movieName);
		return list;
	}

	@Override
	public Movie saveMovie(Movie movie)  {

			Movie movieSaved = movieRepository.save(movie);
			return movieSaved;
		
	}

	@Override
	public Iterable<Movie> getByCity(String city) {

		Iterable<Movie> list = cityRepository.getAllMoviesByCity(city);
		return list;
	}

	@Override
	public City saveCity(City city) {
		City cityToBeSave = cityRepository.save(city);
		return cityToBeSave;
	}
}
