package com.stackroute.juggler.movieschedule.service;

import java.util.List;
import java.util.Map;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;
import com.stackroute.juggler.kafka.domain.MovieSchedule;
import com.stackroute.juggler.kafka.domain.Registration;
import com.stackroute.juggler.movieschedule.repository.MovieScheduleRepository;

@Service
public class MovieServiceScheduleImpl implements MovieScheduleService {

	private MovieScheduleRepository movieScheduleRepo;

	public MovieServiceScheduleImpl(MovieScheduleRepository movieScheduleRepo) {

		this.movieScheduleRepo = movieScheduleRepo;
	}

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

	// the method to update the existing movie-theatre schedule
	@Override
	public MovieSchedule updateMovieSchedule(MovieSchedule updateMovie) {
		if (movieScheduleRepo.getByTheatreName(updateMovie.getTheatreName()) != null) {
		 updateMovie = movieScheduleRepo.save(updateMovie);
		}
		return updateMovie;
	}

	// the method to listen the message from the specified kafka topic
	@Override
	@KafkaListener(topics = "testkafka", groupId = "grpid", containerFactory = "kafkaListenerContainerFactory")
	public void consumeKafka(Registration registration) {
		MovieSchedule addTheatre = new MovieSchedule();
		if (movieScheduleRepo.getByTheatreName(registration.getTheatreName()) == null) {
			// addTheatre =
			// movieScheduleRepo.getByTheatreName(registration.getTheatreName());
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
