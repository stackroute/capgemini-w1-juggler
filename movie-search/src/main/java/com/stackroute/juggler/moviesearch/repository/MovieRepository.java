package com.stackroute.juggler.moviesearch.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.stackroute.kafka.domain.Movie;



@Repository     //declaring it as repository
public interface MovieRepository extends CrudRepository<Movie,Integer> {
	public List<Movie> getBymovieName(String movieName);
}

