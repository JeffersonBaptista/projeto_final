package com.br.barber.shop.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.br.barber.shop.models.Login;

@Repository
public interface LoginRepository extends CrudRepository<Login, Integer> {
	 

}
