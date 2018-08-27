package com.stackroute.juggler.movieschedule.service;

import java.util.List;
import java.util.Map;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

import com.stackroute.juggler.kafka.domain.MovieSchedule;
import com.stackroute.juggler.kafka.domain.Registration;
import com.stackroute.juggler.movieschedule.config.Consumer;
import com.stackroute.juggler.movieschedule.repository.MovieScheduleRepository;

@Service
public class MovieServiceScheduleImpl implements MovieScheduleService {

	private MovieScheduleRepository movieScheduleRepo;

	public MovieServiceScheduleImpl(MovieScheduleRepository movieScheduleRepo) {

		this.movieScheduleRepo = movieScheduleRepo;
	}

	@Override
	public MovieSchedule addMovieSchedule(MovieSchedule movieShow) {
		MovieSchedule addMovie = movieScheduleRepo.save(movieShow);
		return addMovie;
	}

	@Override
	public List<MovieSchedule> getMoviesSchedule() {
		List<MovieSchedule> getMovies = (List<MovieSchedule>) movieScheduleRepo.findAll();
		return getMovies;

	}

	@Override
	public MovieSchedule updateMovieSchedule(MovieSchedule updateMovie) {
		MovieSchedule update = movieScheduleRepo.save(updateMovie);
		return update;
	}

	// if (userRepository.findByUserId(userLikes.getUserId()) != null) {
	// findUser = userRepository.findByUserId(userLikes.getUserId());
	// String movieName = userLikes.getMovie();
	// findUser.setLikes(movieName);
	// userRepository.save(findUser);
	// }
	@Override
	@KafkaListener(topics = "testkafka", groupId = "grpid", containerFactory = "kafkaListenerContainerFactory")
	public void consumeKafka(Registration registration) {
		// System.out.println("Consumed JSON Message: " + registration);
		// }
		MovieSchedule addTheatre = null;

		if (movieScheduleRepo.findByTheatreId(registration.getTheatreId()) != null) {
			addTheatre = movieScheduleRepo.findByTheatreId(registration.getTheatreId());
			String theatreName = registration.getTheatreName();
			String theatreLocation = registration.getTheatreLocation();
			String theatreCity = registration.getTheatreCity();
			String theatreLicenseNo = registration.getTheatreLicenseNo();
			String noOfSeats = registration.getNumberOfSeats();
			Map<String, Integer> seats = registration.getSeats();
			addTheatre.setTheatreLocation(theatreLocation);
			addTheatre.setTheatreName(theatreName);
			addTheatre.setTheatreCity(theatreCity);
			addTheatre.setTheatreLicenseNo(theatreLicenseNo);
			addTheatre.setNumberOfSeats(noOfSeats);
			addTheatre.setSeats(seats);
			movieScheduleRepo.save(addTheatre);

		}
		System.out.println(registration);

	}
}

// RestTemplate restTemplate = new RestTemplate();
// String url = "http://localhost:8010/api/v1/movies";
//
// @Override
// public ResponseEntity<String> hello() {
// ResponseEntity<String> list;
// list = restTemplate.getForEntity(url, String.class);
// return list;
