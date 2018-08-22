package com.stackroute.juggler.domain;

import java.util.List;

import org.springframework.data.annotation.Id;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

//pojo for city

@Data
@AllArgsConstructor
@NoArgsConstructor
public class City {

		@Id
		private String city;
		private List<Movie> movieList;
	}

