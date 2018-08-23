package com.stackroute.juggler.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.stackroute.juggler.domain.City;
import com.stackroute.juggler.domain.Movie;

//declaring it as repository
@Repository
public interface MovieRepository extends CrudRepository<Movie, Integer> {

	public List<Movie> getBymovieName(String movieName);
}
