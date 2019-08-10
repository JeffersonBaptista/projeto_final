package com.br.barber.shop.services;

import static org.junit.Assert.assertEquals;
import static org.mockito.BDDMockito.given;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

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
import com.br.barber.shop.repositories.HorarioBarbaRepositoty;
import com.br.barber.shop.repositories.HorarioCabeloRepository;
import com.br.barber.shop.repositories.HorarioPezinhoRepository;
import com.br.barber.shop.repositories.HorarioSobrancelhaRepository;

@RunWith(SpringRunner.class)
@WebMvcTest(HorarioBarbaService.class)
public class HorarioBarbaServiceTeste {

	@Autowired
	private MockMvc mockMvc;

	@MockBean
	HorarioBarbaRepositoty horarioBarbaRepository;

	@MockBean
	HorarioCabeloRepository horarioCabeloRepository;

	@MockBean
	HorarioPezinhoRepository horarioPezinhoRepository;

	@MockBean
	HorarioSobrancelhaRepository horarioSobrancelhaRepository;

	private HorarioBarba barba;
	private HorarioCabelo cabelo;
	private HorarioSobrancelha sobrancelha;
	private HorarioPezinho pezinho;

	private int id;

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

		id = 1;

	}

	@Test
	public void exibirTodosHorariosBarbaTeste() {

		List<HorarioBarba> barbas = Arrays.asList(barba);

		given(horarioBarbaRepository.findAll()).willReturn(barbas);
		given(horarioBarbaRepository.count()).willReturn(1L);

		assertEquals(barbas, horarioBarbaRepository.findAll());
		assertEquals(1, horarioBarbaRepository.count());

	}

	@Test
	public void exibirTodosHorariosCabeloTeste() {

		List<HorarioCabelo> cabelos = Arrays.asList(cabelo);

		given(horarioCabeloRepository.findAll()).willReturn(cabelos);
		given(horarioCabeloRepository.count()).willReturn(1L);

		assertEquals(cabelos, horarioCabeloRepository.findAll());
		assertEquals(1, horarioCabeloRepository.count());

	}

	@Test
	public void exibirTodosHorariosSobrancelhaTeste() {

		List<HorarioSobrancelha> Sobrancelhas = Arrays.asList(sobrancelha);

		given(horarioSobrancelhaRepository.findAll()).willReturn(Sobrancelhas);
		given(horarioSobrancelhaRepository.count()).willReturn(1L);

		assertEquals(Sobrancelhas, horarioSobrancelhaRepository.findAll());
		assertEquals(1, horarioSobrancelhaRepository.count());

	}
	@Test
	public void exibirTodosHorariosPezinhoTeste() {

		List<HorarioPezinho> pezinhos = Arrays.asList(pezinho);

		given(horarioPezinhoRepository.findAll()).willReturn(pezinhos);
		given(horarioPezinhoRepository.count()).willReturn(1L);

		assertEquals(pezinhos, horarioPezinhoRepository.findAll());
		assertEquals(1, horarioPezinhoRepository.count());

	}
	

//	@Test
//	public void pegarHorarioBarbaPorIdTeste() {
//		barba.setId(1);
//
//		given(horarioBarbaRepository.findById(id).get()).willReturn(barba);
//		given(horarioBarbaRepository.count()).willReturn(1L);
//
//		HorarioBarba barbaTeste = new HorarioBarba();
//		barbaTeste = horarioBarbaRepository.findById(id).get();
//
//		assertEquals(1, barbaTeste.getId(), 0);
//		assertEquals(1, barbaTeste.getDia(), 0);
//		assertEquals("Outubro", barbaTeste.getMes());
//		assertEquals("8:00 as 9:00", barbaTeste.getHorario());
//		assertEquals(null, barbaTeste.getUsuario());
//
//	}
}
