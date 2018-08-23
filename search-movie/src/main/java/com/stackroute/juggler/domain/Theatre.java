package com.stackroute.juggler.domain;

import java.io.File;
import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
//@Document(collection = "Theatre")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder

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
	
	
	
}
