package com.stackroute.juggler.recommendation.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.stackroute.juggler.recommendation.domain.City;
import com.stackroute.juggler.recommendation.domain.Genre;
import com.stackroute.juggler.recommendation.domain.Language;
import com.stackroute.juggler.recommendation.domain.Movie;
import com.stackroute.juggler.recommendation.domain.User;
import com.stackroute.juggler.recommendation.repositories.UserRepository;

@Service
public class UserServiceImpl implements UserService {
	private UserRepository userRepository;
	@Override
	public User saveUser(User user) {
		return userRepository.save(user);
	}

	@Override
	public City getCityOfUser(String userName) {
		return userRepository.getCityOfUser(userName);
}

	@Override
	public Genre getGenreOfUser(String userName) {
		return userRepository.getGenreOfUser(userName);
	}

	@Override
	public Language getLanguageOfUser(String userName) {
		return userRepository.getLanguageOfUser(userName);
	} 
	

	@Override
	public List<Movie> getGenreBasedMoviesForUser(String userName) {
		return userRepository.getGenreBasedMoviesForUser(userName);
	}

	@Override
	public List<Movie> getLanguageBasedMoviesForUser(String userName) {
		return userRepository.getLanguageBasedMoviesForUser(userName);
	}
}
