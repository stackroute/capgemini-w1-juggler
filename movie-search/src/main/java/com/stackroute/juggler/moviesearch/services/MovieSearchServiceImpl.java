package com.stackroute.juggler.moviesearch.services;

import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

import com.stackroute.juggler.kafka.domain.MovieSchedule;
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
	// the method to listen the message from the specified kafka topic
	@Override
    @KafkaListener(topics = "movieLikes", groupId = "user" , containerFactory = "kafkaListenerContainerFactory")
    public void consumeKafka(MovieSchedule movieschedule) {
		City addcity=null;
		addcity=cityRepository.getBycityName(movieschedule.getTheatreCity());
		String cityName=movieschedule.getTheatreCity();
			Movie movie=null;
			movie=(Movie) movieRepository.getBymovieName(movieschedule.getMovieDetails().getMovieName());
		
			String id=((KafkaListener) movieschedule.getMovieDetails()).id();
		movieschedule.getMovieDetails().getActors();
//			City addTheatre = null;
//
//			if (movieScheduleRepo.getByTheatreName(registration.getTheatreName()) != null) {
//				addTheatre = movieScheduleRepo.getByTheatreName(registration.getTheatreName());
//				String theatreId = registration.getTheatreId();
//				String theatreLocation = registration.getTheatreLocation();
//				String theatreCity = registration.getTheatreCity();
//				String theatreLicenseNo = registration.getTheatreLicenseNo();
//				String noOfSeats = registration.getNumberOfSeats();
//				Map<String, Integer> seats = registration.getSeats();
//				addTheatre.setTheatreLocation(theatreLocation);
//				addTheatre.setTheatreId(theatreId);
//				addTheatre.setTheatreCity(theatreCity);
//				addTheatre.setTheatreLicenseNo(theatreLicenseNo);
//				addTheatre.setNumberOfSeats(noOfSeats);
//				addTheatre.setSeats(seats);
//				movieScheduleRepo.save(addTheatre);
//				System.out.println(theatreLocation);
			}

		
		

}
