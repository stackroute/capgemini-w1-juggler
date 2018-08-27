package com.stackroute.juggler.kafka.domain;

import org.springframework.data.mongodb.core.mapping.Document;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Document
// @Data
// @NoArgsConstructor
// @AllArgsConstructor
// @Builder
public class TicketPrices {


	private int weekends_Price;
	private int weekdays_Price;

	public TicketPrices(int weekends_Price, int weekdays_Price) {
		super();
		this.weekends_Price = weekends_Price;
		this.weekdays_Price = weekdays_Price;
	}

	public int getWeekends_Price() {
		return weekends_Price;
	}

	public void setWeekends_Price(int weekends_Price) {
		this.weekends_Price = weekends_Price;
	}

	public int getWeekdays_Price() {
		return weekdays_Price;
	}

	public void setWeekdays_Price(int weekdays_Price) {
		this.weekdays_Price = weekdays_Price;
	}


	public TicketPrices() {
		super();
	}
}
