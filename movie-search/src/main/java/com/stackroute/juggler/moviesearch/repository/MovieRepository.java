package com.stackroute.juggler.moviesearch.repository;

import java.util.List;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.stackroute.juggler.moviesearch.domain.Movie;



@Repository     //declaring it as repository
public interface MovieRepository extends CrudRepository<Movie,Integer> {
	

//	Query to get the books by search term

//	@Query("{'title':{$regex : ?0, $options:'i'}}")
//	public List<Movie> getByMovieName(String regexp);
//	
	public List<Movie> getBymovieName(String movieName);
	public Movie findByMovieName(String movieName);

	public boolean existsByMovieName(String movieName);

	public Movie getById(String movieId);
}

