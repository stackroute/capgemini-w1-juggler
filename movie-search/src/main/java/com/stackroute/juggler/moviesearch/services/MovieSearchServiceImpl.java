package com.stackroute.juggler.moviesearch.services;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

import com.stackroute.juggler.kafka.domain.MovieSchedule;
import com.stackroute.juggler.moviesearch.MovieSearchApplication;
import com.stackroute.juggler.moviesearch.domain.City;
import com.stackroute.juggler.moviesearch.domain.Movie;
import com.stackroute.juggler.moviesearch.domain.Theatre;
import com.stackroute.juggler.moviesearch.repository.CityRepository;
import com.stackroute.juggler.moviesearch.repository.MovieRepository;

@Service
public class MovieSearchServiceImpl implements MovieSearchService {

	public static final Logger logger = LoggerFactory.getLogger(MovieSearchApplication.class);

	private MovieRepository movieRepository;
	private CityRepository cityRepository;

	@Autowired
	public MovieSearchServiceImpl(MovieRepository movieRepository, CityRepository cityrepository) {
		// LoggingController.logger.debug("------------searchService started--------");
		logger.debug("------------searchService started--------");
		this.movieRepository = movieRepository;
		this.cityRepository = cityrepository;
	}

	@Override
	public String saveCity(City city) {

		City cityToBeSave = cityRepository.save(city);
		List<Movie> movies = convertcitytomovie(city);

		for (Iterator iterator = movies.iterator(); iterator.hasNext();) {
			Movie movie = (Movie) iterator.next();
			Movie moviesaved = movieRepository.save(movie);
		}

		return "saved";

	}

	private List<Movie> convertcitytomovie(City city) {
		List<Movie> movies = city.getMovieList();
		return movies;
	}

	@Override
	public City getByCity(String city) {
		String input = city.toLowerCase();
		City list = cityRepository.getBycityName(input);
		return list;

	}

	@Override
	public List<Movie> getByTitle(String movieName) {

		List<Movie> list = movieRepository.getBymovieName(movieName);
		return list;

	}

	@Override
	@KafkaListener(topics = "screeningfinal", groupId = "search", containerFactory = "kafkaListenerContainerFactory")
	public void consumeKafka(MovieSchedule movieschedule) {

		logger.debug("-------------started the method-----------");
		City cities;
		Movie movie;
		Movie tempMovie;
		List<Movie> movies = new ArrayList<Movie>();
		List<Theatre> theaters = new ArrayList<Theatre>();
		List<Theatre> newtheater;
		Theatre theater;
		Theatre theatre1;
		String cityname = movieschedule.getTheatreCity();
		if (cityRepository.findBycityName(cityname) != null) {
			logger.debug("---------checking the city----------------");
			cities = cityRepository.findBycityName(cityname);
			movies = cities.getMovieList();
			Iterator<Movie> iterator = movies.iterator();
			while (iterator.hasNext()) {
				movie = iterator.next();
				logger.debug("------checking the movies ------------- ");
				if (movie.getMovieName() == movieschedule.getMovieName()) {
					theaters = movie.getTheatres();
					Iterator<Theatre> iterator1 = theaters.iterator();
					while (iterator1.hasNext()) {
						theater = iterator1.next();
						if (theater.getTheatreName() == movieschedule.getTheatreName()) {
							logger.debug("theatre names is present");
						} else {
							theatre1 = new Theatre(movieschedule.getTheatreId(), movieschedule.getTheatreName(),
									movieschedule.getTheatreLocation(), movieschedule.getSeatLayout(),
									movieschedule.getShowNumbers(), movieschedule.getShowTimings(),
									movieschedule.getWeekends_Price(), movieschedule.getWeekdays_Price(),
									movieschedule.getSeats(), movieschedule.getScreenedmovies(),
									movieschedule.getRunningmovies());
							theaters.add(theatre1);
						}
					}
				} else {
					theatre1 = new Theatre(movieschedule.getTheatreId(), movieschedule.getTheatreName(),
							movieschedule.getTheatreLocation(), movieschedule.getSeatLayout(),
							movieschedule.getShowNumbers(), movieschedule.getShowTimings(),
							movieschedule.getWeekends_Price(), movieschedule.getWeekdays_Price(),
							movieschedule.getSeats(), movieschedule.getScreenedmovies(),
							movieschedule.getRunningmovies());
					newtheater = new ArrayList<Theatre>();
					newtheater.add(theatre1);
					tempMovie = new Movie(movieschedule.getId(), movieschedule.getMovieName(),
							movieschedule.getMoviePoster(), movieschedule.getSynopsis(),
							movieschedule.getMovieReleaseDate(), movieschedule.getMovieDuration(),
							movieschedule.getLanguages(), movieschedule.getMovieGenres(), movieschedule.getFormat(),
							movieschedule.getActors(), movieschedule.getActress(), movieschedule.getDirectors(),
							newtheater);
//					movieRepository.save(tempMovie);
					movies.add(tempMovie);
					cityRepository.save(cities);
				}
			}
		} else {
			theater = new Theatre(movieschedule.getTheatreId(), movieschedule.getTheatreName(),
					movieschedule.getTheatreLocation(), movieschedule.getSeatLayout(), movieschedule.getShowNumbers(),
					movieschedule.getShowTimings(), movieschedule.getWeekends_Price(),
					movieschedule.getWeekdays_Price(), movieschedule.getSeats(), movieschedule.getScreenedmovies(),
					movieschedule.getRunningmovies());
			theaters = new ArrayList<>();
			theaters.add(theater);
			movie = new Movie(movieschedule.getId(), movieschedule.getMovieName(), movieschedule.getMoviePoster(),
					movieschedule.getSynopsis(), movieschedule.getMovieReleaseDate(), movieschedule.getMovieDuration(),
					movieschedule.getLanguages(), movieschedule.getMovieGenres(), movieschedule.getFormat(),
					movieschedule.getActors(), movieschedule.getActress(), movieschedule.getDirectors(), theaters);
			movies = new ArrayList<>();
			movies.add(movie);

			cities = new City(cityname, movies);
			cityRepository.save(cities);
			// List<Movie> mov = convertcitytomovie(cities);
			// for (Iterator iterator = mov.iterator(); iterator.hasNext();) {
			// Movie movi = (Movie) iterator.next();
			// Movie moviesaved = movieRepository.save(movi);
			// }
		}

	}

	@Override
	public City update(String cityname, List<Movie> movies) {
		// TODO Auto-generated method stub
		return null;
	}

}
