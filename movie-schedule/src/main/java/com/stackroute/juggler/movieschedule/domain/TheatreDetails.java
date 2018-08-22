package com.stackroute.juggler.movieschedule.domain;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Document
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class TheatreDetails {
	
	@Id
	private int theatreId;
	private String theatreName;
	private String theatreLocation;
	private String theatreCity;
	private MovieSchedule showSchedule;

}
