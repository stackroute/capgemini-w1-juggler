package com.stackroute.kafka.domain;

import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document

public class City {
	@Id
	private int cityId;
	public int getCityId() {
		return cityId;
	}
	public void setCityId(int cityId) {
		this.cityId = cityId;
	}
	public String getCityName() {
		return cityName;
	}
	public void setCityName(String cityName) {
		this.cityName = cityName;
	}
	public List<Movie> getMovieList() {
		return movieList;
	}
	
	public void setMovieList(List<Movie> movieList) {
		this.movieList = movieList;
	}
	private String cityName;
	private List<Movie> movieList;
	
//	public City(int cityId, String cityName, List<Movie> movieList) {
//		super();
//		this.cityId = cityId;
//		this.cityName = cityName;
//		this.movieList = movieList;
//	}
////	public City() {
////		super();
////	}
}
