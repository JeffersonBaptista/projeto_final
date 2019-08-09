package com.br.barber.shop.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.br.barber.shop.models.Login;
import com.br.barber.shop.services.LoginService;
import com.br.barber.shop.services.UsuarioService;

@RestController
@RequestMapping("/api/zup/barber/shop/")
public class Controller {

	@Autowired
	private LoginService loginService;
	
	@Autowired 
	private UsuarioService usuarioService;

	@GetMapping("exibir/logins")
	public ResponseEntity<?> exibirLogins() {
		return ResponseEntity.ok(loginService.exibirTodosLogin());
	}

	@PostMapping("login")
	public ResponseEntity<?> criarLogin(@RequestBody Login login) {
		loginService.salvarLogin(login);
		return ResponseEntity.status(HttpStatus.CREATED).body(login);
	}
	
	@GetMapping("buscar/usuario/{id}")
	public ResponseEntity<?> buscarUsuarioPorId(@PathVariable int id){
	 try {
		 return ResponseEntity.ok().body(usuarioService.pegarUsuarioPorID(id));
	 }
	 catch (Exception e) {
		return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e);
	 }
	}

}
