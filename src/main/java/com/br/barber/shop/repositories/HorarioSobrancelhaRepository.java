package com.br.barber.shop.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.br.barber.shop.models.HorarioSobrancelha;

@Repository
public interface HorarioSobrancelhaRepository extends CrudRepository<HorarioSobrancelha, Integer> {

	public Iterable<HorarioSobrancelha> findByDiaAndMesAndUsuarioIsNull(int dia, String mes);
}
