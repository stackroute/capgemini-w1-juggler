package com.stackroute.juggler.ticketengine.repository;

import java.util.Map;

import org.springframework.data.redis.core.HashOperations;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Repository;

import com.stackroute.juggler.ticketengine.domain.Show;

@Repository
public class ShowInfoRepositoryImpl implements ShowInfoRepository{

	private RedisTemplate<String, Object> redisTemplate;
	
	private HashOperations<String, String, Show> hashOperations;
	
	
	
	//constructor
	public ShowInfoRepositoryImpl(RedisTemplate<String, Object> redisTemplate) {
		this.redisTemplate = redisTemplate;
		hashOperations = redisTemplate.opsForHash();
	}
	
	
	
	//save show
	@Override
	public void save(Show show) {
		hashOperations.put("SHOW", show.getShowId(), show);
	}

	
	//update show
	@Override
	public void update(Show show) {
		save(show);
	}

	
	//find all shows
	@Override
	public Map<String, Show> findAll() {
		return hashOperations.entries("SHOW");
	}

	
	//delete by id
	@Override
	public void delete(String id) {
		hashOperations.delete("SHOW", id);
	}

	
	//get by id
	@Override
	public Show getById(String id) {
		return hashOperations.get("SHOW", id);
	}

}
