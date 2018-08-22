package com.stackroute.juggler.movieschedule.controller;

<<<<<<< HEAD
public class MovieScheduleController {
=======
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.stackroute.juggler.movieschedule.domain.MovieSchedule;
import com.stackroute.juggler.movieschedule.service.MovieScheduleService;
	
@RestController
@RequestMapping("/api/v1/movie-schedule")
public class MovieScheduleController {
	
	private MovieScheduleService movieScheduleService;

	@Autowired
	public MovieScheduleController(MovieScheduleService movieScheduleService) {
//		super();
		this.movieScheduleService = movieScheduleService;
	}
	
	@RequestMapping(value = "/add", method = RequestMethod.POST, produces = "application/json")
	public ResponseEntity<?> saveMovieHandler(@RequestBody MovieSchedule movie) {
		
			MovieSchedule movieObj = movieScheduleService.addMovie(movie);

			return new ResponseEntity<MovieSchedule>(movieObj, HttpStatus.OK);

		

	}

	@RequestMapping(value = "/show", method = RequestMethod.GET, produces = "application/json")
	public ResponseEntity<List<MovieSchedule>> getAllMoviesHAndler() {

		List<MovieSchedule> movieObj = movieScheduleService.getAllMovies();
		return new ResponseEntity<List<MovieSchedule>>(movieObj, HttpStatus.OK);

	}
	
	
>>>>>>> 63ce83ece91d925925a048a33402f1329815819d

}
