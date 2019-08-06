package com.br.barber.shop.models;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.junit4.SpringRunner;

import com.br.barber.shop.models.Login;

@RunWith(SpringRunner.class)
public class LoginTeste {
	
	private Login login;
	
	@Before
	public void preparar() {
		login = new Login();
		
		login.setId(null);
		login.setApelido("Jhol");
		login.setSenha("12345678");
		
	}
	
	@Test
	public void testarCriacaoLogin() {
		assertEquals("Jhol", login.getApelido());
		assertEquals("12345678", login.getSenha());
	}
	
	
}
