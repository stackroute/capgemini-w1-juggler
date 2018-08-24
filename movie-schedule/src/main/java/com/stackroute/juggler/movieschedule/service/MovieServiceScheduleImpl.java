package com.stackroute.juggler.movieschedule.service;

import java.util.List;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

import com.stackroute.juggler.movieschedule.domain.MovieSchedule;
import com.stackroute.juggler.movieschedule.domain.TheatreDetails;
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

	@Override
	@KafkaListener(topics = "theatre_details", groupId = "movieSchedule")
	public void consumeKafka(TheatreDetails theatreDetails) {
		MovieSchedule addTheatre = null;
		if (movieScheduleRepo.findByTheatreId(theatreDetails.getTheatreId()) != null) {
			addTheatre = movieScheduleRepo.findByTheatreId(theatreDetails.getTheatreId());
			String theatreName = theatreDetails.getTheatreName();
			addTheatre.setTheatreName(theatreName);
			movieScheduleRepo.save(addTheatre);

		}
//		System.out.println(theatreDetails);

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
