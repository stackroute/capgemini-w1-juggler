package com.stackroute.juggler.distributor.repositary;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.stackroute.juggler.distributor.domain.Movie;

@Repository
public interface MovieRepositary extends CrudRepository<Movie, Integer> {

	public List<Movie> getByMovieName(String movieName);
}
