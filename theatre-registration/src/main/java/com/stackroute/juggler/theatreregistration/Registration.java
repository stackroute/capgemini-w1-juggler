package com.stackroute.juggler.theatreregistration;

public class Registration {
	private String theatreId;
	private String theatreLocation;
	private String theatreName;
	private int theatreLicenseNo;
	private String typesOfSeats;
	private int numberOfSeats;
	private int numberOfShows;

	public Registration() {

	}

	public Registration(String theatreId, String theatreLocation, String theatreName, int theatreLicenseNo,
			String typesOfSeats, int numberOfSeats, int numberOfShows) {
		super();
		this.theatreId = theatreId;
		this.theatreLocation = theatreLocation;
		this.theatreName = theatreName;
		this.theatreLicenseNo = theatreLicenseNo;
		this.typesOfSeats = typesOfSeats;
		this.numberOfSeats = numberOfSeats;
		this.numberOfShows = numberOfShows;
	}

	public String getTheatreId() {
		return theatreId;
	}

	public void setTheatreId(String theatreId) {
		this.theatreId = theatreId;
	}

	public String getTheatreLocation() {
		return theatreLocation;
	}

	public void setTheatreLocation(String theatreLocation) {
		this.theatreLocation = theatreLocation;
	}

	public String getTheatreName() {
		return theatreName;
	}

	public void setTheatreName(String theatreName) {
		this.theatreName = theatreName;
	}

	public int getTheatreLicenseNo() {
		return theatreLicenseNo;
	}

	public void setTheatreLicenseNo(int theatreLicenseNo) {
		this.theatreLicenseNo = theatreLicenseNo;
	}

	public String getTypesOfSeats() {
		return typesOfSeats;
	}

	public void setTypesOfSeats(String typesOfSeats) {
		this.typesOfSeats = typesOfSeats;
	}

	public int getNumberOfSeats() {
		return numberOfSeats;
	}

	public void setNumberOfSeats(int numberOfSeats) {
		this.numberOfSeats = numberOfSeats;
	}

	public int getNumberOfShows() {
		return numberOfShows;
	}

	public void setNumberOfShows(int numberOfShows) {
		this.numberOfShows = numberOfShows;
	}

}
