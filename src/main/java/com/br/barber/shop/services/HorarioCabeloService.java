package com.br.barber.shop.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.br.barber.shop.models.HorarioBarba;
import com.br.barber.shop.models.HorarioCabelo;
import com.br.barber.shop.models.HorarioPezinho;
import com.br.barber.shop.repositories.HorarioCabeloRepository;

@Service
public class HorarioCabeloService {

	@Autowired
	HorarioCabeloRepository horarioCabeloRepository;

	public Iterable<HorarioCabelo> exibirTodoshorariosCabelos() {
		return horarioCabeloRepository.findAll();
	}

	public long quantidadeHorarioCabelo() {
		return horarioCabeloRepository.count();
	}

	public HorarioCabelo pegarHorarioPorId(int id) {
		return horarioCabeloRepository.findById(id).get();
	}

	public void agendarCabelo(HorarioCabelo horarioCabelo) {
		horarioCabeloRepository.save(horarioCabelo);
	}

	public void gerarHorariosCabelo(String nomeMes, int diasMes) {

		for (int i = 1; i <= diasMes; i++) {
			int hora = 8;
			for (int j = 1; j <= 8; j++) {

				HorarioCabelo cabelo = new HorarioCabelo();

				cabelo.setDia(i);
				cabelo.setMes(nomeMes);

				cabelo.setHorario((hora) + " as " + (hora + 1));
				horarioCabeloRepository.save(cabelo);
				hora++;
			}

		}

	}

	public Iterable<HorarioCabelo> horariosCabeloNuloPorDia(int dia, String mes) {
		return horarioCabeloRepository.findByDiaAndMesAndUsuarioIsNull(dia, mes);

	}

	public Iterable<HorarioCabelo> horariosAgendadosPorDia(int dia, String mes) {
		return horarioCabeloRepository.findByDiaAndMesAndUsuarioIsNotNull(dia, mes);
	}

}
