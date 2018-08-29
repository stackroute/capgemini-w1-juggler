package com.stackroute.juggler.recommendation.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.stackroute.juggler.kafka.domain.Movie;
import com.stackroute.juggler.recommendation.repositories.MovieRepository;

@Service
public class MovieServiceImpl implements MovieService {

	private MovieRepository movieRepository;

	@Autowired
	public MovieServiceImpl(MovieRepository movieRepository) {
		super();
		this.movieRepository = movieRepository;
	}

	public Movie saveMovie(Movie movie) {
		return movieRepository.save(movie);
	}
//	@Override
//	public List<Movie> findByGenre(String genre) {
//
//		return movieRepository.findByGenres(genre);
//	}
//	public Movie findByName(String name) {
//		return movieRepository.findByName(name);
//	}

//	public Movie findById(int id) {
//		return movieRepository.findById(id);
//	}
//
//	@Override
//	public void releasedIn(String cityName,String movieName) {
//	movieRepository.releasedIn(cityName, movieId);		
//	}

	@Override
	public List<Movie> getMoviesByGenre(String genreName) {
		return movieRepository.getMoviesByGenre(genreName);
	}

	@Override
	public List<Movie> getMoviesByCity(String name) {
		return movieRepository.getMoviesByCity(name);
	}

	@Override
	public List<Movie> getMovieByCityGenre(String name, String genreName) {
		return movieRepository.getMovieByCityGenre(name, genreName);
	}

//	@Override
//	public void releasedIn(String cityName, int movieId) {
//		// TODO Auto-generated method stub
//		
//	}
	@Override
	public List<Movie> getMovieByCityLanguage(String cityName, String languageName) {
		return movieRepository.getMovieByCityLanguage(cityName, languageName);
	}

	@Override
	public List<Movie> getMovieByCityGenreLanguage(String cityName, String genreName, String languageName) {
		return movieRepository.getMovieByCityGenreLanguage(cityName, genreName, languageName);
	}

//	@Override
//	public List<Movie> getByGenreAgeCity(String userName, String genreName, String cityName) {
//		return movieRepository.getByGenreAgeCity(userName, genreName, cityName);
//	}

}
