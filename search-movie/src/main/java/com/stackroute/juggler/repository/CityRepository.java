package com.stackroute.juggler.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.stackroute.juggler.domain.City;



	@Repository     //declaring it as repository
	public interface CityRepository extends CrudRepository<City,String> {
		
	}
