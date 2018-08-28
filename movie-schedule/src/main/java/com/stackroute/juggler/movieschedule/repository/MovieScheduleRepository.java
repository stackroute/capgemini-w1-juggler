package com.stackroute.juggler.movieschedule.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.stackroute.juggler.kafka.domain.MovieSchedule;

public interface MovieScheduleRepository extends MongoRepository<MovieSchedule, Integer> {
	
	MovieSchedule findByTheatreName(String theatreName);
	

}
