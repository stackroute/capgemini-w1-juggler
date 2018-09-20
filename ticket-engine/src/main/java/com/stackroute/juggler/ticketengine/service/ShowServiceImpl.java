package com.stackroute.juggler.ticketengine.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

import com.stackroute.juggler.kafka.domain.TicketDetails;
import com.stackroute.juggler.ticketengine.domain.Show;
import com.stackroute.juggler.ticketengine.repository.SeatsRepository;
import com.stackroute.juggler.ticketengine.repository.ShowRepository;

@Service
public class ShowServiceImpl implements ShowService {

	private ShowRepository showRepo;
	private SeatsRepository seatRepo;

	@Autowired
	public ShowServiceImpl(ShowRepository showRepo, SeatsRepository seatRepo) {
		this.showRepo = showRepo;
		this.seatRepo = seatRepo;
	}

	@Override
	public Show getById(String showId) {
		Optional<Show> local = showRepo.findById(showId);
		return local.get();
	}

	@Override
	@KafkaListener(topics = "payment9", groupId = "pay", containerFactory = "payKafkaListenerContainerFactory")
	public void getBookedSeats(TicketDetails ticketDetails) {
		System.out.println("entered");
		System.out.println(ticketDetails.getBookingId());
		System.out.println(ticketDetails.getTheatreName());
		System.out.println(ticketDetails.getShowId());
		Optional<Show> local = showRepo.findById(ticketDetails.getShowId());
		System.out.println("qwert");
		System.out.println(ticketDetails.getBookedSeats());
		Show updatedshow = local.get();
		System.out.println(updatedshow.getMovieName());
		// updatedshow.setBookedSeats(ticketDetails.getBookedSeats());

		List<Integer> middle = updatedshow.getBookedSeats();
		List<Integer> mid = ticketDetails.getBookedSeats();
		for (int i = 0; i < mid.size(); i++) {
			if (mid.get(i) < 100) {
				middle.add(mid.get(i));
			} else {

			}
		}
		updatedshow.setBookedSeats(middle);
		System.out.println(updatedshow.getBookedSeats());
		updatedshow.getBookedSeats();
		System.out.println(ticketDetails);

		showRepo.save(updatedshow);
	}

}
