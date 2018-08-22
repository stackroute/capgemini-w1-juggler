package com.stackroute.juggler.domain;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.annotation.Id;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
/*
 * pojo for movie
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Movie {
	
	@Id
	private int id;
	private String movieName;
	private String moviePoster;
	private String synopsis;
	private LocalDate movieReleasedate;
	private String movieDuration;
	private String[] language;
	private String[] movieGenre;
	private String format;
	private String hero;
	private String heroine;
	private String director;
	private List<Theatre> theatres;
	
	
	

	/* Default Constructor sets 
	 the initial value*/
//	public Movie() {
//
//	}

	
	


}
