package com.br.barber.shop.models;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

public class HorarioPezinhoTeste {
	private HorarioPezinho pezinho;
	@Before
	public void preparaPezinho() {

		pezinho = new HorarioPezinho();

		pezinho.setId(null);
		pezinho.setDia(1);
		pezinho.setMes("Outubro");
		pezinho.setHorario("8:00 as 9:00");
		pezinho.setUsuario(null);
	}

	@Test
	public void testarGetId() {
		assertEquals(null,pezinho.getId());

	}
	@Test
	public void testarGetDia() {

		assertEquals(1, pezinho.getDia());

	}
	@Test
	public void testarGetMes() {

		assertEquals("Outubro", pezinho.getMes());

	}
	@Test
	public void testarGetHorario() {

		assertEquals("8:00 as 9:00", pezinho.getHorario());

	}
	@Test
	public void testarGetUsuario() {

		assertEquals(null, pezinho.getUsuario());
	}

}
