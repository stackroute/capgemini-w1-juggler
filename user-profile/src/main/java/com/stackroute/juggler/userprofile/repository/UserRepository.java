package com.stackroute.juggler.userprofile.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import com.stackroute.juggler.userprofile.domain.User;
import com.stackroute.juggler.userprofile.domain.UserProfile;


//using crudrepo to use in build methods so as to add into database
@Repository
public interface UserRepository extends CrudRepository<User,Integer> {

	//These are the defined methods to be used when handling with database
	//Optional<User> findByUserid(int userid);
	//boolean findByEmail_id(String Email_id);
	User findByUserid(int userid);
	UserProfile save(UserProfile user);
	//User save(Optional<User> finduser);
}
