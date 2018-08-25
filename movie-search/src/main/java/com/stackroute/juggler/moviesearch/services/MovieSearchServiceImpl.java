package com.stackroute.juggler.moviesearch.services;

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
	public City saveCity(City city) {
		City cityToBeSave = cityRepository.save(city);
		return cityToBeSave;
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
