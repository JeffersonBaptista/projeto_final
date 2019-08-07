package com.br.barber.shop.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.br.barber.shop.models.Usuario;
import com.br.barber.shop.repositories.UsuarioRepository;

@Service
public class UsuarioService {
	
	@Autowired
	private UsuarioRepository usuarioRepository;
	
	public Iterable<Usuario> findAll(){
		return usuarioRepository.findAll();
	}
		
	public Usuario save(Usuario usuario) {
		return usuarioRepository.save(usuario);
	}
		
	public void deleteById(int id) {
		usuarioRepository.deleteById(id);
	}
	
	public long count() {
		return usuarioRepository.count();
	}
	
	public Usuario pegarUsuarioPorID(int id) {
		return usuarioRepository.findById(id).get();
	}
	
}
