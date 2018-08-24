package com.stackroute.juggler.movieschedule.service;

import java.util.List;

import com.stackroute.juggler.movieschedule.domain.MovieSchedule;
import com.stackroute.juggler.movieschedule.domain.TheatreDetails;

public interface MovieScheduleService {

	public MovieSchedule addMovieSchedule(MovieSchedule movieShow);

	public List<MovieSchedule> getMoviesSchedule();

	public MovieSchedule updateMovieSchedule(MovieSchedule updateMovie);

	// public ResponseEntity<String> hello();
	
	public void consumeKafka(TheatreDetails theatreDetails);

}
