package com.stackroute.juggler.userprofile.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.stackroute.juggler.userprofile.domain.User;
<<<<<<< HEAD
=======
import com.stackroute.juggler.userprofile.domain.UserProfile;
>>>>>>> 63ce83ece91d925925a048a33402f1329815819d
import com.stackroute.juggler.userprofile.repository.UserRepository;

@Service
public class UserServiceImpl implements UserService {
<<<<<<< HEAD
	
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
	public User viewUser(int userid) {
		Optional<User> finduser;
		 finduser=userRepository.findById(userid);
		return finduser.get();
	}

}

=======

	// Creating a object of user repository
	UserRepository userRepository;

	// using repository in service implementation
	@Autowired
	public UserServiceImpl(UserRepository userRepository) {

		this.userRepository = userRepository;
	}

	// this method is to save user to databases
	@Override
	public User saveUser(User user) {
		User userSaved = userRepository.save(user);
		return userSaved;
	}

	// this method is to view user from databases
	@Override
	public User viewUser(int userid) {
		User finduser;
		finduser = userRepository.findByUserid(userid);
		return finduser;
	}

	@Override
	public User updateUser(int userid, User user) {
		User finduser = userRepository.findByUserid(userid);
		finduser = userRepository.save(user);
		return finduser;
	}

}
>>>>>>> 63ce83ece91d925925a048a33402f1329815819d
