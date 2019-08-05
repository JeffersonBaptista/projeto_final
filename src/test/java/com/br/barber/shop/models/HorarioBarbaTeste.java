package com.br.barber.shop.models;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
public class HorarioBarbaTeste {

	private HorarioBarba barba;

	@Before
	public void preparaBarba() {

		barba = new HorarioBarba();

		barba.setId(null);
		barba.setDia(1);
		barba.setMes("Outubro");
		barba.setHorario("8:00 as 9:00");
		barba.setUsuario(null);
	}

	@Test
	public void testarGetId() {
		assertEquals(null, barba.getId());

	}
	@Test
	public void testarGetDia() {

		assertEquals(1, barba.getDia());

	}
	@Test
	public void testarGetMes() {

		assertEquals("Outubro", barba.getMes());

	}
	@Test
	public void testarGetHorario() {

		assertEquals("8:00 as 9:00", barba.getHorario());

	}
	@Test
	public void testarGetUsuario() {

		assertEquals(null, barba.getUsuario());
	}
}
