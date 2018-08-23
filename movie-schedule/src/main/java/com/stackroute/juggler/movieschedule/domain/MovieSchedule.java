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


public class MovieSchedule {
	
//	private int movie_Id;
//	private String movie_Name;
//	private int[] show_Timings;
//	private TicketPrices ticket_Prices;
	
	@Id
	private String theatreId;
    private String theatreLocation;
    private String theatreCity;
    private String theatreName;
    private String theatreLicenseNo;
    private String numberOfSeats;	
	private MovieDetails movieDetails;
	private int showNumbers;
	private int[] showTimings;
	private TicketPrices ticketPrices;
	private String bookingEndDate;
	

}
