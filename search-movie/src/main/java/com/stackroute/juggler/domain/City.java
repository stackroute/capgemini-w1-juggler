package com.stackroute.juggler.domain;

import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

//pojo for city

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class City {

		@Id
		private String city;
		private List<Movie> movieList;
//		@Override
//		public String toString() {
//			return "City [city=" + city + ", movieList=" + movieList + "]";
//		}
	}

