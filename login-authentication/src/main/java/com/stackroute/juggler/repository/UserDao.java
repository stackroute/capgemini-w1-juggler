package com.stackroute.juggler.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.stackroute.juggler.kafka.domain.User;
//using crudrepo to add into database
@Repository
public interface UserDao extends CrudRepository<User, Long> {
	User save(User user);
    //These are the defined methods to be used when handling with database
	User findByEmail(String email);
	User findByPhoneNumber(Long phoneNumber);
}
