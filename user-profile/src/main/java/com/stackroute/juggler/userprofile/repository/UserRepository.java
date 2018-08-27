package com.stackroute.juggler.userprofile.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.stackroute.juggler.kafka.domain.User;


//using crudrepo to use in build methods so as to add into database
@Repository
public interface UserRepository extends CrudRepository<User,Integer> {

	//These are the defined methods to be used when handling with database
	User findByUserId(int userId);
}
