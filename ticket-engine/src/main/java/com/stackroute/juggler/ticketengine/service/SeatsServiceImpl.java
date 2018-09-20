package com.stackroute.juggler.ticketengine.service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.format.DateTimeFormatter;
import java.util.Calendar;
import java.util.Date;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

import com.stackroute.juggler.kafka.domain.MovieSchedule;
import com.stackroute.juggler.ticketengine.domain.Seat;
import com.stackroute.juggler.ticketengine.domain.Show;
import com.stackroute.juggler.ticketengine.repository.SeatsRepository;
import com.stackroute.juggler.ticketengine.repository.ShowRepository;

@Service
public class SeatsServiceImpl implements SeatsService {

	private SeatsRepository seatsRepo;
	private ShowRepository showRepo;

	@Autowired
	public SeatsServiceImpl(SeatsRepository seatsRepo, ShowRepository showInfoRepo) {
		this.seatsRepo = seatsRepo;
		this.showRepo = showInfoRepo;
	}

	@Override
	@KafkaListener(topics = "screening-ticket", groupId = "ticket")
	public void getDetails(MovieSchedule movieSchedule) throws ParseException {
		MovieSchedule movielocal = new MovieSchedule();

		movielocal = movieSchedule;

		for (int i = 0; i < 7; i++) {
			String moviedate = movielocal.getMovieReleaseDate();
//			DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
			String date = moviedate;
			Calendar c = Calendar.getInstance();
			SimpleDateFormat dateformatter = new SimpleDateFormat("dd/MM/yyyy");
			Date dateStart = dateformatter.parse(moviedate);
			String slots = movielocal.getShowTimings();
			int iddate = dateStart.getDate() + i;

			for (int j = 0; j < 3; j++) {
				String[] timmings = slots.split(",");
				// System.out.println(timmings[j]);
				String name = movielocal.getTheatreName();
				String finalid = name + "" + iddate + "" + timmings[j];
				Seat seatlocal = new Seat();
				Show showlocal = new Show();
				seatlocal.setId(finalid);
				seatlocal.setDate(dateStart);
				seatlocal.setShowSlot(timmings[j]);
				seatsRepo.save(seatlocal);
				showlocal.setShowId(finalid);
				showlocal.setTheatreName(movielocal.getTheatreName());
				showlocal.setMovieName(movielocal.getMovieName());
				showlocal.setDate(dateStart);
				showlocal.setSlot(timmings[j]);
				showlocal.setStatus(true);
				showRepo.save(showlocal);
			}
		}
	}
	
//	@Override
//	@KafkaListener(topics = "payment3", groupId = "pay", containerFactory = "payKafkaListenerContainerFactory")
//	public void getBookedSeats(TicketDetails ticketDetails) {
//		System.out.println("entered");
//		Optional<Show> local = showRepo.findById(ticketDetails.getShowId());
//		Show updatedshow = local.get();
//		System.out.println(ticketDetails);
//		showRepo.save(updatedshow);
//	}

//	@Override
//	public Show getById(String showId) {
//		Optional<Show> local = showRepo.findById(showId);
//		return local.get();
//		
//	}

	@Override
	public Seat findById(String showId) {
		Optional<Seat> local = seatsRepo.findById(showId);
		return local.get();
	}

	@Override
	public Seat save(Seat seat) {
		seatsRepo.save(seat);
		return seat;
	}
	
//	private SeatsRepository seatsRepo;
//	private ShowRepository showRepo;

}
