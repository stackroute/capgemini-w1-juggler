package com.stackroute.juggler.kafka.domain;

import java.time.LocalDate;
import java.time.LocalTime;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Getter;
import lombok.Setter;

//Domain object for showSchedule details
@Document
@Getter
@Setter
public class Show {

	@Id
	private String showId;
	private LocalDate showDate;
	private LocalTime showTime;
	private boolean showStatus;
	private MovieSchedule moviescheduleId;

	// All Arguments Constructor
	public Show(String showId, LocalDate showDate, LocalTime showTime, boolean showStatus,
			MovieSchedule moviescheduleId) {
		super();
		this.showId = showId;
		this.showDate = showDate;
		this.showTime = showTime;
		this.showStatus = showStatus;
		this.moviescheduleId = moviescheduleId;
	}

	public Show() {
		super();
	}

	public String getShowId() {
		return showId;
	}

	public void setShowId(String showId) {
		this.showId = showId;
	}

	public LocalDate getShowDate() {
		return showDate;
	}

	public void setShowDate(LocalDate showDate) {
		this.showDate = showDate;
	}

	public LocalTime getShowTime() {
		return showTime;
	}

	public void setShowTime(LocalTime showTime) {
		this.showTime = showTime;
	}

	public boolean isShowStatus() {
		return showStatus;
	}

	public void setShowStatus(boolean showStatus) {
		this.showStatus = showStatus;
	}

	public MovieSchedule getMoviescheduleId() {
		return moviescheduleId;
	}

	public void setMoviescheduleId(MovieSchedule moviescheduleId) {
		this.moviescheduleId = moviescheduleId;
	}

	@Override
	public String toString() {
		return "Show [showId=" + showId + ", showDate=" + showDate + ", showTime=" + showTime + ", showStatus="
				+ showStatus + ", moviescheduleId=" + moviescheduleId + "]";
	}

}
