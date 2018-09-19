package com.stackroute.juggler.ticketengine.repository;

import java.util.Map;

import com.stackroute.juggler.ticketengine.domain.Show;

public interface ShowInfoRepository {

	public void save(Show show);
	
	public void update(Show show);
	
	public Map<String, Show> findAll();
	
	public void delete(String id);
	
	public Show getById(String id);

//	List<Show> getAll();

//	Show deleteByScheduler(String theatreName, String date, String slot);
	
}
