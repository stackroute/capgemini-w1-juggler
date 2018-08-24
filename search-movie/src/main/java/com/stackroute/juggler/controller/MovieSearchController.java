package com.stackroute.juggler.controller;



import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.stackroute.juggler.domain.City;
import com.stackroute.juggler.domain.Movie;

import com.stackroute.juggler.services.MovieSearchServiceImpl;

@RestController
@RequestMapping(value = "/api/v1")
public class MovieSearchController {
	
	MovieSearchServiceImpl searchService;
	
	@Autowired
	public MovieSearchController(MovieSearchServiceImpl searchService) {
	this.searchService=searchService;
	}

	@RequestMapping(value = "/city", method = RequestMethod.POST, produces = { "application/json" })
	public ResponseEntity<?> saveCity(@RequestBody City city) {
		
	
		City cityobj;
		
		cityobj=searchService.saveCity(city);
		return new ResponseEntity<City>(cityobj, HttpStatus.OK);
	}
	@RequestMapping(value = "/movie/{movieName}", method = RequestMethod.GET, produces = { "application/json" })
	public ResponseEntity<?> getMovieByName(@PathVariable String movieName) {
		return new ResponseEntity<Iterable<Movie>>(searchService.getByTitle(movieName), HttpStatus.OK);

	}

	@RequestMapping(value = "/city/{city}", method = RequestMethod.GET, produces = { "application/json" })
	public ResponseEntity<?> getMoviesByCity(@PathVariable String city) {
		return new ResponseEntity<Iterable<City>>(searchService.getByCity(city), HttpStatus.OK);

	}
	@RequestMapping(value = "/movies", method = RequestMethod.GET)
	public ResponseEntity<?> getAllMovies() {
		List<Movie> list=searchService.getAllMovies();
		
		return new ResponseEntity<List<Movie>>(list,HttpStatus.OK);

	}
	@RequestMapping(value = "/", method = RequestMethod.GET, produces = { "application/json" })
	public ResponseEntity<?> default1() {
		return new ResponseEntity<String>("hi", HttpStatus.OK);

	}
}
