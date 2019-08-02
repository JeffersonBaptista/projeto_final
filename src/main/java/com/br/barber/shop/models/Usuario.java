package com.br.barber.shop.models;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
@Entity
public class Usuario implements Serializable{
	private static final long serialVersionUID = 1L; 
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	@NotBlank(message = "Insira o nome .")
	private String nome;
	@NotBlank(message = "Insira o sobrenome.")
	private String sobrenome;
	@NotBlank(message = "Insira o telefone.")
	@Size(min = 15, max = 15, message = "Número Obrigatório no seguinte formato : (xx) xxxxx-xxxx." )
	private String telefone;
	
	@OneToOne(mappedBy = "usuario")
	private Login login;
	
	@OneToOne(mappedBy = "usuario")
	private HorarioBarba barba;
	 
	@OneToOne(mappedBy = "usuario")
	private HorarioPezinho pezinho;
	
	@OneToOne(mappedBy = "usuario")
	private HorarioCabelo cabelo;
	
	@OneToOne(mappedBy = "usuario")
	private HorarioSobrancelha sobrancelha;
	
	
	public Usuario() {
		
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getSobrenome() {
		return sobrenome;
	}

	public void setSobrenome(String sobrenome) {
		this.sobrenome = sobrenome;
	}

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	public Login getLogin() {
		return login;
	}

	public void setLogin(Login login) {
		this.login = login;
	}

	public HorarioBarba getBarba() {
		return barba;
	}

	public void setBarba(HorarioBarba barba) {
		this.barba = barba;
	}

	public HorarioPezinho getPezinho() {
		return pezinho;
	}

	public void setPezinho(HorarioPezinho pezinho) {
		this.pezinho = pezinho;
	}

	public HorarioCabelo getCabelo() {
		return cabelo;
	}

	public void setCabelo(HorarioCabelo cabelo) {
		this.cabelo = cabelo;
	}

	public HorarioSobrancelha getSobrancelha() {
		return sobrancelha;
	}

	public void setSobrancelha(HorarioSobrancelha sobrancelha) {
		this.sobrancelha = sobrancelha;
	}
	
	

}
