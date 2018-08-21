package com.stackroute.juggler.userprofile.repository;

import org.springframework.data.repository.CrudRepository;
import com.stackroute.juggler.userprofile.domain.User;

//using crud repo to use inbuild methods so as to add into database
public interface UserRepository extends CrudRepository<User,Integer> {

}
