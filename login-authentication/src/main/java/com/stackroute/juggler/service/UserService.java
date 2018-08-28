package com.stackroute.juggler.service;

import com.stackroute.juggler.kafka.domain.InputUser;
import com.stackroute.juggler.kafka.domain.User;

public interface UserService {
	//save the user
	User save(User user);
   // find user my email and phoneNumber
	User findByEmail(String email);
	User findByPhoneNumber(Long phoneNumber);
	// consume message from kafka
	 public void consumeKafka(InputUser User);

}
