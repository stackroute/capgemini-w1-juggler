package com.stackroute.juggler.recommendation.repositories;

import org.springframework.data.neo4j.repository.Neo4jRepository;

import com.stackroute.juggler.recommendation.relations.Follows;

public interface FollowsRepository extends Neo4jRepository<Follows, Long>{

}
