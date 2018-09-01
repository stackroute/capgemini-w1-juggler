package com.stackroute.juggler.recommendation.repositories;

import org.springframework.data.neo4j.repository.Neo4jRepository;
import org.springframework.stereotype.Repository;

import com.stackroute.juggler.recommendation.relations.Follows;

@Repository
public interface FollowsRepository extends Neo4jRepository<Follows, Long> {

}
