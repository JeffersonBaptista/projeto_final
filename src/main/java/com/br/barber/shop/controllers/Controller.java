package com.br.barber.shop.controllers;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.br.barber.shop.models.Login;
import com.br.barber.shop.services.LoginService;

@RestController
@RequestMapping("/api/login")
public class Controller {
	
	@Autowired
	private LoginService loginService;
	
	@GetMapping
	public ResponseEntity<?> exibirLogins(){
		return ResponseEntity.ok(loginService.exibirTodosLogin());
	}
	@PostMapping
	public ResponseEntity<?> criarLogin(@RequestBody Login login){
		loginService.salvarLogin(login);
		return ResponseEntity.status(HttpStatus.CREATED).body(login);
	}
	
}
