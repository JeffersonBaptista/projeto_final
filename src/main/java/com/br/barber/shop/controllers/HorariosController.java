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

	@PostMapping("{nomeMes}/{diasMes}")
	public ResponseEntity<?> gerarHorarios(@PathVariable String nomeMes, @PathVariable int diasMes) {

		try {
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
		Usuario usuario = usuarioService.pegarUsuarioPorID(novoAgendamento.getUsuario().getId());

		HorarioBarba barba = horarioBarbaService.pegarHorarioBarbaPorId(idHorario);
		barba.setUsuario(usuario);

		horarioBarbaService.agendarBarba(barba);
		return ResponseEntity.status(HttpStatus.CREATED).build();
	}

	@GetMapping("horario/barba")
	public ResponseEntity<?> horariosBarbaNuloPorDia(@RequestParam(required = false) int dia) {
		return ResponseEntity.ok().body(horarioBarbaService.horariosBarbaNuloPorDia(dia));

	}
	
}
