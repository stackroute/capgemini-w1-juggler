package com.stackroute.juggler.ticketengine.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.stackroute.juggler.ticketengine.domain.RedisObject;

@Repository
public interface RedisRepo extends CrudRepository<RedisObject, String> {

}
