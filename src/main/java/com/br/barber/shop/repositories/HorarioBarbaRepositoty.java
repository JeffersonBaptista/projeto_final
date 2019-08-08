package com.br.barber.shop.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.br.barber.shop.models.HorarioBarba;

@Repository
public interface HorarioBarbaRepositoty extends CrudRepository<HorarioBarba, Integer>{

	public Iterable<HorarioBarba> findByDiaAndMesAndUsuarioIsNull(int dia, String mes);
	
	public Iterable<HorarioBarba> findByUsuarioIsNull();
}
