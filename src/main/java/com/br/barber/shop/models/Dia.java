package com.br.barber.shop.models;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotBlank;

@Entity
public class Dia implements Serializable{
	private static final long serilVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@NotBlank(message = "campo Numero é obrigatorio ")
	private int numero;
	
	@ManyToOne(cascade = {CascadeType.ALL})
	private Mes mes;
	
	
	@OneToMany(mappedBy = "dia")
	private List<HorarioCabelo> cabelos;
	
	
	@OneToMany(mappedBy = "dia")
	private List<HorarioBarba> barba;
	
	
	@OneToMany(mappedBy = "dia")
	private List<HorarioPezinho> pezinho;
	
	
	@OneToMany(mappedBy = "dia")
	private List<HorarioSobrancelha> sobrancelha;


	public Dia() {
		
	}


	public Integer getId() {
		return id;
	}


	public void setId(Integer id) {
		this.id = id;
	}


	public int getNumero() {
		return numero;
	}


	public void setNumero(int numero) {
		this.numero = numero;
	}


	public Mes getMes() {
		return mes;
	}


	public void setMes(Mes mes) {
		this.mes = mes;
	}


	public List<HorarioCabelo> getCabelos() {
		return cabelos;
	}


	public void setCabelos(List<HorarioCabelo> cabelos) {
		this.cabelos = cabelos;
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


	public List<HorarioSobrancelha> getSobrancelha() {
		return sobrancelha;
	}


	public void setSobrancelha(List<HorarioSobrancelha> sobrancelha) {
		this.sobrancelha = sobrancelha;
	}
	
	
	

}
