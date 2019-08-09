package com.br.barber.shop.services;

import org.junit.Before;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import com.br.barber.shop.models.HorarioBarba;
import com.br.barber.shop.repositories.HorarioBarbaRepositoty;

@RunWith(SpringRunner.class)
@WebMvcTest(HorarioBarbaService.class)
public class HorarioBarbaServiceTeste {

	@Autowired
	private MockMvc mockMvc;

	@MockBean
	HorarioBarbaRepositoty horarioBarbaRepository;

	HorarioBarba barba;

	@Before
	public void prepararBarba() {

		barba = new HorarioBarba();
		barba.setId(null);
		barba.setDia(1);
		barba.setMes("Outubro");
		barba.setHorario("8:00 as 9:00");
		barba.setUsuario(null);
	}
}
