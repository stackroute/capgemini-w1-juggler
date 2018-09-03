package com.stackroute.juggler.recommendation.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

import com.stackroute.juggler.kafka.domain.MovieSchedule;
import com.stackroute.juggler.recommendation.domain.City;
import com.stackroute.juggler.recommendation.domain.Genre;
import com.stackroute.juggler.recommendation.domain.Language;
import com.stackroute.juggler.recommendation.domain.Movie;
import com.stackroute.juggler.recommendation.repositories.MovieRepository;

@Service
public class MovieServiceImpl implements MovieService {

	private MovieRepository movieRepository;

	@Autowired
	public MovieServiceImpl(MovieRepository movieRepository) {
		super();
		this.movieRepository = movieRepository;
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

//	@Override
//	public List<Movie> getMoviesByGenre(String genreName) {
//		return movieRepository.getMoviesByGenre(genreName);
//	}
//
//	@Override
//	public List<Movie> getMoviesByCity(String name) {
//		return movieRepository.getMoviesByCity(name);
//	}
//
//	@Override
//	public List<Movie> getMovieByCityGenre(String name, String genreName) {
//		return movieRepository.getMovieByCityGenre(name, genreName);
//	}

//	@Override
//	public void releasedIn(String cityName, int movieId) {
//		// TODO Auto-generated method stub
//		
//	}
//	@Override
//	public List<Movie> getMovieByCityLanguage(String cityName, String languageName) {
//		return movieRepository.getMovieByCityLanguage(cityName, languageName);
//	}
//
//	@Override
//	public List<Movie> getMovieByCityGenreLanguage(String cityName, String genreName, String languageName) {
//		return movieRepository.getMovieByCityGenreLanguage(cityName, genreName, languageName);
//	}

	@Override
	@KafkaListener(topics = "screeningfinal", groupId = "movie")
	public void getMovieNode(MovieSchedule movie) {
		Movie movieObj=new Movie();
		movieObj.setMovieId(movie.getId());
		movieObj.setName(movie.getMovieName());
		movieObj.setMoviePoster(movie.getMoviePoster());
		movieObj.setSynopsis(movie.getSynopsis());
		movieObj.setMovieReleasedate(movie.getMovieReleaseDate());
		movieObj.setMovieDuration(movie.getMovieDuration());
		movieObj.setFormat(movie.getFormat());
		movieObj.setHero(movie.getActors());
		movieObj.setHeroine(movie.getActress());
		movieObj.setDirector(movie.getDirectors());
		City cityObj=new City(movie.getTheatreCity());
		movieObj.setCity(cityObj);
		Language langObj=new Language(movie.getLanguages());
		movieObj.setLanguages(langObj);
		Genre genreObj=new Genre(movie.getMovieGenres());
		movieObj.setGenre(genreObj);
		System.out.println(movieObj.toString());
		movieRepository.save(movieObj);
	}

//	@Override
//	public List<Movie> getByGenreAgeCity(String userName, String genreName, String cityName) {
//		return movieRepository.getByGenreAgeCity(userName, genreName, cityName);
//	}

}
