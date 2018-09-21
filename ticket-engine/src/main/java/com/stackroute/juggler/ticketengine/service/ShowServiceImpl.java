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
import com.stackroute.juggler.kafka.domain.TicketDetails;
import com.stackroute.juggler.kafka.domain.TriggerMessage;
import com.stackroute.juggler.ticketengine.domain.Show;
import com.stackroute.juggler.ticketengine.domain.ShowHistory;
import com.stackroute.juggler.ticketengine.repository.ShowHistoryRepository;
import com.stackroute.juggler.ticketengine.repository.ShowRepository;

@Service
public class ShowServiceImpl implements ShowService {

	private ShowRepository showRepo;
	private ShowHistoryRepository showhistoryRepo;

	@Autowired
	public ShowServiceImpl(ShowRepository showRepo, ShowHistoryRepository showhistoryRepo) {
		this.showRepo = showRepo;
		this.showhistoryRepo = showhistoryRepo;
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
		List<Integer> middle = locall.getBlockedSeats();
		List<Integer> mid = show.getBlockedSeats();
		for (int i = 0; i < mid.size(); i++) {
			if (mid.get(i) < 100) {
				middle.add(mid.get(i));
			} else {
			}
		}
		locall.setBlockedSeats(middle);
		return showRepo.save(locall);
	}

	@Override
	public Show updateBooked(Show show) {
		String id = show.getShowId();
		Optional<Show> local = showRepo.findById(id);
		Show locall = local.get();
		List<Integer> middle = locall.getBookedSeats();
		List<Integer> mid = show.getBookedSeats();
		for (int i = 0; i < mid.size(); i++) {
			if (mid.get(i) < 100) {
				middle.add(mid.get(i));
			} else {
			}
		}
		locall.setBookedSeats(middle);
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
			// String date = moviedate;
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
				rdate = rdate - 7;

				if (rdate <= 0) {
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

	@Override
	@KafkaListener(topics = "payment", groupId = "pat")
	public void getBookedSeats(TicketDetails ticketDetails) {
		if (ticketDetails.getBookingStatus().equals("Success")) {
			String showid = ticketDetails.getShowId();
			Show local = getById(ticketDetails.getShowId());
			List<Integer> middle = local.getBookedSeats();
			List<Integer> mid = ticketDetails.getBookedSeats();
			for (int i = 0; i < mid.size(); i++) {
				if (mid.get(i) < 100) {
					middle.add(mid.get(i));
				} else {
				}
			}
			ticketDetails.getBookedSeats();
			for (int j = 0; j < middle.size(); j++) {
				for (int i = 0; i < mid.size(); i++) {
					if (mid.get(i) < 100) {
						if (mid.get(i) == middle.get(j)) {
							middle.remove(mid.get(i));
							System.out.println("hello");
						} else {
							System.out.println("bolo");
						}
					}
				}
			}
			showRepo.save(local);
			local.setBookedSeats(middle);
			showRepo.save(local);

			System.out.println("Hai");
		} else {
			ticketDetails.getBookedSeats();
			String showid = ticketDetails.getShowId();
			Show local = getById(ticketDetails.getShowId());
			List<Integer> middle = local.getBlockedSeats();
			List<Integer> mid = ticketDetails.getBookedSeats();
			for (int j = 0; j < middle.size(); j++) {
				for (int i = 0; i < mid.size(); i++) {
					if (mid.get(i) < 100) {
						if (mid.get(i) == middle.get(j)) {
							middle.remove(mid.get(i));
							System.out.println("hello");
						} else {
							System.out.println("bolo");
						}
					}
				}
			}
			showRepo.save(local);
		}
	}

	@Override
	@KafkaListener(topics = "show-scheduler", groupId = "schedule")
	public void getSchedulerTrigger(TriggerMessage object) throws ParseException {

		// ShowSheduler schedule = new ShowSheduler();
		String name = object.getTheatreName();
		String city = object.getCity();
		String date = object.getDateToStop();
		String timming = object.getSlotToStop();
		SimpleDateFormat dateformatter = new SimpleDateFormat("yyyy/MM/dd");
		Date dateStart = dateformatter.parse(date);
		int iddate = dateStart.getDate();
		String showid = name + iddate + timming + city;
		Optional<Show> showw = showRepo.findById(showid);
		Show local = showw.get();
		ShowHistory showhistory = new ShowHistory(local.getShowId(), local.getCity(), local.getMovieName(),
				local.getTheatreName(), local.getBookingDate(), local.getReleseDate(), local.getShowDate(),
				local.getSlot(), local.getStatus(), local.getBookedSeats(), local.getBlockedSeats(),
				local.getTotalRow(), local.getTotalCol(), local.getRowValues(), local.getColValues());
		showhistoryRepo.save(showhistory);
		System.out.println(showid);
		showRepo.deleteById(showid);
		System.out.println("Hai");

	}

}
