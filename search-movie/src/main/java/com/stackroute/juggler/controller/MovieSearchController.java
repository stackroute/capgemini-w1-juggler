package com.stackroute.juggler.controller;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.stackroute.juggler.domain.City;
import com.stackroute.juggler.domain.Movie;
import com.stackroute.juggler.services.MovieSearchService;

import com.stackroute.juggler.services.MovieSearchServiceImpl;

	 


@RestController
@RequestMapping(value = "/juggler/")
public class MovieSearchController {
	
	MovieSearchServiceImpl searchService;
	
	@Autowired
	public MovieSearchController(MovieSearchServiceImpl searchService) {
	this.searchService=searchService;
	}
	
	@GetMapping("/movies/{name}")
	public ResponseEntity<?> getMovieByName(@PathVariable String movieName) {
		return new ResponseEntity<Iterable<Movie>>(searchService.getByTitle(movieName), HttpStatus.OK);

	}

	@RequestMapping(value = "/movie", method = RequestMethod.POST, produces = { "application/json" })
	public ResponseEntity<?> saveMovie(@RequestBody Movie movie) {
		Movie movieObj;
		movieObj = searchService.saveMovie(movie);
		return new ResponseEntity<Movie>(movieObj, HttpStatus.OK);

	}
	@RequestMapping(value = "/city", method = RequestMethod.POST, produces = { "application/json" })
	public ResponseEntity<?> saveCity(@RequestBody City city) {
		City cityObj;
		cityObj = searchService.saveCity(city);
		
		return new ResponseEntity<City>(cityObj, HttpStatus.OK);

	}

	@RequestMapping(value = "/city/{city}", method = RequestMethod.GET, produces = { "application/json" })
	public ResponseEntity<?> getMoviesByCity(@PathVariable String city) {
		return new ResponseEntity<Iterable<Movie>>(searchService.getByCity(city), HttpStatus.OK);

	}

	@RequestMapping(value = "/", method = RequestMethod.GET, produces = { "application/json" })
	public ResponseEntity<?> default1() {
		return new ResponseEntity<String>("hi", HttpStatus.OK);

	}

}
