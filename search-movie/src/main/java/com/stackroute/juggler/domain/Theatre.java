package com.stackroute.juggler.domain;

import java.io.File;
import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;


@Document


//pojo for theater
public class Theatre {
	@Id
	private int theatreId;
	private String theatreName;
	private String theatreLocation;
	private String theatreCity;
	private File seatLayout;
	private List<Show> shows;
//	@Override
//	public String toString() {
//		return "Theatre [theatreId=" + theatreId + ", theatreName=" + theatreName + ", theatreLocation="
//				+ theatreLocation + ", theatreCity=" + theatreCity + ", seatLayout=" + seatLayout + ", shows=" + shows
//				+ "]";
//	}
	public int getTheatreId() {
		return theatreId;
	}
	public void setTheatreId(int theatreId) {
		this.theatreId = theatreId;
	}
	public String getTheatreName() {
		return theatreName;
	}
	public void setTheatreName(String theatreName) {
		this.theatreName = theatreName;
	}
	public String getTheatreLocation() {
		return theatreLocation;
	}
	public void setTheatreLocation(String theatreLocation) {
		this.theatreLocation = theatreLocation;
	}
	public String getTheatreCity() {
		return theatreCity;
	}
	public void setTheatreCity(String theatreCity) {
		this.theatreCity = theatreCity;
	}
	public File getSeatLayout() {
		return seatLayout;
	}
	public void setSeatLayout(File seatLayout) {
		this.seatLayout = seatLayout;
	}
	public List<Show> getShows() {
		return shows;
	}
	public void setShows(List<Show> shows) {
		this.shows = shows;
	}
	
	
	
}
