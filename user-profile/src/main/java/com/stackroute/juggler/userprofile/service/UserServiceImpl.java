package com.stackroute.juggler.userprofile.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;

import com.stackroute.juggler.userprofile.domain.User;
import com.stackroute.juggler.userprofile.repository.UserRepository;

public class UserServiceImpl implements UserService {
	
	//Creating a object of user repository
	UserRepository userRepository;
	
	//using repository in service implementation 
	@Autowired
	public UserServiceImpl(UserRepository userRepository) {
			
		this.userRepository=userRepository;
		}

	//this method is to save user to databases
	@Override
	public User saveUser(User user) {
		User userSaved=userRepository.save(user);
		return userSaved ;
	}
	
	//this method is to view user from databases
	@Override
	public Optional<User>  viewUser(int userid) {
		Optional<User> findMovie=userRepository.findById(userid);
		return findMovie;
	}

}
