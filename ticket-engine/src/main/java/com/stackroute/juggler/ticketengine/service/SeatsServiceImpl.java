package com.stackroute.juggler.ticketengine.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.stackroute.juggler.ticketengine.domain.Seats;
import com.stackroute.juggler.ticketengine.domain.Show;
import com.stackroute.juggler.ticketengine.repository.SeatsRepository;
import com.stackroute.juggler.ticketengine.repository.ShowInfoRepository;

@Service
public class SeatsServiceImpl implements SeatsService {

	private SeatsRepository seatsRepo;
	private ShowInfoRepository showInfoRepo;

	@Autowired
	public SeatsServiceImpl(SeatsRepository seatsRepo, ShowInfoRepository showInfoRepo) {
		this.seatsRepo = seatsRepo;
		this.showInfoRepo = showInfoRepo;
	}

	@Override
	public Seats save(Seats seats) {
		seats = seatsRepo.save(seats);
		
//		Show show = showInfoRepo.getById(seats.getId());
//		for (int i : seats.getSeats()) {
//			try {
//			if (show.getSeats().get(i).equals("blocked")) {
//				throw new Exception("Seat No: " + i + " is already blocked");
//			} else if (show.getSeats().get(i).equals("booked")) {
//				throw new Exception("Seat No: " + i + " is already booked");
//			} else {
//				show.getSeats().put(i, "blocked");
//			}
//			} catch(Exception e) {
//				e.printStackTrace();
//			}
//		}
//		showInfoRepo.save(show);
	    return seats;
	}

	@Override
	public Seats update(Seats seats) {
		return save(seats);
	}

	@Override
	public Optional<Seats> getById(String id) {
		return seatsRepo.findById(id);
	}

	@Override
	public void delete(String id) {
		seatsRepo.deleteById(id);
	}

	@Override
	public void removeAll() {
		seatsRepo.deleteAll();
	}

	@Override
	public Iterable<Seats> getAll() {
		return seatsRepo.findAll();
	}

}
