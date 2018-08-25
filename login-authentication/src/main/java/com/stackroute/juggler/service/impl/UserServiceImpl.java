package com.stackroute.juggler.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

import com.stackroute.juggler.model.InputUser;
import com.stackroute.juggler.model.User;
import com.stackroute.juggler.repository.UserDao;
import com.stackroute.juggler.service.UserService;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserDao userDao;

	public User save(User user) {
		return userDao.save(user);
	}

	public User findByEmail(String email) {
		return userDao.findByEmail(email);
	}

	@Override
	public User findByPhoneNumber(Long phoneNumber) {

		return userDao.findByPhoneNumber(phoneNumber);
	}

	@Override
	@KafkaListener(topics = "details6", groupId = "user")
	public void consumeKafka(InputUser inputUser) {

		User user = new User();

		if (userDao.findByEmail(inputUser.getEmailId()) == null) {
			String email = inputUser.getEmailId();
			String password = inputUser.getPassword();
			// String role=inputUser.getRole();
			user.setEmail(email);
			user.setPassword(password);
			user.setRole("user");

			userDao.save(user);
			// System.out.println("" + inputUser);
			// System.out.println("" + inputUser.getEmailId());
		}
	}

}
