package com.stackroute.juggler.domain;
//pojo for show

import org.springframework.data.mongodb.core.mapping.Document;



@Document

public class Show {
private String[] showTimings;

public String[] getShowTimings() {
	return showTimings;
}

public void setShowTimings(String[] showTimings) {
	this.showTimings = showTimings;
}





}
