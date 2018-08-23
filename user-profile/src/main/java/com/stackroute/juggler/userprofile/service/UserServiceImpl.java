package com.stackroute.juggler.userprofile.service;

import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.stackroute.juggler.userprofile.domain.User;
import com.stackroute.juggler.userprofile.domain.UserProfile;
import com.stackroute.juggler.userprofile.exceptions.ProfileAlreadyExits;
import com.stackroute.juggler.userprofile.exceptions.UpdateFailed;
import com.stackroute.juggler.userprofile.exceptions.UserDoesNotExists;
import com.stackroute.juggler.userprofile.repository.UserRepository;

@Service
public class UserServiceImpl implements UserService {

	// Creating a object of user repository
	UserRepository userRepository;

	// using repository in service implementation
	@Autowired
	public UserServiceImpl(UserRepository userRepository) {

		this.userRepository = userRepository;
	}

	// this method is to save user to databases
	@Override
	public User saveUser(User user) throws ProfileAlreadyExits {
		if (!userRepository.existsById(user.getUserid())) {
			User userSaved = userRepository.save(user);
			return userSaved;
		} else {
			throw new ProfileAlreadyExits("Profile already exists");
		}

	}

	// this method is to view user from databases
	@Override
	public User viewUser(int userid) throws UserDoesNotExists {
		if (userRepository.findByUserid(userid) != null) {
			User finduser = userRepository.findByUserid(userid);
			return finduser;
		} else {
			throw new UserDoesNotExists("User Does Not Exist");
		}
	}

	@Override
	public User updateUser(int userid, UserProfile user) throws UpdateFailed, UserDoesNotExists {
		User finduser = null;
		if (userRepository.findByUserid(userid) != null) {
			finduser=userRepository.findByUserid(userid);
			finduser.setDate_of_birth(user.getDate_of_birth());
			finduser.setGenre(user.getGenre());
			finduser.setLanguages_known(user.getLanguages_known());
			finduser.setLikes(user.getLikes());
			finduser.setLocation(user.getLocation());
			finduser.setPayment_methods(user.getPayment_methods());
//			 finduser = userRepository.findByUserid(userid);
//			 finduser = userRepository.save(user);
				return finduser;
		} else {
			throw new UserDoesNotExists("User Does Not Exist");
		}

		
	}

}
