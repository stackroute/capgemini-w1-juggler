package com.stackroute.juggler.movieschedule.domain;

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
public class TicketPrices {

	
	private int weekends_Price;
	private int weekdays_Price;
}
