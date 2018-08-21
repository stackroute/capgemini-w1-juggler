//package com.stackroute.juggler.distributor.controller;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.http.HttpStatus;
//import org.springframework.http.ResponseEntity;
//import org.springframework.web.bind.annotation.RequestBody;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RequestMethod;
//import org.springframework.web.bind.annotation.RestController;
//
//import com.stackroute.juggler.distributor.domain.Movie;
//import com.stackroute.juggler.distributor.services.MovieServices;
//
//@RestController
//public class MovieController {
//
//	@Autowired
//	private MovieServices movieServices;
//
//	// save
//	@RequestMapping(value = "/movie", method = RequestMethod.POST, produces = { "application/json" })
//	public ResponseEntity<?> saveMovie(@RequestBody Movie movie) {
//		Movie savedMovie;
//		savedMovie = movieServices.saveMovie(movie);
//		return new ResponseEntity<Movie>(savedMovie, HttpStatus.OK);
//
//	}
//
//}
