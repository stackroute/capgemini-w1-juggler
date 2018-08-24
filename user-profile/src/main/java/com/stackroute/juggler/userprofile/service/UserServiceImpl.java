package com.stackroute.juggler.userprofile.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import com.stackroute.juggler.userprofile.configuration.KafkaConfiguration;
import com.stackroute.juggler.userprofile.domain.User;
import com.stackroute.juggler.userprofile.domain.UserLikes;
import com.stackroute.juggler.userprofile.domain.UserProfile;
import com.stackroute.juggler.userprofile.exceptions.ProfileAlreadyExitsException;
import com.stackroute.juggler.userprofile.exceptions.UpdateFailedException;
import com.stackroute.juggler.userprofile.exceptions.UserDoesNotExistsException;
import com.stackroute.juggler.userprofile.repository.UserRepository;

@Service
public class UserServiceImpl implements UserService {

	
	// Creating a object of user repository
	private UserRepository userRepository;
	private KafkaConfiguration kafkaConfig;

	// using repository in service implementation
	@Autowired
	public UserServiceImpl(UserRepository userRepository,KafkaConfiguration kafkaConfig) {

		this.userRepository = userRepository;
		this.kafkaConfig=kafkaConfig;
	}
	
	String topic = kafkaConfig.getTopic();

	// Kafka template from configuration and topic
	@Autowired
	private KafkaTemplate<String, User> kafkaTemplate;

	

	//private static final String TOPIC = "userProfile";

	// this method is to save user to databases
	@Override
	public User saveUser(User user) throws ProfileAlreadyExitsException {
		if (userRepository.findByUserId(user.getUserId()) == null) {
			kafkaTemplate.send(topic, user);
			// This is because we dont want to save the password in the userprofile database
			user.setPassword(null);
			User userSaved = userRepository.save(user);
			return userSaved;
		} else {
			throw new ProfileAlreadyExitsException("Profile already exists");
		}

	}

	// this method is to view user from databases
	@Override
	public User viewUser(int userId) throws UserDoesNotExistsException {
		if (userRepository.findByUserId(userId) != null) {
			User findUser = userRepository.findByUserId(userId);
			return findUser;
		} else {
			throw new UserDoesNotExistsException("User Does Not Exist");
		}
	}

	@Override
	public User updateUser(int userId, UserProfile user) throws UpdateFailedException, UserDoesNotExistsException {
		// initilization of user domain object
		User finduser = null;
		if (userRepository.findByUserId(userId) != null) {
			finduser = userRepository.findByUserId(userId);
			finduser.setDateOfBirth(user.getDateOfBirth());
			finduser.setGenre(user.getGenre());
			finduser.setLanguagesKnown(user.getLanguagesKnown());
			finduser.setLocation(user.getLocation());
			finduser.setPaymentMethods(user.getPaymentMethods());
			return finduser;
		} else {
			throw new UserDoesNotExistsException("User Does Not Exist");
		}

	}

	@Override
	@KafkaListener(topics = "movieLikes", groupId = "user")
	public void consumeKafka(UserLikes userLikes) {
		User findUser = null;

		if (userRepository.findByUserId(userLikes.getUserId()) != null) {
			findUser = userRepository.findByUserId(userLikes.getUserId());
			String movieName = userLikes.getMovie();
			findUser.setLikes(movieName);
			userRepository.save(findUser);
		}

	}
}
