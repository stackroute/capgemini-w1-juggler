package com.stackroute.juggler.movieschedule.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.stackroute.juggler.movieschedule.domain.MovieSchedule;
import com.stackroute.juggler.movieschedule.repository.MovieScheduleRepository;

@Service
public class MovieServiceScheduleImpl implements MovieScheduleService {
	
	private MovieScheduleRepository movieScheduleRepo;
	
	public MovieServiceScheduleImpl(MovieScheduleRepository movieScheduleRepo) {
		this.movieScheduleRepo = movieScheduleRepo;
	}

	@Override
	public MovieSchedule addMovie(MovieSchedule movieShow) {
		MovieSchedule addMovie = movieScheduleRepo.save(movieShow);
		return addMovie;	
	}

	@Override
	public List<MovieSchedule> getAllMovies() {
		List<MovieSchedule> getMovies = (List<MovieSchedule>) movieScheduleRepo.findAll();
		return getMovies;
		
	}
	
	

}
