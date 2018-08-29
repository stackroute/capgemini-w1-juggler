package com.stackroute.juggler.recommendation.services;

import com.stackroute.juggler.kafka.domain.City;

public interface CityService {
//	public City saveCity(City city);
	public City findByName(String name);
}
