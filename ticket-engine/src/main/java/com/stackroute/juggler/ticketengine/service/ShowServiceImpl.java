package com.stackroute.juggler.ticketengine.service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

import com.stackroute.juggler.kafka.domain.MovieSchedule;
import com.stackroute.juggler.kafka.domain.Seats;
import com.stackroute.juggler.ticketengine.domain.Show;
import com.stackroute.juggler.ticketengine.repository.ShowRepository;

@Service
public class ShowServiceImpl implements ShowService {

	private ShowRepository showRepo;

	@Autowired
	public ShowServiceImpl(ShowRepository showRepo) {
		this.showRepo = showRepo;
	}

	@Override
	public Show getById(String showId) {
		Optional<Show> local = showRepo.findById(showId);
		return local.get();
	}

	@Override
	public Iterable<Show> getAll() {
		return showRepo.findAll();
	}

	@Override
	public Show updateBlocked(Show show) {
		String id = show.getShowId();
		Optional<Show> local = showRepo.findById(id);
		Show locall = local.get();
		locall.setBlockedSeats(show.getBlockedSeats());
		return showRepo.save(locall);
	}
	
	@Override
	public Show updateBooked(Show show) {
		String id = show.getShowId();
		Optional<Show> local = showRepo.findById(id);
		Show locall = local.get();
		locall.setBookedSeats(show.getBookedSeats());
		return showRepo.save(locall);
	}

	@Override
	public void delete(String showId) {
		showRepo.deleteById(showId);
	}

	@Override
	@KafkaListener(topics = "screening-ticket", groupId = "ticket")
	public void getDetails(MovieSchedule movieSchedule) throws ParseException {
		MovieSchedule movielocal = new MovieSchedule();

		movielocal = movieSchedule;

		for (int i = 0; i < 7; i++) {
			String moviedate = movielocal.getMovieReleaseDate();
			String date = moviedate;
			Calendar c = Calendar.getInstance();
			SimpleDateFormat dateformatter = new SimpleDateFormat("dd/MM/yyyy");
			Date dateStart = dateformatter.parse(moviedate);
			String slots = movielocal.getShowTimings();
			int iddate = dateStart.getDate() + i;

			for (int j = 0; j < 3; j++) {
				String[] timmings = slots.split(",");
				String name = movielocal.getTheatreName();
				String city = movielocal.getTheatreCity();
				String finalid = name + "" + iddate + "" + timmings[j] + city;
				Show showlocal = new Show();
				showlocal.setShowId(finalid);
				showlocal.setTheatreName(movielocal.getTheatreName());
				showlocal.setMovieName(movielocal.getMovieName());
				int rdate = dateStart.getDate();
				rdate = rdate-7;
				if(rdate <=0) {
					rdate = 30 + rdate;
				}
				showlocal.setBookingDate(rdate);
				showlocal.setReleseDate(dateStart);
				showlocal.setCity(movielocal.getTheatreCity());
				showlocal.setSlot(timmings[j]);
				showlocal.setStatus(true);
				Seats localseats = movieSchedule.getSeatLayout();
				showlocal.setColValues(localseats.getColValues());
				showlocal.setRowValues(localseats.getRowValues());
				showlocal.setTotalCol(localseats.getTotalCol());
				showlocal.setTotalRow(localseats.getTotalRow());				
				List<Integer> booked = new ArrayList<>();
				List<Integer> blocked = new ArrayList<>();
				booked.add(0);
				blocked.add(0);
				showlocal.setBlockedSeats(blocked);
				showlocal.setBookedSeats(booked);
				showRepo.save(showlocal);
			}
		}
	}

	// @Override
	// public Show save(Show show) {
	// // TODO Auto-generated method stub
	// return null;
	// }

}
