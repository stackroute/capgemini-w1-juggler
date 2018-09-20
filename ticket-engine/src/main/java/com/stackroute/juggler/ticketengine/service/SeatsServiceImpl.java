package com.stackroute.juggler.ticketengine.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.stackroute.juggler.ticketengine.domain.Seats;
import com.stackroute.juggler.ticketengine.repository.SeatsRepository;

@Service
public class SeatsServiceImpl implements SeatsService {

	private SeatsRepository seatsRepo;

	@Autowired
	public SeatsServiceImpl(SeatsRepository seatsRepo) {
		this.seatsRepo = seatsRepo;

	}

	@Override
	public Seats save(Seats seats) {
		seats = seatsRepo.save(seats);
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
	public Optional<Seats> getByName(String name) {
		return seatsRepo.getByTheatreName(name);
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
	public List<Seats> getAll() {
		return seatsRepo.findAll();
	}

}
