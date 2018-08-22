package com.stackroute.juggler.movieschedule.service;

import java.util.List;

import com.stackroute.juggler.movieschedule.domain.MovieSchedule;

public interface MovieScheduleService {
	
	public MovieSchedule addMovie(MovieSchedule movieShow);
	
	public List<MovieSchedule> getAllMovies();

}
