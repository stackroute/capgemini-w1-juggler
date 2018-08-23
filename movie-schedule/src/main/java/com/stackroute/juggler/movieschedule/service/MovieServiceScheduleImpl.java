package com.stackroute.juggler.movieschedule.service;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.stackroute.juggler.movieschedule.domain.MovieSchedule;
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
		MovieSchedule update =  movieScheduleRepo.save(updateMovie);
		return update;
	}
	
	RestTemplate restTemplate = new RestTemplate();
	String url = "http://localhost:8090/api/v1/movieservice/movies";

	@Override
	public ResponseEntity<String> hello() {
		ResponseEntity<String> list;
		list = restTemplate.getForEntity(url, String.class);
		return list;
	}
	
	

}
