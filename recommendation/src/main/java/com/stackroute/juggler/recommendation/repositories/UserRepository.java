package com.stackroute.juggler.recommendation.repositories;

import org.springframework.data.neo4j.repository.Neo4jRepository;

import com.stackroute.juggler.recommendation.domain.User;

public interface UserRepository extends Neo4jRepository<User, Integer>{

}
