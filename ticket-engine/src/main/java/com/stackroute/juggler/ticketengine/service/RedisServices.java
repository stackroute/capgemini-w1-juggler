package com.stackroute.juggler.ticketengine.service;

import java.util.List;

import com.stackroute.juggler.ticketengine.domain.RedisObject;

public interface RedisServices {

	public RedisObject save(RedisObject object);

	public void delete(String id);

	public List<RedisObject> getAll();

	public RedisObject getById(String id);

}
