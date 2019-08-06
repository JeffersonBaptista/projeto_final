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
	
	public void atualizar(Login login) {
		loginRepository.save(login);
	}
	
	public Login buscarPorApelidoESenha(Login login) {
		return loginRepository.findByApelidoAndSenha(login.getApelido(), login.getSenha()).get();
	}
	
	public Iterable<Login> exibirTodosLogin(){
		return loginRepository.findAll();
	}
	
	public void salvarLogin(Login login) {
		loginRepository.save(login);
	}
	
	public void deleteById(int id) {
		loginRepository.deleteById(id);
	}
	public long count() {
		return loginRepository.count();
	}
	
	public Iterable<Login> findAll(){
		return loginRepository.findAll();
	}
}
