package com.stackroute.juggler.userprofile.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.stackroute.juggler.userprofile.domain.User;
import com.stackroute.juggler.userprofile.service.UserService;

@RestController
public class UserController {
	
UserService userService;
	
	@Autowired
	public UserController(UserService userService) {
	this.userService=userService;
		
	}
	@RequestMapping(value = "/saveuser", method = RequestMethod.POST)
	public ResponseEntity<?> saveMovies(@RequestBody User user)  {
			User userobj=null;
			
			userobj=userService.saveUser(user);
			return new ResponseEntity<User>(userobj, HttpStatus.OK);
		}

}
