package com.stackroute.juggler.moviesearch.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.stackroute.juggler.kafka.domain.Movie;

//declaring it as repo
@Repository
public interface MovieRepository extends CrudRepository<Movie, Integer> {
	public List<Movie> getBymovieName(String movieName);

	public boolean existsByMovieName(String movieName);

	public Movie getById(int movieId);
}
