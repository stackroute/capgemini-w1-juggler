package com.stackroute.juggler.userprofile.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import com.stackroute.juggler.kafka.domain.InputUser;
import com.stackroute.juggler.kafka.domain.UserProfile;
import com.stackroute.juggler.userprofile.configuration.KafkaConfiguration;
import com.stackroute.juggler.userprofile.exceptions.ProfileAlreadyExitsException;
import com.stackroute.juggler.userprofile.exceptions.UpdateFailedException;
import com.stackroute.juggler.userprofile.exceptions.UserDoesNotExistsException;
import com.stackroute.juggler.userprofile.repository.UserRepository;

@Service
public class UserServiceImpl implements UserService {

	// logger is used to log status of code
	private final Logger logger = LoggerFactory.getLogger(this.getClass());

	// Creating a object of user repository
	private UserRepository userRepository;
	private KafkaConfiguration kafkaConfig;

	// using repository in service implementation
	@Autowired
	public UserServiceImpl(UserRepository userRepository,KafkaConfiguration kafkaConfig) {

		this.userRepository = userRepository;
		//this.kafkaConfig = kafkaConfig;
	}

	public UserServiceImpl() {
		// TODO Auto-generated constructor stub
	}

	private String topic = kafkaConfig.getTopic();

	// Kafka template from configuration and topic
	@Autowired
	private KafkaTemplate<String, InputUser> kafkaTemplate;

	// this method is to save user to databases
	@Override
	public InputUser saveUser(InputUser inputUser) throws ProfileAlreadyExitsException {
		if (userRepository.findByUserId(inputUser.getUserId()) == null) {
			kafkaTemplate.send(topic, inputUser);
			 //This is because we dont want to save the password in the userprofile database
			inputUser.setPassword(null);
			InputUser userSaved = userRepository.save(inputUser);
			logger.info("Profile is saved into database-servicelayer");
			return userSaved;
		} else {
			logger.warn("Profile is not added into database");
			throw new ProfileAlreadyExitsException("Profile already exists");
		}

	}

	// this method is to view user from databases
	@Override
	public InputUser viewUser(String userId) throws UserDoesNotExistsException {
		// Checking for existance of User
		if (userRepository.findByUserId(userId) != null) {
			InputUser findUser = userRepository.findByUserId(userId);
			logger.info("Profile is found from database-servicelayer");
			return findUser;
		} else {
			// Exception
			logger.warn("Profile is not found in database");
			throw new UserDoesNotExistsException("InputUser Does Not Exist");
		}
	}

	@Override
	public InputUser updateUser(String userId, UserProfile user)
			throws UpdateFailedException, UserDoesNotExistsException {
		// initilization of user domain object
		InputUser finduser = null;
		// Checking for user existance
		if (userRepository.findByUserId(userId) != null) {
			// Setting the required fields
			finduser = userRepository.findByUserId(userId);
			finduser.setDateOfBirth(user.getDateOfBirth());
			finduser.setGenre(user.getGenre());
			finduser.setLanguagesKnown(user.getLanguagesKnown());
			finduser.setLocation(user.getLocation());
			finduser.setPaymentMethods(user.getPaymentMethods());
			logger.info("Profile is Updated into database-servicelayer");
			return finduser;
		} else {
			// Exception
			logger.warn("Profile is not updated into database");
			throw new UserDoesNotExistsException("InputUser Does Not Exist");
		}

	}

}
