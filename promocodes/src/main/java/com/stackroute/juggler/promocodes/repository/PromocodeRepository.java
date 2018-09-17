package com.stackroute.juggler.promocodes.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import com.stackroute.juggler.promocodes.domain.Promocodes;

@Repository
public interface PromocodeRepository extends CrudRepository<Promocodes, String> {

	public Promocodes getBycode(String codename);

}
