package com.stackroute.juggler.movieschedule.service;

import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;
import com.stackroute.juggler.kafka.domain.MovieSchedule;
import com.stackroute.juggler.kafka.domain.Theatre;
import com.stackroute.juggler.movieschedule.config.Producer;
import com.stackroute.juggler.movieschedule.repository.MovieScheduleRepository;

@Service
public class MovieServiceScheduleImpl implements MovieScheduleService {

	private MovieScheduleRepository movieScheduleRepo;
	private Producer kafkaProducer;

//	static final String TOPIC = "screeningfinal";
	@Autowired
	public MovieServiceScheduleImpl(MovieScheduleRepository movieScheduleRepo, Producer kafkaProducer) {

		this.movieScheduleRepo = movieScheduleRepo;
		this.kafkaProducer = kafkaProducer;
	}

	String topic = kafkaProducer.getTopic();
	
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

	// @Autowired
	// This is the topic name it wont be changed so "final static"
	// private KafkaTemplate<String, MovieSchedule> kafkaTemplate;
	// private static final String TOPIC = "testkafka";

	// the method to update the existing movie-theatre schedule
	@Override
	public MovieSchedule updateMovieSchedule(String theatreName, MovieSchedule updateMovie) {
		// kafkaTemplate.send(TOPIC, updateMovie);
		if (movieScheduleRepo.getByTheatreName(theatreName) != null) {

			MovieSchedule movie = movieScheduleRepo.getByTheatreName(theatreName);
			System.out.println("" + theatreName);
			System.out.println("" + movie.getTheatreName());

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
			System.out.println("" + movie.getTheatreName() + "" + movie.getShowNumbers());
			movieScheduleRepo.save(movie);
			kafkaTemplate.send(topic, movie);
		} else
			System.out.println("error");
		return updateMovie;
	}

	// the method to listen the message from the specified kafka topic
	@Override
	@KafkaListener(topics = "theaterdetails", groupId = "grpid", containerFactory = "kafkaListenerContainerFactory")
	public void consumeKafka(Theatre theatre) {
		MovieSchedule addTheatre = new MovieSchedule();

		if (movieScheduleRepo.getByTheatreName(theatre.getTheatreName()) == null) {
			String theatreName = theatre.getTheatreName();
			String theatreId = theatre.getTheatreId();
			String theatreLocation = theatre.getTheatreLocation();
			String theatreCity = theatre.getTheatreCity();
			String theatreLicenseNo = theatre.getTheatreLicenseNo();
			String noOfSeats = theatre.getNumberOfSeats();
			Map<String, Integer> seats = theatre.getSeats();
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
