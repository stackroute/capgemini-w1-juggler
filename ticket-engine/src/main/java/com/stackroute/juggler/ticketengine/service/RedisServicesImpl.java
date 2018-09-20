package com.stackroute.juggler.ticketengine.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.stackroute.juggler.ticketengine.domain.RedisObject;
import com.stackroute.juggler.ticketengine.repository.RedisRepo;

@Service
public class RedisServicesImpl implements RedisServices {

	private RedisRepo repo;

	@Autowired
	public RedisServicesImpl(RedisRepo repo) {
		this.repo = repo;
	}

	@Override
	public RedisObject save(RedisObject object) {
		return repo.save(object);
	}

	@Override
	public void delete(String id) {
		repo.deleteById(id);
	}

	@Override
	public List<RedisObject> getAll() {
		return (List<RedisObject>) repo.findAll();
	}

	@Override
	public RedisObject getById(String id) {
		return repo.findById(id).get();
	}

}
