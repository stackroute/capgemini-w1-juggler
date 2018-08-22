package com.stackroute.juggler.domain;

import java.io.File;
import java.util.List;

import org.springframework.data.annotation.Id;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@Data
@AllArgsConstructor
@NoArgsConstructor

//pojo for theater
public class Theatre {
	@Id
	private int theatreId;
	private String theatreName;
	private String theatreLocation;
	private String theatreCity;
	private File seatLayout;
	private List<Show> shows;
}
