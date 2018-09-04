package com.stackroute.juggler.recommendation.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Service;

import com.stackroute.juggler.kafka.domain.InputUser;
import com.stackroute.juggler.recommendation.domain.City;
import com.stackroute.juggler.recommendation.domain.User;
import com.stackroute.juggler.recommendation.repositories.CityRepository;
import com.stackroute.juggler.recommendation.repositories.UserRepository;

@Service
public class UserServiceImpl implements UserService {
private UserRepository userRepository;
private CityRepository cityRepository;
@Autowired
	public UserServiceImpl(UserRepository userRepository) {
	super();
	this.userRepository = userRepository;
}

	@Override
	@KafkaListener(topics="recomtest", groupId="user")
	public void getUserNode(@Payload InputUser kafkaUser) {
		User user =new User(kafkaUser.getUserId(),kafkaUser.getUserName(),kafkaUser.getEmailId(),kafkaUser.getDateOfBirth(),kafkaUser.getLanguagesKnown(),kafkaUser.getGenre(),kafkaUser.getLocation());
		userRepository.save(user);
		City city=new City(kafkaUser.getLocation());
		cityRepository.save(city);
//		List<Genre> genreList;
//		for(String s:kafkaUser.getLanguagesKnown()) {
//			
//		}
	}
//	private UserRepository userRepository;
//	@Override
//	public User saveUser(User user) {
//		return userRepository.save(user);
//	}
//
//	@Override
//	public City getCityOfUser(String userName) {
//		return userRepository.getCityOfUser(userName);
//}
//
//	@Override
//	public Genre getGenreOfUser(String userName) {
//		return userRepository.getGenreOfUser(userName);
//	}
//
//	@Override
//	public Language getLanguageOfUser(String userName) {
//		return userRepository.getLanguageOfUser(userName);
//	} 
//	
//
//	@Override
//	public List<Movie> getGenreBasedMoviesForUser(String userName) {
//		return userRepository.getGenreBasedMoviesForUser(userName);
//	}
//
//	@Override
//	public List<Movie> getLanguageBasedMoviesForUser(String userName) {
//		return userRepository.getLanguageBasedMoviesForUser(userName);
//	}
}
