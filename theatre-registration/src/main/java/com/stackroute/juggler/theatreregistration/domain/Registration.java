package com.stackroute.juggler.theatreregistration.domain;

import java.io.File;
import org.springframework.data.annotation.Id;
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
public class Registration {
	@Id
	private String theatreId;
	private String theatreLocation;
	private String theatreCity;
	private String theatreName;
	private int theatreLicenseNo;
//	private String[] typesOfSeats;
	private int numberOfSeats;
//	private String[] screenedmovies;
//	private String[] runningmovies;
	// private int numberOfShows;
	// private File seatLayout;

}
