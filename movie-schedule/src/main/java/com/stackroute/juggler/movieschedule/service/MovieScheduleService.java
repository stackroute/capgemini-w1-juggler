package com.stackroute.juggler.movieschedule.service;

import java.util.List;
import com.stackroute.juggler.kafka.domain.MovieDetails;
import com.stackroute.juggler.kafka.domain.MovieSchedule;
import com.stackroute.juggler.kafka.domain.Registration;

public interface MovieScheduleService {

	public MovieSchedule addMovieSchedule(MovieSchedule movieShow);

	public List<MovieSchedule> getMoviesSchedule();

	public MovieSchedule updateMovieSchedule(MovieSchedule updateMovie);

	public void consumeKafka(Registration registration);
	
	public MovieDetails addMovieDetails(MovieDetails movieDetails);

	public MovieSchedule getByTheatreName(String theatrename);
	
	
	
//	public ResponseEntity<String> hello();

}
