package com.stackroute.juggler.movieschedule.domain;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
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

public class MovieSchedule {

	// @Id
	 private String theatreId;
	 private String theatreLocation;
	 @Indexed
	 private String theatreCity;
	 private String theatreName;
	 private String theatreLicenseNo;
	 private String numberOfSeats;
	
//	private TheatreDetails theatreDetails;
	private MovieDetails movieDetails;
	private int showNumbers;
	private int[] showTimings;
	private TicketPrices ticketPrices;
	private String bookingEndDate;

}
