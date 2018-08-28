package com.stackroute.juggler.distributor.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.stackroute.juggler.distributor.domain.Movie;
import com.stackroute.juggler.distributor.services.MovieServices;

@CrossOrigin(origins = "http://localhost:4200")
@Controller
@RequestMapping("/api/v1/")
public class MovieController {

	private MovieServices movieServices;

	@Autowired
	public MovieController(MovieServices movieServices) {
		this.movieServices = movieServices;
	}

	// save
	@RequestMapping(value = "/movie", method = RequestMethod.POST)
	public ResponseEntity<?> saveMovie(@RequestBody Movie movie) {
		Movie savedMovie;
		savedMovie = movieServices.saveMovie(movie);
		return new ResponseEntity<Movie>(savedMovie, HttpStatus.OK);

	}

	// getall
	@RequestMapping(value = "/movies", method = RequestMethod.GET, produces = { "application/json" })

	public ResponseEntity<List<Movie>> getAllMovies() {
		List<Movie> movies = movieServices.getAllMovies();
		return new ResponseEntity<List<Movie>>(movies, HttpStatus.OK);
	}

	// getbytitle
	@RequestMapping(value = "/getbytitle/movie", method = RequestMethod.GET, produces = { "application/json" })
	public ResponseEntity<?> getMovieByTitleFromDB(@RequestParam String movieTitle) {
		List<Movie> movie = movieServices.getByMovieTitle(movieTitle);
		if (!movie.isEmpty())
			return new ResponseEntity<List<Movie>>(movie, HttpStatus.FOUND);
		else
			return new ResponseEntity<String>("{ \"message\": \"" + "no movies  with this name" + "\"}", HttpStatus.OK);
	}
	
//	// update
//		@RequestMapping(value = "/movie", method = RequestMethod.PUT, produces = { "application/json" })
//		public ResponseEntity<?> updateMovieToDB(@RequestBody Movie movie, @RequestParam int movieId) {
//			Movie movieUpdated;
//			try {
//				movieUpdated = movieServices.updateMovie(movie);
//			} catch (MovieNotFoundException e) {
//				return new ResponseEntity<String>("{ \"message\": \"" + e.getMessage() + "\"}", HttpStatus.CONFLICT);
//			}
//			return new ResponseEntity<Movie>(movieUpdated, HttpStatus.FOUND);
//		}

}
