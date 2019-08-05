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


@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/api/zup/barber/shop/")
public class HorarioBarbaController {
	
	@Autowired
	HorarioBarbaService horarioBarbaService;
	
	
	@GetMapping()
	public ResponseEntity<?> exibirTodosHorariosBarba(){
		
		
		return ResponseEntity.ok().body(horarioBarbaService.exibirTodosHorariosBarba());
		
	}
	
	
	@PostMapping("{nomeMes}/{diasMes}")
	public ResponseEntity<?> gererHorarios(@PathVariable String nomeMes, @PathVariable int diasMes){

		try {
			horarioBarbaService.gerarHorariosBarba(nomeMes, diasMes);
			return ResponseEntity.status(HttpStatus.CREATED).build();
			
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e);
					
		}
	}
	
	

}
