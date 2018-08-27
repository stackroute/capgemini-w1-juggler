package com.stackroute.juggler.movieschedule.service;

import java.util.List;

import com.stackroute.juggler.kafka.domain.MovieSchedule;
import com.stackroute.juggler.kafka.domain.Registration;

public interface MovieScheduleService {

	public MovieSchedule addMovieSchedule(MovieSchedule movieShow);

	public List<MovieSchedule> getMoviesSchedule();

	public MovieSchedule updateMovieSchedule(MovieSchedule updateMovie);

	// public ResponseEntity<String> hello();
	
	public void consumeKafka(Registration registration);

}
