package com.stackroute.juggler.moviesearch.services;

import java.util.Iterator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

import com.stackroute.juggler.moviesearch.domain.City;
import com.stackroute.juggler.moviesearch.domain.Movie;
import com.stackroute.juggler.moviesearch.repository.CityRepository;
import com.stackroute.juggler.moviesearch.repository.MovieRepository;


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
	public String saveCity(City cities) {
		City cityToBeSave = cityRepository.save(cities);
		List<Movie> movies =convertcitytomovie(cities);

		for (Iterator iterator = movies.iterator(); iterator.hasNext();) {
			Movie movie = (Movie) iterator.next();
			Movie moviesaved = movieRepository.save(movie);
		}
		
		return "saved";
	}

	private List<Movie> convertcitytomovie(City cities) {
		List<Movie>  movies = cities.getMovieList();
		return movies;
	}

	@Override
	public List<City> getByCity(String city) {
		List<City> list = cityRepository.getBycityName(city);
		return list;
		
	}

	@Override
	public List<Movie> getByTitle(String movieName) {
		List<Movie> list = movieRepository.getBymovieName(movieName);
		return list;
		
	}
	
	@Override
    @KafkaListener(topics = "movieLikes", groupId = "user")
    public City consumeKafka(City city) {
       
		return city;

 
        }

}
