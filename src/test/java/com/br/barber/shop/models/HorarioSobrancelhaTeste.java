package com.br.barber.shop.models;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
public class HorarioSobrancelhaTeste {

	private HorarioSobrancelha sobrancelha;

	@Before
	public void preparaSobrancelha() {

		sobrancelha = new HorarioSobrancelha();

		sobrancelha.setId(null);
		sobrancelha.setDia(1);
		sobrancelha.setMes("Outubro");
		sobrancelha.setHorario("8:00 as 9:00");
		sobrancelha.setUsuario(null);
	}

	@Test
	public void testarGetId() {
		assertEquals(null, sobrancelha.getId());

	}

	@Test
	public void testarGetDia() {

		assertEquals(1, sobrancelha.getDia());

	}

	@Test
	public void testarGetMes() {

		assertEquals("Outubro", sobrancelha.getMes());

	}

	@Test
	public void testarGetHorario() {

		assertEquals("8:00 as 9:00", sobrancelha.getHorario());

	}

	@Test
	public void testarGetUsuario() {

		assertEquals(null, sobrancelha.getUsuario());
	}

}
