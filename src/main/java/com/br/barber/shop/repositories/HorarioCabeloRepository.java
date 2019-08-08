package com.br.barber.shop.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.br.barber.shop.models.HorarioCabelo;

@Repository
public interface HorarioCabeloRepository extends CrudRepository<HorarioCabelo, Integer> {

	public Iterable<HorarioCabelo> findByDiaAndMesAndUsuarioIsNull(int dia, String mes);
}
