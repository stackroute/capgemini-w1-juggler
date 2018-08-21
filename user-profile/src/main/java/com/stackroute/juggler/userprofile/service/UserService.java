package com.stackroute.juggler.userprofile.service;

import java.util.Optional;

import com.stackroute.juggler.userprofile.domain.User;

//user service class should implement these methods for sure
public interface UserService {
	
	public User saveUser(User user) ;
	public Optional<User> viewUser(int userid);

}
