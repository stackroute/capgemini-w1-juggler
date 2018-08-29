package com.stackroute.juggler.kafka.domain;

import org.springframework.data.mongodb.core.mapping.Document;

@Document
// Domain object for show details
public class Show {
	private String[] showTimings;

	public String[] getShowTimings() {
		return showTimings;
	}

	public void setShowTimings(String[] showTimings) {
		this.showTimings = showTimings;
	}
}
