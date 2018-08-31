package com.stackroute.juggler.recommendation.repositories;

import org.springframework.data.neo4j.repository.Neo4jRepository;

import com.stackroute.juggler.recommendation.domain.Genre;

public interface GenreRepository extends Neo4jRepository<Genre, Integer>{
	
	public Genre findByName(String name);

	
}
