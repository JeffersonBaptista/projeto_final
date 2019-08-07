package com.br.barber.shop.models;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
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
	@JsonIgnoreProperties("usuario")
	private Login login;
	
	@OneToMany(mappedBy = "usuario")
	private List<HorarioBarba> barba;
	 
	@OneToMany(mappedBy = "usuario")
	private List<HorarioPezinho> pezinho;
	
	@OneToMany(mappedBy = "usuario")
	private List<HorarioCabelo> cabelo;
	
	@OneToMany(mappedBy = "usuario")
	private List<HorarioSobrancelha> sobrancelha;
	
	
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

	public List<HorarioBarba> getBarba() {
		return barba;
	}

	public void setBarba(List<HorarioBarba> barba) {
		this.barba = barba;
	}

	public List<HorarioPezinho> getPezinho() {
		return pezinho;
	}

	public void setPezinho(List<HorarioPezinho> pezinho) {
		this.pezinho = pezinho;
	}

	public List<HorarioCabelo> getCabelo() {
		return cabelo;
	}

	public void setCabelo(List<HorarioCabelo> cabelo) {
		this.cabelo = cabelo;
	}

	public List<HorarioSobrancelha> getSobrancelha() {
		return sobrancelha;
	}

	public void setSobrancelha(List<HorarioSobrancelha> sobrancelha) {
		this.sobrancelha = sobrancelha;
	}


	
	

}
