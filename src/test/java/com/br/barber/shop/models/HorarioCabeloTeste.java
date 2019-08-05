package com.br.barber.shop.models;


import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
public class HorarioCabeloTeste {
	
	private HorarioCabelo cabelo;
	
	@Before
	public void preparaCabelo() {
		
		cabelo = new HorarioCabelo();

		cabelo.setId(null);
		cabelo.setDia(1);
		cabelo.setMes("Outubro");
		cabelo.setHorario("8:00 as 9:00");
		cabelo.setUsuario(null);
	}

	@Test
	public void testarGetId() {
		assertEquals(null,cabelo.getId());

	}
	@Test
	public void testarGetDia() {

		assertEquals(1, cabelo.getDia());

	}
	@Test
	public void testarGetMes() {

		assertEquals("Outubro", cabelo.getMes());

	}
	@Test
	public void testarGetHorario() {

		assertEquals("8:00 as 9:00", cabelo.getHorario());

	}
	@Test
	public void testarGetUsuario() {

		assertEquals(null, cabelo.getUsuario());
	}

}
