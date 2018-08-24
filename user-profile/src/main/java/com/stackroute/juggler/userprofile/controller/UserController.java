package com.stackroute.juggler.userprofile.controller;

import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import com.stackroute.juggler.userprofile.domain.User;
import com.stackroute.juggler.userprofile.domain.UserProfile;
import com.stackroute.juggler.userprofile.exceptions.ProfileAlreadyExits;
import com.stackroute.juggler.userprofile.exceptions.UpdateFailed;
import com.stackroute.juggler.userprofile.exceptions.UserDoesNotExists;
import com.stackroute.juggler.userprofile.service.UserService;

@RestController
public class UserController {

	// creating the userservice object to use the methods in it
	UserService userService;

	// constructer
	@Autowired
	public UserController(UserService userService) {
		this.userService = userService;
	}

	// This is to use the kafka template defined in the configuration
	//@Autowired
	//private KafkaTemplate<String, User> kafkaTemplate;

	// This is the topic name it wont be changed so "final static"
	private static final String TOPIC = "user_profile";

	// This request mapping is to accept new user and save the data to database and
	// messagebus
	@RequestMapping(value = "/user/save", method = RequestMethod.POST)
	public ResponseEntity<?> saveUser(@RequestBody User user) throws ProfileAlreadyExits {
		User userobj = null;
		// try {
		// This is to post the user json in the message bus
		//kafkaTemplate.send(TOPIC, user);
		// This is because we dont want to save the password in the userprofile database
		user.setPassword(null);
		// }catch(KafkaConnectionFailed m){
		// String result = m.getMessage();
		// return new ResponseEntity<String>(result, HttpStatus.OK);
		// }
		// This is to save the User
		try {
			//if(user.getEmail_id()=)
			userobj = userService.saveUser(user);
		} catch (ProfileAlreadyExits m) {
			// Error handling code
			String result = m.getMessage();
			return new ResponseEntity<String>(result, HttpStatus.NOT_ACCEPTABLE);
		}
		return new ResponseEntity<User>(userobj, HttpStatus.OK);
	}

	// This is to view the user in the database we take user id in url itself
	@RequestMapping(value = "/user/{userid}", method = RequestMethod.GET)
	public ResponseEntity<?> viewuser(@PathVariable int userid) throws UserDoesNotExists {
		try {
			User userobj = userService.viewUser(userid);
			return new ResponseEntity<User>(userobj, HttpStatus.OK);
		} catch (UserDoesNotExists m) {
			// Error Handling
			String result = m.getMessage();
			return new ResponseEntity<String>(result, HttpStatus.NOT_ACCEPTABLE);
		}

	}

	// This is to update user initially we find the user and allow to update
	@RequestMapping(value = "/user/{userid}", method = RequestMethod.PUT)
	public ResponseEntity<?> updateuser(@PathVariable int userid, @RequestBody UserProfile user)
			throws UpdateFailed, UserDoesNotExists {
		try {
			User userobj = userService.updateUser(userid, user);
			return new ResponseEntity<User>(userobj, HttpStatus.OK);
		} catch (UserDoesNotExists m) {
			// Error handling
			String result = m.getMessage();
			return new ResponseEntity<String>(result, HttpStatus.NOT_ACCEPTABLE);
		}

	}

}
