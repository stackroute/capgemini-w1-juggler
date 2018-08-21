package com.stackroute.juggler.distributor.repositary;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.stackroute.juggler.distributor.domain.Movie;

@Repository
public interface MovieRepositary extends CrudRepository<Movie, String> {	
}
