package com.stackroute.juggler.recommendation.services;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

import com.stackroute.juggler.kafka.domain.InputUser;
import com.stackroute.juggler.recommendation.domain.City;
import com.stackroute.juggler.recommendation.domain.Genre;
import com.stackroute.juggler.recommendation.domain.Language;
import com.stackroute.juggler.recommendation.domain.Movie;
import com.stackroute.juggler.recommendation.domain.User;
import com.stackroute.juggler.recommendation.repositories.CityRepository;
import com.stackroute.juggler.recommendation.repositories.GenreRepository;
import com.stackroute.juggler.recommendation.repositories.LanguageRepository;
import com.stackroute.juggler.recommendation.repositories.UserRepository;

@Service
public class UserServiceImpl implements UserService {

	private UserRepository userRepository;
	private GenreRepository genreRepository;
	private LanguageRepository languageRepository;
	private CityRepository cityRepository;
	
	@Autowired
	public UserServiceImpl(UserRepository userRepository, GenreRepository genreRepository,
			LanguageRepository languageRepository, CityRepository cityRepository) {
		super();
		this.userRepository = userRepository;
		this.genreRepository = genreRepository;
		this.languageRepository = languageRepository;
		this.cityRepository = cityRepository;
		}

	@Override
	@KafkaListener(topics = "details10", groupId = "user")
	public void getUserNode(InputUser user) {
		System.out.println("entering getnode");
		User userObj = new User();
		userObj.setName(user.getUserName());
		userObj.setEmailId(user.getEmailId());
		userObj.setDateOfBirth(user.getDateOfBirth());
		City city = new City(user.getLocation());
		userObj.setCity(city);
		List<Genre> genres = new ArrayList<Genre>();
		List<Language> languages = new ArrayList<Language>();
		for(String s:user.getGenre()) {
		Genre genre=new Genre(s);
		genres.add(genre);
		userObj.setGenres(genres);
		}
		for(String s:user.getLanguagesKnown()) {
			Language lang=new Language(s);
			languages.add(lang);
			userObj.setLanguages(languages);
			}
		System.out.println(userObj);
		userRepository.save(userObj);
		//System.out.println(userRepository.save(userObj));;
		
	}
}

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
