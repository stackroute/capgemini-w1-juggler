package com.stackroute.juggler.movieschedule.service;

import java.util.List;

import com.stackroute.juggler.movieschedule.domain.MovieSchedule;

public interface MovieScheduleService {
	
	public MovieSchedule addMovieSchedule(MovieSchedule movieShow);
	
	public List<MovieSchedule> getMoviesSchedule();
	
	public MovieSchedule updateMovieSchedule(MovieSchedule updateMovie);

}
