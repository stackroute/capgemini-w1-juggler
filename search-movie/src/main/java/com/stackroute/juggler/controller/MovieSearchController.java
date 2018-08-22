package com.stackroute.juggler.controller;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

import com.stackroute.juggler.domain.Movie;

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
}
