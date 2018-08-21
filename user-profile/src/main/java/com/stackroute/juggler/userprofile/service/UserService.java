package com.stackroute.juggler.userprofile.service;

import com.stackroute.juggler.userprofile.domain.User;

public interface UserService {
	
	public User saveUser(User movie) ;
	public User viewUser(int userid);

}
