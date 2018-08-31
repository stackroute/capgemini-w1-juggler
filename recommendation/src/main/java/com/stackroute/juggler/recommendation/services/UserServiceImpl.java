package com.stackroute.juggler.recommendation.services;

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
import com.stackroute.juggler.recommendation.relations.Follows;
import com.stackroute.juggler.recommendation.repositories.CityRepository;
import com.stackroute.juggler.recommendation.repositories.FollowsRepository;
import com.stackroute.juggler.recommendation.repositories.GenreRepository;
import com.stackroute.juggler.recommendation.repositories.LanguageRepository;
import com.stackroute.juggler.recommendation.repositories.UserRepository;

@Service
public class UserServiceImpl implements UserService {

	private UserRepository userRepository;
	private GenreRepository genreRepository;
	private LanguageRepository languageRepository;
	private CityRepository cityRepository;
	private FollowsRepository followsRepository;

	@Autowired
	public UserServiceImpl(UserRepository userRepository, GenreRepository genreRepository,
			LanguageRepository languageRepository, CityRepository cityRepository,FollowsRepository followsRepository) {
		super();
		this.userRepository = userRepository;
		this.genreRepository = genreRepository;
		this.languageRepository = languageRepository;
		this.cityRepository = cityRepository;
		this.followsRepository=followsRepository;
	}

	@KafkaListener(topics = "details8", groupId = "user")
	void getUserNode(InputUser user) {
		User userObj = new User(user.getUserName(), user.getEmailId(), user.getDateOfBirth(),
				user.getLanguagesKnown(), user.getGenre(), user.getLocation());
		userRepository.save(userObj);
		City city = new City(user.getLocation());
		cityRepository.save(city);
		Genre gen = null;
		for (String s : user.getGenre()) {
			System.out.println("1");
		 gen= new Genre(s);
			genreRepository.save(gen);
			
			}
		System.out.println("2");
		for (String s : user.getLanguagesKnown()) {
			Language lang= new Language(s);
			languageRepository.save(lang);
			}
		System.out.println("3");
		Follows follows=new Follows(userObj, gen);
		System.out.println("4");
		followsRepository.save(follows);
		System.out.println("5");

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
