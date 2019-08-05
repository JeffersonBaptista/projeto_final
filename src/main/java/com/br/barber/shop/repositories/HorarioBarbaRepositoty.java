package com.br.barber.shop.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.br.barber.shop.models.HorarioBarba;
import com.br.barber.shop.models.Usuario;

@Repository
public interface HorarioBarbaRepositoty extends CrudRepository<HorarioBarba, Integer>{

	//	public Iterable<HorarioBarba> findByUsuarioAnd(Usuario usuario);
}
