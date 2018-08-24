package com.stackroute.juggler.domain;

import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;



//pojo for city
@Document

public class City {

		@Id
		private int cityId;
		private String cityName;
		private List<Movie> movieList;
		@Override
		public String toString() {
			return "City [cityId=" + cityId + ", city=" + cityName + ", movieList=" + movieList + "]";
		}
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
		
		public void addToList(Movie movie) {
			this.movieList.add(movie);
		}  
		
		
		
	}
