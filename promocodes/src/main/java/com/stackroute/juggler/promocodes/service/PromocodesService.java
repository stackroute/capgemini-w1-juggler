package com.stackroute.juggler.promocodes.service;

import java.util.List;

import com.stackroute.juggler.promocodes.domain.Promocodes;

public interface PromocodesService {
	public Promocodes save(Promocodes promocode);

	public Promocodes getBycode(String code);

	public Iterable<Promocodes> getallpromocode();
	
	public String delete(String code);
}
