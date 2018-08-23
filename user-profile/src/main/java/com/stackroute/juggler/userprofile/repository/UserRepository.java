package com.stackroute.juggler.userprofile.repository;

import java.util.Optional;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import com.stackroute.juggler.userprofile.domain.User;
import com.stackroute.juggler.userprofile.domain.UserProfile;


//using crud repo to use inbuild methods so as to add into database
@Repository
public interface UserRepository extends CrudRepository<User,Integer> {


	//Optional<User> findByUserid(int userid);

	User findByUserid(int userid);
	

	UserProfile save(UserProfile user);
	

	//User save(Optional<User> finduser);


}
