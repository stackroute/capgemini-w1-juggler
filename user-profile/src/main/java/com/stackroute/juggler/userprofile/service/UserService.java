package com.stackroute.juggler.userprofile.service;

import java.util.Optional;

import com.stackroute.juggler.userprofile.domain.User;
import com.stackroute.juggler.userprofile.domain.UserProfile;

//user service class should implement these methods for sure
public interface UserService {
	
	public User saveUser(User user) ;
	public User viewUser(int userid);
	public User updateUser(int userid, User user);

}
