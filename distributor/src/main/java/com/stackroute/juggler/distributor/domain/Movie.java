package com.stackroute.juggler.distributor.domain;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Document
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Movie {

	@Id
	private String id;
	private String movieName;
	private String moviePoster;
	private String movieReleaseDate;
	private String movieDuration;
	private String Hero;
	private String Heroine;
	private String Director;
	private String[] movieGenre;
	private String synopsis;
	private String format;
	private String[] language;
}
