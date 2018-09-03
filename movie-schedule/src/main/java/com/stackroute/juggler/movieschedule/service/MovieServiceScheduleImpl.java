package com.stackroute.juggler.movieschedule.service;

import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;
import com.stackroute.juggler.kafka.domain.MovieSchedule;
import com.stackroute.juggler.kafka.domain.Registration;
import com.stackroute.juggler.movieschedule.repository.MovieScheduleRepository;

@Service
public class MovieServiceScheduleImpl implements MovieScheduleService {

	private MovieScheduleRepository movieScheduleRepo;
	
	static final String TOPIC = "screeningfinal";

	public MovieServiceScheduleImpl(MovieScheduleRepository movieScheduleRepo) {

		this.movieScheduleRepo = movieScheduleRepo;
	}

	@Autowired
	private KafkaTemplate<String, MovieSchedule> kafkaTemplate;
	
	// the method to add the movie-theatre schedule
	@Override
	public MovieSchedule addMovieSchedule(MovieSchedule movieShow) {
		MovieSchedule addMovie = movieScheduleRepo.save(movieShow);
		return addMovie;
	}

	// the method to get all movie-theatre schedules list
	@Override
	public List<MovieSchedule> getMoviesSchedule() {
		List<MovieSchedule> getMovies = (List<MovieSchedule>) movieScheduleRepo.findAll();
		return getMovies;

	}
	
//	@Autowired
	// This is the topic name it wont be changed so "final static"
	// private KafkaTemplate<String, MovieSchedule> kafkaTemplate;
	// private static final String TOPIC = "testkafka";

	// the method to update the existing movie-theatre schedule
	@Override
	public MovieSchedule updateMovieSchedule(String theatreName,MovieSchedule updateMovie) {
//		kafkaTemplate.send(TOPIC, updateMovie);
		if (movieScheduleRepo.getByTheatreName(theatreName)!= null) {
			
			MovieSchedule movie = movieScheduleRepo.getByTheatreName(theatreName);
			System.out.println(""+theatreName);
			System.out.println(""+movie.getTheatreName());
			
			
			movie.setMovieName(updateMovie.getMovieName());
			movie.setId(updateMovie.getId());
			movie.setActors(updateMovie.getActors());
			movie.setActress(updateMovie.getActress());
			movie.setDirectors(updateMovie.getDirectors());
			movie.setLanguages(updateMovie.getLanguages());
			movie.setMovieDuration(updateMovie.getMovieDuration());
			movie.setMovieReleaseDate(updateMovie.getMovieReleaseDate());
			movie.setMoviePoster(updateMovie.getMoviePoster());
			movie.setMovieGenres(updateMovie.getMovieGenres());
			movie.setSynopsis(updateMovie.getSynopsis());
			movie.setFormat(updateMovie.getFormat());
			movie.setShowNumbers(updateMovie.getShowNumbers());
			movie.setShowTimings(updateMovie.getShowTimings());
			movie.setWeekdays_Price(updateMovie.getWeekdays_Price());
			movie.setWeekends_Price(updateMovie.getWeekends_Price());
			System.out.println(""+movie.getTheatreName()+ ""+movie.getShowNumbers());
			movieScheduleRepo.save(movie);
			kafkaTemplate.send(TOPIC, movie);
		}
		else 
			System.out.println("error");
		return updateMovie;
	}
	
	

	// the method to listen the message from the specified kafka topic
	@Override
	@KafkaListener(topics = "testkafka", groupId = "grpid", containerFactory = "kafkaListenerContainerFactory")
	public void consumeKafka(Registration registration) {
		MovieSchedule addTheatre = new MovieSchedule();
		
		if (movieScheduleRepo.getByTheatreName(registration.getTheatreName()) == null) {
			String theatreName = registration.getTheatreName();
			String theatreId = registration.getTheatreId();
			String theatreLocation = registration.getTheatreLocation();
			String theatreCity = registration.getTheatreCity();
			String theatreLicenseNo = registration.getTheatreLicenseNo();
			String noOfSeats = registration.getNumberOfSeats();
			Map<String, Integer> seats = registration.getSeats();
			addTheatre.setTheatreName(theatreName);
			addTheatre.setTheatreLocation(theatreLocation);
			addTheatre.setTheatreId(theatreId);
			addTheatre.setTheatreCity(theatreCity);
			addTheatre.setTheatreLicenseNo(theatreLicenseNo);
			addTheatre.setNumberOfSeats(noOfSeats);
			addTheatre.setSeats(seats);
			
			movieScheduleRepo.save(addTheatre);
		}

	}

}
