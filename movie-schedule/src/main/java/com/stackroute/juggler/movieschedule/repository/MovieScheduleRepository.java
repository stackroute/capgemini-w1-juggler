package com.stackroute.juggler.movieschedule.repository;

import org.springframework.data.repository.CrudRepository;

import com.stackroute.juggler.movieschedule.domain.MovieSchedule;

public interface MovieScheduleRepository extends CrudRepository<MovieSchedule, Integer> {

}
