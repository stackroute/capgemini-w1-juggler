package com.stackroute.juggler.movieschedule.domain;

<<<<<<< HEAD
=======
import java.time.LocalDate;

>>>>>>> 63ce83ece91d925925a048a33402f1329815819d
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
<<<<<<< HEAD
public class MovieSchedule {
	
	private int movie_Id;
	private String movie_Name;
	private int[] show_Timings;
	private TicketPrices ticket_Prices;
=======

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
>>>>>>> 63ce83ece91d925925a048a33402f1329815819d
	

}
