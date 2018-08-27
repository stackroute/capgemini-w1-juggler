package com.stackroute.juggler.userprofile.service;

import com.stackroute.juggler.kafka.domain.User;
import com.stackroute.juggler.kafka.domain.UserLikes;
import com.stackroute.juggler.kafka.domain.UserProfile;
import com.stackroute.juggler.userprofile.exceptions.ProfileAlreadyExitsException;
import com.stackroute.juggler.userprofile.exceptions.UpdateFailedException;
import com.stackroute.juggler.userprofile.exceptions.UserDoesNotExistsException;


//user service class should implement these methods for sure
public interface UserService {
	
	//Saves the user
	public User saveUser(User user) throws ProfileAlreadyExitsException ;
	//Views the user
	public User viewUser(int userId) throws UserDoesNotExistsException;
	//Updates the user
	public User updateUser(int userId, UserProfile user) throws UpdateFailedException,UserDoesNotExistsException;
	//Consumes the message from kafka
	public void consumeKafka(UserLikes userLikes);
}
