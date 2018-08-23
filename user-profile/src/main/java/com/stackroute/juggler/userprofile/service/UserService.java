package com.stackroute.juggler.userprofile.service;

import java.util.Optional;
import com.stackroute.juggler.userprofile.domain.User;
import com.stackroute.juggler.userprofile.domain.UserProfile;
import com.stackroute.juggler.userprofile.exceptions.ProfileAlreadyExits;
import com.stackroute.juggler.userprofile.exceptions.UpdateFailed;
import com.stackroute.juggler.userprofile.exceptions.UserDoesNotExists;


//user service class should implement these methods for sure
public interface UserService {
	
	public User saveUser(User user) throws ProfileAlreadyExits ;
	public User viewUser(int userid) throws UserDoesNotExists;
	public User updateUser(int userid, UserProfile user) throws UpdateFailed,UserDoesNotExists;


}
