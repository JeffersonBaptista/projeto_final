package com.br.barber.shop.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.br.barber.shop.services.HorarioBarbaService;
import com.br.barber.shop.services.HorarioCabeloService;
import com.br.barber.shop.services.HorarioPezinhoService;
import com.br.barber.shop.services.HorarioSobrancelhaService;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/api/zup/barber/shop/")
public class HorariosController {

	@Autowired
	HorarioBarbaService horarioBarbaService;

	@Autowired
	HorarioCabeloService horarioCabeloService;

	@Autowired
	HorarioPezinhoService horarioPezinhoService;

	@Autowired
	HorarioSobrancelhaService horarioSobrancelhaService;

	@GetMapping("todos/barba")
	public ResponseEntity<?> exibirTodosHorariosBarba() {

		return ResponseEntity.ok().body(horarioBarbaService.exibirTodosHorariosBarba());

	}
	@GetMapping("todos/cabelo")
	public ResponseEntity<?> exibirTodosHorariosCabelo() {

		return ResponseEntity.ok().body(horarioCabeloService.exibirTodoshorariosCabelos());

	}
	@GetMapping("todos/pezinho")
	public ResponseEntity<?> exibirTodosHorariosPesinho() {

		return ResponseEntity.ok().body(horarioPezinhoService.exibirTodoshorariosCabelos());

	}
	@GetMapping("todos/sobrancelha")
	public ResponseEntity<?> exibirTodosHorariosSobrancelha() {

		return ResponseEntity.ok().body(horarioSobrancelhaService.exibirTodosHorariosSobrancelha());

	}
	
	

	@PostMapping("{nomeMes}/{diasMes}")
	public ResponseEntity<?> gererHorarios(@PathVariable String nomeMes, @PathVariable int diasMes) {

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

}
