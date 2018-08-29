package com.stackroute.juggler.movieschedule.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.stackroute.juggler.kafka.domain.MovieDetails;
import com.stackroute.juggler.kafka.domain.MovieSchedule;
import com.stackroute.juggler.movieschedule.service.MovieScheduleService;

//@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/api/v1/movie-schedule")
public class MovieScheduleController {

	private MovieScheduleService movieScheduleService;

	@Autowired
	public MovieScheduleController(MovieScheduleService movieScheduleService) {
		// super();
		this.movieScheduleService = movieScheduleService;
	}

	// save the movie theatre schedule to the database
	@RequestMapping(value = "/add", method = RequestMethod.POST, produces = "application/json")
	public ResponseEntity<?> saveMovieHandler(@RequestBody MovieSchedule movie) {

		MovieSchedule movieObj = movieScheduleService.addMovieSchedule(movie);

		return new ResponseEntity<MovieSchedule>(movieObj, HttpStatus.OK);

	}

	@RequestMapping(value = "/addmovie", method = RequestMethod.POST, produces = "application/json")
	public ResponseEntity<?> saveMovieDetailsHandler(@RequestBody MovieDetails movie) {

		MovieDetails movieObj = movieScheduleService.addMovieDetails(movie);

		return new ResponseEntity<MovieDetails>(movieObj, HttpStatus.OK);

	}

	// get the movie theatre schedule from the database
	@RequestMapping(value = "/show", method = RequestMethod.GET, produces = "application/json")
	public ResponseEntity<List<MovieSchedule>> getMovieSchedule() {

		List<MovieSchedule> movieObj = movieScheduleService.getMoviesSchedule();
		return new ResponseEntity<List<MovieSchedule>>(movieObj, HttpStatus.OK);

	}

	// Update the movie theatre schedule in the databases
	@RequestMapping(value = "/update", method = RequestMethod.PUT, produces = "application/json")
	public ResponseEntity<?> updateMovieSchedule(@RequestBody MovieSchedule movie) {

		MovieSchedule movieObj = movieScheduleService.updateMovieSchedule(movie);

		return new ResponseEntity<MovieSchedule>(movieObj, HttpStatus.OK);

	}

	// @RequestMapping(value = "/user", method = RequestMethod.GET)
	// public ResponseEntity<String> helloHandler(@RequestParam String movieTitle) {
	// System.out.println("hi controller is called");
	// return movieScheduleService.hello();
	// }

	@RequestMapping(value = "/update/{theatrename}", method = RequestMethod.PUT, produces = "application/json")
	public ResponseEntity<?> updateMovieSchedule1(@RequestBody MovieSchedule movie, @PathVariable String theatrename) {

		MovieSchedule movieObj = movieScheduleService.getByTheatreName(theatrename);
		MovieSchedule rmovieObj = movieScheduleService.updateMovieSchedule(movieObj);
		return new ResponseEntity<MovieSchedule>(rmovieObj, HttpStatus.OK);
	}

}
