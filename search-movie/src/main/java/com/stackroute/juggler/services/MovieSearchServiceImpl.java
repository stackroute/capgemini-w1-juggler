package com.stackroute.juggler.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.stackroute.juggler.domain.Movie;
import com.stackroute.juggler.repository.MovieRepository;



public class MovieSearchServiceImpl {

	MovieRepository movieRepository;
	
	@Autowired
	public MovieSearchServiceImpl(MovieRepository movieRepository) {
			
		this.movieRepository=movieRepository;
		}
	public List<Movie> getByTitle(String movieName) {
		
		List<Movie> list=movieRepository.getBymovieName(movieName);
		return list;
	}
	
}
