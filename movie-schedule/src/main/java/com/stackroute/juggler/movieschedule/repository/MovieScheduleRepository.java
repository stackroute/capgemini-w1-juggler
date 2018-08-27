package com.stackroute.juggler.movieschedule.repository;

import org.springframework.data.repository.CrudRepository;

import com.stackroute.juggler.kafka.domain.MovieSchedule;

public interface MovieScheduleRepository extends CrudRepository<MovieSchedule, Integer> {
	
	MovieSchedule findByTheatreId(int theatreId);
	

}
