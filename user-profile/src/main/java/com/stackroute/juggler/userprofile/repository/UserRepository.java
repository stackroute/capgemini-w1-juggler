package com.stackroute.juggler.userprofile.repository;

import org.springframework.data.repository.CrudRepository;
import com.stackroute.juggler.userprofile.domain.User;

public interface UserRepository extends CrudRepository<User,Integer> {

}
