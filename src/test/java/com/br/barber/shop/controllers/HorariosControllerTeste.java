package com.br.barber.shop.controllers;

import static org.hamcrest.collection.IsCollectionWithSize.hasSize;
import static org.mockito.BDDMockito.given;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.Arrays;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import com.br.barber.shop.models.HorarioBarba;
import com.br.barber.shop.models.HorarioCabelo;
import com.br.barber.shop.models.HorarioPezinho;
import com.br.barber.shop.models.HorarioSobrancelha;
import com.br.barber.shop.services.HorarioBarbaService;
import com.br.barber.shop.services.HorarioCabeloService;
import com.br.barber.shop.services.HorarioPezinhoService;
import com.br.barber.shop.services.HorarioSobrancelhaService;

@RunWith(SpringRunner.class)
@WebMvcTest(HorariosController.class)
public class HorariosControllerTeste {

	@Autowired
	private MockMvc mockMvc;

	// cria um service falso para teste
	@MockBean
	HorarioCabeloService cabeloService;

	@MockBean
	HorarioBarbaService barbaService;

	@MockBean
	HorarioPezinhoService pezinhoService;

	@MockBean
	HorarioSobrancelhaService sobrancelhaService;

	private HorarioBarba barba;
	private HorarioCabelo cabelo;
	private HorarioSobrancelha sobrancelha;
	private HorarioPezinho pezinho;

	@Before
	public void prepararHorarios() {

		barba = new HorarioBarba();
		barba.setId(null);
		barba.setDia(1);
		barba.setMes("Outubro");
		barba.setHorario("8:00 as 9:00");
		barba.setUsuario(null);

		cabelo = new HorarioCabelo();
		cabelo.setId(null);
		cabelo.setDia(1);
		cabelo.setMes("Outubro");
		cabelo.setHorario("8:00 as 9:00");
		cabelo.setUsuario(null);

		pezinho = new HorarioPezinho();
		pezinho.setId(null);
		pezinho.setDia(1);
		pezinho.setMes("Outubro");
		pezinho.setHorario("8:00 as 9:00");
		pezinho.setUsuario(null);

		sobrancelha = new HorarioSobrancelha();
		sobrancelha.setId(null);
		sobrancelha.setDia(1);
		sobrancelha.setMes("Outubro");
		sobrancelha.setHorario("8:00 as 9:00");
		sobrancelha.setUsuario(null);

	}

	@Test
	public void testarPegarHorasCabelo() throws Exception {
		List<HorarioCabelo> horariosCabelo = Arrays.asList(cabelo);

		given(cabeloService.exibirTodoshorariosCabelos()).willReturn(horariosCabelo);
		given(cabeloService.quantidadeHorarioCabelo()).willReturn(1L);

		this.mockMvc.perform(get("/api/zup/barber/shop/todos/cabelo"))
		.andExpect(status().isOk())
		.andExpect(jsonPath("$", hasSize(1)))
		.andExpect(jsonPath("$[*].id").isNotEmpty());

	}
	
	@Test
	public void testarPegarHorasPezinho() throws Exception {
		List<HorarioPezinho> horariosPezinho = Arrays.asList(pezinho);

		given(pezinhoService.exibirTodoshorariosPezinho()).willReturn(horariosPezinho);
		given(pezinhoService.quantidadeHorarioPezinho()).willReturn(1L);

		this.mockMvc.perform(get("/api/zup/barber/shop/todos/pezinho"))
		.andExpect(status().isOk())
		.andExpect(jsonPath("$", hasSize(1)))
		.andExpect(jsonPath("$[*].id").isNotEmpty());

	}
	@Test
	public void testarPegarHorasBarba() throws Exception {
		List<HorarioBarba> horariosBarba = Arrays.asList(barba);

		given(barbaService.exibirTodosHorariosBarba()).willReturn(horariosBarba);
		given(barbaService.quantidadeHorarioBarba()).willReturn(1L);

		this.mockMvc.perform(get("/api/zup/barber/shop/todos/barba"))
		.andExpect(status().isOk())
		.andExpect(jsonPath("$", hasSize(1)))
		.andExpect(jsonPath("$[*].id").isNotEmpty());

	}
	
	@Test
	public void testarPegarSobrancelha() throws Exception {
		List<HorarioSobrancelha> horariosSobrancelha = Arrays.asList(sobrancelha);

		given(sobrancelhaService.exibirTodosHorariosSobrancelha()).willReturn(horariosSobrancelha);
		given(sobrancelhaService.quantidadeHorarioSobrancelha()).willReturn(1L);

		this.mockMvc.perform(get("/api/zup/barber/shop/todos/sobrancelha"))
		.andExpect(status().isOk())
		.andExpect(jsonPath("$", hasSize(1)))
		.andExpect(jsonPath("$[*].id").isNotEmpty());

	}
	

}
