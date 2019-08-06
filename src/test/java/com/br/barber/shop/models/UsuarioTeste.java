package com.br.barber.shop.models;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
public class UsuarioTeste {

	private Usuario usuario;
	private Login login;
	@Before
	public void prepararUsuario() {
		usuario = new Usuario();
		login = new Login();
		
		login.setApelido("Sei la");
		
		
		usuario.setId(null);
		usuario.setNome("Jonatas");
		usuario.setSobrenome("oliveira");
		usuario.setTelefone("(11) 94444-4444");
		usuario.setLogin(login);
		usuario.setBarba(null);
		usuario.setPezinho(null);
		usuario.setCabelo(null);
		usuario.setSobrancelha(null);
	
	}
	@Test
	public void testarCriacaoUsuario() {
		assertEquals("Jonatas", usuario.getNome());
		assertEquals("oliveira", usuario.getSobrenome());
		assertEquals("(11) 94444-4444", usuario.getTelefone());
		assertEquals(login, usuario.getLogin());
		assertEquals(null, usuario.getBarba());
		assertEquals(null, usuario.getPezinho());
		assertEquals(null, usuario.getCabelo());
		assertEquals(null, usuario.getSobrancelha());
	}
	
}
