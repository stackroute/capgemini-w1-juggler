package com.stackroute.juggler.movieschedule.service;

import java.util.List;

import com.stackroute.juggler.kafka.domain.MovieSchedule;
import com.stackroute.juggler.kafka.domain.Theatre;

public interface MovieScheduleService {

	public MovieSchedule addMovieSchedule(MovieSchedule movieSchedule);

	public List<MovieSchedule> getMoviesSchedule();

	public MovieSchedule updateMovieSchedule(String theatreName, MovieSchedule updateMovie);

	public void consumeKafka(Theatre theatre);

}
