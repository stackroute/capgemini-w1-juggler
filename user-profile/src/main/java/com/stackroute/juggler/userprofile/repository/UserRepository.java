package com.stackroute.juggler.userprofile.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.stackroute.juggler.kafka.domain.InputUser;


//using crudrepo to use in build methods so as to add into database
@Repository
public interface UserRepository extends MongoRepository<InputUser,Integer> {

	//These are the defined methods to be used when handling with database
	InputUser findByUserId(String string);
}
