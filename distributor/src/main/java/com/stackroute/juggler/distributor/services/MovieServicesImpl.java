package com.stackroute.juggler.distributor.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.stackroute.juggler.distributor.domain.Movie;
import com.stackroute.juggler.distributor.repositary.MovieRepositary;

@Service
public class MovieServicesImpl implements  MovieServices{
	
	@Autowired
	private MovieRepositary movieRepositary;

//@Autowired
	public MovieServicesImpl(MovieRepositary movieRepository) {
		this.movieRepositary = movieRepositary;
	}
	
	@Override
	public Movie saveMovie(Movie movie) {
		Movie savedMovie = movieRepositary.save(movie);
		return savedMovie;
		
	}

	@Override
	public List<Movie> getByMovieTitle(String movieTitle) {
		List<Movie> movies = movieRepositary.getByMovieName(movieTitle);
		return movies;
	}

	@Override
	public List<Movie> getAllMovies() {
		List<Movie> movies = (List<Movie>) movieRepositary.findAll();
		return movies;
	}

//	@Override
//	public Movie updateMovie() {
//		// TODO Auto-generated method stub
//		return null;
//	}
//	
	
}
