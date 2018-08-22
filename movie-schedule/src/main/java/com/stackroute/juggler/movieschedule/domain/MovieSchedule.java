package com.stackroute.juggler.movieschedule.domain;


import java.time.LocalDate;


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
	
	private MovieDetails movieDetails;
	private int showNumbers;
	private int[] showTimings;
	private TicketPrices ticketPrices;
	private LocalDate bookingEndDate;

	

}
