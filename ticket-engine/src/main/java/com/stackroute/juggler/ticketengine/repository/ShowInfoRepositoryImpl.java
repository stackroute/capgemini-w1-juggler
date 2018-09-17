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
	
	public ShowInfoRepositoryImpl(RedisTemplate<String, Object> redisTemplate) {
		this.redisTemplate = redisTemplate;
		hashOperations = redisTemplate.opsForHash();
	}
	
	@Override
	public void save(Show show) {
		hashOperations.put("SHOW", show.getShowId(), show);
	}

	@Override
	public void update(Show show) {
		save(show);
	}

	@Override
	public Map<String, Show> findAll() {
		return hashOperations.entries("SHOW");
	}

	@Override
	public void delete(String id) {
		hashOperations.delete("SHOW", id);
	}

	@Override
	public Show getById(String id) {
		return hashOperations.get("SHOW", id);
	}

}
