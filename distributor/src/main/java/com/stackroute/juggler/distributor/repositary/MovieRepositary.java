package com.stackroute.juggler.distributor.repositary;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.stackroute.juggler.distributor.domain.Movie;

@Repository
public interface MovieRepositary extends MongoRepository<Movie, String> {

	public List<Movie> getByMovieName(String movieName);

	public Movie getById(String id);
}
