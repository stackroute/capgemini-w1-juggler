package com.stackroute.juggler.movieschedule.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.stackroute.juggler.kafka.domain.MovieDetails;
import com.stackroute.juggler.kafka.domain.MovieSchedule;

//declaring it as a repository
@Repository
public interface MovieScheduleRepository extends MongoRepository<MovieSchedule, Integer> {

	public MovieSchedule getByTheatreName(String theatreName);

	public MovieDetails save(MovieDetails movieDetails);

}
