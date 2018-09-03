package com.stackroute.juggler.moviesearch.services;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

import com.stackroute.juggler.kafka.domain.MovieSchedule;
import com.stackroute.juggler.moviesearch.domain.City;
import com.stackroute.juggler.moviesearch.domain.Movie;
import com.stackroute.juggler.moviesearch.domain.Theatre;
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
		City list = cityRepository.getBycityName(city);
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

		String cityname = movieschedule.getTheatreCity();
		if (cityRepository.existsById(cityname)) {
			City cities = cityRepository.findBycityName(cityname);
			List<Movie> movies = cities.getMovieList();
			for (Iterator<Movie> iterator = movies.iterator(); iterator.hasNext();) {
				Movie movie = (Movie) iterator.next();
				if (movie.getMovieName() == movieschedule.getMovieName()) {
					List<Theatre> theaters = movie.getTheatres();
					for (Iterator<Theatre> iterator1 = theaters.iterator(); iterator1.hasNext();) {
						Theatre theater = (Theatre) iterator1.next();
						if (theater.getTheatreName() == movieschedule.getTheatreName()) {
						} else {
							Theatre theatre1 = new Theatre(movieschedule.getTheatreId(), movieschedule.getTheatreName(),
									movieschedule.getTheatreLocation(), movieschedule.getSeatLayout(),
									movieschedule.getShowNumbers(), movieschedule.getShowTimings(),
									movieschedule.getWeekends_Price(), movieschedule.getWeekdays_Price(),
									movieschedule.getSeats(), movieschedule.getScreenedmovies(),
									movieschedule.getRunningmovies());
							theaters.add(theatre1);
						}
					}
				} else {
					Theatre theatre2 = new Theatre(movieschedule.getTheatreId(), movieschedule.getTheatreName(),
							movieschedule.getTheatreLocation(), movieschedule.getSeatLayout(),
							movieschedule.getShowNumbers(), movieschedule.getShowTimings(),
							movieschedule.getWeekends_Price(), movieschedule.getWeekdays_Price(),
							movieschedule.getSeats(), movieschedule.getScreenedmovies(),
							movieschedule.getRunningmovies());
					List<Theatre> newtheater = new ArrayList<Theatre>();
					newtheater.add(theatre2);
					Movie newmovie = new Movie(movieschedule.getId(), movieschedule.getMovieName(),
							movieschedule.getMoviePoster(), movieschedule.getSynopsis(),
							movieschedule.getMovieReleaseDate(), movieschedule.getMovieDuration(),
							movieschedule.getLanguages(), movieschedule.getMovieGenres(), movieschedule.getFormat(),
							movieschedule.getActors(), movieschedule.getActress(), movieschedule.getDirectors(),
							newtheater);
					movieRepository.save(newmovie);
					movies.add(newmovie);
				}
			}
		} else {
			Theatre theatre = new Theatre(movieschedule.getTheatreId(), movieschedule.getTheatreName(),
					movieschedule.getTheatreLocation(), movieschedule.getSeatLayout(), movieschedule.getShowNumbers(),
					movieschedule.getShowTimings(), movieschedule.getWeekends_Price(),
					movieschedule.getWeekdays_Price(), movieschedule.getSeats(), movieschedule.getScreenedmovies(),
					movieschedule.getRunningmovies());
			List<Theatre> theatres = new ArrayList<>();
			theatres.add(theatre);
			Movie movie = new Movie(movieschedule.getId(), movieschedule.getMovieName(), movieschedule.getMoviePoster(),
					movieschedule.getSynopsis(), movieschedule.getMovieReleaseDate(), movieschedule.getMovieDuration(),
					movieschedule.getLanguages(), movieschedule.getMovieGenres(), movieschedule.getFormat(),
					movieschedule.getActors(), movieschedule.getActress(), movieschedule.getDirectors(), theatres);
			List<Movie> movies = new ArrayList<>();
			movies.add(movie);
			
			City city = new City(movieschedule.getTheatreCity(), movies);
			cityRepository.save(city);
			List<Movie> moviesss=city.getMovieList();
			for (Iterator iterator = moviesss.iterator(); iterator.hasNext();) {
				Movie movie1 = (Movie) iterator.next();
				Movie moviesaved = movieRepository.save(movie1);
			}
		
		}

	}

	@Override
	@KafkaListener(topics = "screeningfinal", groupId = "search", containerFactory = "kafkaListenerContainerFactory")
	public void consumeKafkaMovie(MovieSchedule movieschedule) {
		
		
	}
}
