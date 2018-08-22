package com.stackroute.juggler.userprofile.repository;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.stackroute.juggler.userprofile.domain.User;
<<<<<<< HEAD
=======
import com.stackroute.juggler.userprofile.domain.UserProfile;
>>>>>>> 63ce83ece91d925925a048a33402f1329815819d

//using crud repo to use inbuild methods so as to add into database
@Repository
public interface UserRepository extends CrudRepository<User,Integer> {

<<<<<<< HEAD
	Optional<User> findByUserid(int userid);
=======
	User findByUserid(int userid);
	

	//User save(Optional<User> finduser);
>>>>>>> 63ce83ece91d925925a048a33402f1329815819d

}
