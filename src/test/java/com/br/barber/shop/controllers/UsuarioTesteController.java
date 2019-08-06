package com.br.barber.shop.controllers;

import static org.hamcrest.CoreMatchers.containsString;

import java.util.Arrays;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import static org.hamcrest.collection.IsCollectionWithSize.hasSize;
import static org.mockito.BDDMockito.given;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

import com.br.barber.shop.models.Usuario;
import com.br.barber.shop.services.UsuarioService;
import com.fasterxml.jackson.databind.ObjectMapper;


@RunWith(SpringRunner.class)
@WebMvcTest(Controller.class)
public class UsuarioTesteController {
	
	@Autowired
	private MockMvc mockMvc;
	
	@MockBean
	private UsuarioService usuarioService;
	
	private Usuario usuario;
	
	@Before
	public void preparar() {
		
			usuario = new Usuario();
			
			usuario.setId(1);
			usuario.setNome("Diego");
			usuario.setSobrenome("neris");
			usuario.setTelefone("(11) 95555-5555");
	}
		@Test
		public void testarPegarUsuarios() throws Exception{
			List<Usuario> usuarios = Arrays.asList(usuario);
			
			given(usuarioService.findAll()).willReturn(usuarios);
			given(usuarioService.count()).willReturn(1L);
			
			this.mockMvc.perform(get("/api/login")).andExpect(status().isOk())
													.andExpect(jsonPath("$", hasSize(1)))
													.andExpect(jsonPath("$[*].id").isNotEmpty());
			
		}
		
}
