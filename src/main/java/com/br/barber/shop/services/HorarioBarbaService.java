package com.br.barber.shop.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.br.barber.shop.models.HorarioBarba;

import com.br.barber.shop.repositories.HorarioBarbaRepositoty;

@Service
public class HorarioBarbaService {

	@Autowired
	HorarioBarbaRepositoty horarioBarbaRepositoty;

	public Iterable<HorarioBarba> exibirTodosHorariosBarba() {
		return horarioBarbaRepositoty.findAll();
	}

	public void gerarHorariosBarba(String nomeMes, int diasMes) {

		for (int i = 1; i <= diasMes; i++) {
			int hora = 8;
			for (int j = 1; j <= 8; j++) {

				HorarioBarba barba = new HorarioBarba();

				barba.setDia(i);
				barba.setMes(nomeMes);

				barba.setHorario((hora) + ":00 as " + (hora) + ":30");
				horarioBarbaRepositoty.save(barba);

				HorarioBarba barba1 = new HorarioBarba();
				barba1.setDia(i);
				barba1.setMes(nomeMes);

				barba1.setHorario((hora) + ":30 as " + (hora + 1)+":00");
				horarioBarbaRepositoty.save(barba1);

				hora++;
			}

		}

	}

}
