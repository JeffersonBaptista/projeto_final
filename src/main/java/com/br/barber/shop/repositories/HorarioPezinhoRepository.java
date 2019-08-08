package com.br.barber.shop.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.br.barber.shop.models.HorarioPezinho;

@Repository
public interface HorarioPezinhoRepository extends CrudRepository<HorarioPezinho, Integer> {

	public Iterable<HorarioPezinho> findByDiaAndMesAndUsuarioIsNull(int dia, String mes);
}
