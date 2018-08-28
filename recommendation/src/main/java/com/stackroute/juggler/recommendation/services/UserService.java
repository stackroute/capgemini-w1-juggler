package com.stackroute.juggler.recommendation.services;

import java.util.List;

import com.stackroute.juggler.recommendation.domain.City;
import com.stackroute.juggler.recommendation.domain.Genre;
import com.stackroute.juggler.recommendation.domain.Language;
import com.stackroute.juggler.recommendation.domain.Movie;
import com.stackroute.juggler.recommendation.domain.User;

public interface UserService {
	public User saveUser(User user);
	public City getCityOfUser(String userName);
	public Genre getGenreOfUser(String userName);
	public Language getLanguageOfUser(String userName);
	public List<Movie> getGenreBasedMoviesForUser(String userName);
	public List<Movie> getLanguageBasedMoviesForUser(String userName);
}
