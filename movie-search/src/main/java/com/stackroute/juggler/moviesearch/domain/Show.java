package com.stackroute.juggler.moviesearch.domain;

import org.springframework.data.mongodb.core.mapping.Document;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Document
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Show {
	private String[] showTimings;

	public String[] getShowTimings() {
		return showTimings;
	}

	public void setShowTimings(String[] showTimings) {
		this.showTimings = showTimings;
	}
}
