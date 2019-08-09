package com.br.barber.shop.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.br.barber.shop.models.HorarioBarba;
import com.br.barber.shop.models.HorarioCabelo;
import com.br.barber.shop.models.HorarioPezinho;
import com.br.barber.shop.models.HorarioSobrancelha;
import com.br.barber.shop.models.Usuario;
import com.br.barber.shop.services.HorarioBarbaService;
import com.br.barber.shop.services.HorarioCabeloService;
import com.br.barber.shop.services.HorarioPezinhoService;
import com.br.barber.shop.services.HorarioSobrancelhaService;
import com.br.barber.shop.services.UsuarioService;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/api/zup/barber/shop/")
public class HorariosController {

	@Autowired
	private HorarioBarbaService horarioBarbaService;

	@Autowired
	private HorarioCabeloService horarioCabeloService;

	@Autowired
	private HorarioPezinhoService horarioPezinhoService;

	@Autowired
	private HorarioSobrancelhaService horarioSobrancelhaService;

	@Autowired
	private UsuarioService usuarioService;

	@GetMapping("todos/barba")
	public ResponseEntity<?> exibirTodosHorariosBarba() {

		return ResponseEntity.ok().body(horarioBarbaService.exibirTodosHorariosBarba());

	}

	@GetMapping("todos/cabelo")
	public ResponseEntity<?> exibirTodosHorariosCabelo() {

		return ResponseEntity.ok().body(horarioCabeloService.exibirTodoshorariosCabelos());

	}

	@GetMapping("todos/pezinho")
	public ResponseEntity<?> exibirTodosHorariosPezinho() {

		return ResponseEntity.ok().body(horarioPezinhoService.exibirTodoshorariosPezinho());

	}

	@GetMapping("todos/sobrancelha")
	public ResponseEntity<?> exibirTodosHorariosSobrancelha() {

		return ResponseEntity.ok().body(horarioSobrancelhaService.exibirTodosHorariosSobrancelha());

	}

	@PostMapping("criar/mes/{diasMes}")
	public ResponseEntity<?> gerarHorarios(@PathVariable int diasMes, @RequestBody HorarioCabelo horario) {

		try {
			String nomeMes = horario.getMes();
			horarioBarbaService.gerarHorariosBarba(nomeMes, diasMes);
			horarioCabeloService.gerarHorariosCabelo(nomeMes, diasMes);
			horarioSobrancelhaService.gerarHorariosSobrancelha(nomeMes, diasMes);
			horarioPezinhoService.gerarHorariosPezinho(nomeMes, diasMes);
			return ResponseEntity.status(HttpStatus.CREATED).build();

		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e);

		}
	}

	@PutMapping("agendar/barba/{idHorario}")
	public ResponseEntity<?> agendarCorteBarba(@PathVariable int idHorario, @RequestBody HorarioBarba novoAgendamento) {
		try {
			Usuario usuario = usuarioService.pegarUsuarioPorID(novoAgendamento.getUsuario().getId());

			HorarioBarba barba = horarioBarbaService.pegarHorarioBarbaPorId(idHorario);
			barba.setUsuario(usuario);

			horarioBarbaService.agendarBarba(barba);
			return ResponseEntity.status(HttpStatus.CREATED).build();
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e);
		}

	}

	@PutMapping("agendar/pezinho/{idHorario}")
	public ResponseEntity<?> agendarPezinho(@PathVariable int idHorario,
			@RequestBody HorarioPezinho novoAgendamentoPezinho) {

		try {
			Usuario usuario = usuarioService.pegarUsuarioPorID(novoAgendamentoPezinho.getUsuario().getId());

			HorarioPezinho pezinho = horarioPezinhoService.pegarHorarioPorId(idHorario);
			pezinho.setUsuario(usuario);

			horarioPezinhoService.agendarPezinho(pezinho);
			return ResponseEntity.status(HttpStatus.CREATED).build();
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e);
		}

	}

	@PutMapping("agendar/sobrancelha/{idHorario}")
	public ResponseEntity<?> agendarSobrancelha(@PathVariable int idHorario,
			@RequestBody HorarioSobrancelha novoAgendamentoSobrancelha) {
		try {
			Usuario usuario = usuarioService.pegarUsuarioPorID(novoAgendamentoSobrancelha.getUsuario().getId());

			HorarioSobrancelha sobrancelha = horarioSobrancelhaService.pegarHorarioPorId(idHorario);
			sobrancelha.setUsuario(usuario);

			horarioSobrancelhaService.agendarSobrancelha(sobrancelha);
			return ResponseEntity.status(HttpStatus.CREATED).build();

		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e);
		}

	}

	@PutMapping("agendar/cabelo/{idHorario}")
	public ResponseEntity<?> agendarCabelo(@PathVariable int idHorario,
			@RequestBody HorarioCabelo novoAgendamentoCabelo) {

		try {
			Usuario usuario = usuarioService.pegarUsuarioPorID(novoAgendamentoCabelo.getUsuario().getId());

			HorarioCabelo cabelo = horarioCabeloService.pegarHorarioPorId(idHorario);
			cabelo.setUsuario(usuario);

			horarioCabeloService.agendarCabelo(cabelo);
			return ResponseEntity.status(HttpStatus.CREATED).build();

		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e);
		}

	}

	@GetMapping("horarios/barba/disponiveis")
	public ResponseEntity<?> horariosBarbaNuloPorDia(@RequestParam(required = false) int dia,
			@RequestParam(required = false) String mes) {
		try {
			return ResponseEntity.ok().body(horarioBarbaService.horariosBarbaNuloPorDia(dia, mes));
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e);
		}

	}

	@GetMapping("horarios/cabelo/disponiveis")
	public ResponseEntity<?> horariosCabeloNuloPorDia(@RequestParam(required = false) int dia,
			@RequestParam(required = false) String mes) {
		try {
			return ResponseEntity.ok().body(horarioCabeloService.horariosCabeloNuloPorDia(dia, mes));
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e);
		}

	}

	@GetMapping("horarios/pezinho/disponiveis")
	public ResponseEntity<?> horariosPezinhoNuloPorDia(@RequestParam(required = false) int dia,
			@RequestParam(required = false) String mes) {
		try {
			return ResponseEntity.ok().body(horarioCabeloService.horariosCabeloNuloPorDia(dia, mes));
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e);
		}

	}

	@GetMapping("horarios/sobrancelha/disponiveis")
	public ResponseEntity<?> horariosSobrancelhaNuloPorDia(@RequestParam(required = false) int dia,
			@RequestParam(required = false) String mes) {
		try {
			return ResponseEntity.ok().body(horarioCabeloService.horariosCabeloNuloPorDia(dia,mes));
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e);
		}
	}
	
	
	@GetMapping("horarios/pezinho/agendados")
	public ResponseEntity<?> horariosPezinhoAgendadosPorDia(@PathVariable int dia, @PathVariable String mes){
		try {
			return ResponseEntity.ok().body(horarioPezinhoService.horariosAgendadosPorDia(dia, mes));
		}
		 catch (Exception e) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e);		
		}
	}

}
