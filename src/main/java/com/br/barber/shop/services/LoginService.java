package com.br.barber.shop.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.br.barber.shop.models.Login;
import com.br.barber.shop.models.Usuario;
import com.br.barber.shop.repositories.LoginRepository;

@Service
public class LoginService {
	@Autowired
	private LoginRepository loginRepository;
	
	private String cadastrarLogin(Usuario user, Login login ) {
		login.setUsuario(user);
		loginRepository.save(login);
		return "Login cadastrado";
	}

}
