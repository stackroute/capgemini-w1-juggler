package com.stackroute.juggler.moviesearch.domain;

import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.stackroute.juggler.kafka.domain.TicketPrices;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Document
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder

public class Theatre {
	@Id
	private String theatreId;
	private String theatreName;
	private String theatreLocation;
	private String theatreLicenseNo;
	private String numberOfSeats;
	private String[] typeofseats;
	private int showNumbers;
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "HH:mm")
	private String[] showTimings;
	private TicketPrices ticketPrices;
	// List of all getters and setters
	public String getTheatreId() {
		return theatreId;
	}

	
	public void setTheatreId(String theatreId) {
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
	
	public String getTheatreLicenseNo() {
		return theatreLicenseNo;
	}
	public void setTheatreLicenseNo(String theatreLicenseNo) {
		this.theatreLicenseNo = theatreLicenseNo;
	}
	public String getNumberOfSeats() {
		return numberOfSeats;
	}
	public void setNumberOfSeats(String numberOfSeats) {
		this.numberOfSeats = numberOfSeats;
	}
	public String[] getTypeofseats() {
		return typeofseats;
	}
	public void setTypeofseats(String[] typeofseats) {
		this.typeofseats = typeofseats;
	}
	public int getShowNumbers() {
		return showNumbers;
	}
	public void setShowNumbers(int showNumbers) {
		this.showNumbers = showNumbers;
	}
	public String[] getShowTimings() {
		return showTimings;
	}
	public void setShowTimings(String[] showTimings) {
		this.showTimings = showTimings;
	}
	public TicketPrices getTicketPrices() {
		return ticketPrices;
	}
	public void setTicketPrices(TicketPrices ticketPrices) {
		this.ticketPrices = ticketPrices;
	}
	public Theatre(String theatreId, String theatreName, String theatreLocation,
			String theatreLicenseNo, String numberOfSeats, String[] typeofseats, int showNumbers, String[] showTimings,
			TicketPrices ticketPrices) {
		super();
		this.theatreId = theatreId;
		this.theatreName = theatreName;
		this.theatreLocation = theatreLocation;
	
		this.theatreLicenseNo = theatreLicenseNo;
		this.numberOfSeats = numberOfSeats;
		this.typeofseats = typeofseats;
		this.showNumbers = showNumbers;
		this.showTimings = showTimings;
		this.ticketPrices = ticketPrices;
	}
	
}