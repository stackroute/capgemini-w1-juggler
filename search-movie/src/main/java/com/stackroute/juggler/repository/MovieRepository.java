package com.stackroute.juggler.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.stackroute.juggler.domain.City;
import com.stackroute.juggler.domain.Movie;

@Repository     //declaring it as repository
public interface MovieRepository extends CrudRepository<City,String> {
	
}


