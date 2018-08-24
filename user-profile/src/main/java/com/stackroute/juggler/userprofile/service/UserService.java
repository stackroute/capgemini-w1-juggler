package com.stackroute.juggler.userprofile.service;

import com.stackroute.juggler.userprofile.domain.User;
import com.stackroute.juggler.userprofile.domain.UserLikes;
import com.stackroute.juggler.userprofile.domain.UserProfile;
import com.stackroute.juggler.userprofile.exceptions.ProfileAlreadyExits;
import com.stackroute.juggler.userprofile.exceptions.UpdateFailed;
import com.stackroute.juggler.userprofile.exceptions.UserDoesNotExists;


//user service class should implement these methods for sure
public interface UserService {
	
	//This is to save the user
	public User saveUser(User user) throws ProfileAlreadyExits ;
	//This is to view the user
	public User viewUser(int userid) throws UserDoesNotExists;
	//This is to update the user
	public User updateUser(int userid, UserProfile user) throws UpdateFailed,UserDoesNotExists;

	//public void consumeKafka(String message);
	public void consumeKafka(UserLikes UserLikes);
}
