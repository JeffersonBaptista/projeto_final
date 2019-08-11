package com.br.barber.shop.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.br.barber.shop.models.HorarioBarba;
import com.br.barber.shop.models.HorarioCabelo;
import com.br.barber.shop.models.HorarioPezinho;
import com.br.barber.shop.models.Usuario;
import com.br.barber.shop.repositories.HorarioPezinhoRepository;

@Service
public class HorarioPezinhoService {

	@Autowired
	HorarioPezinhoRepository horarioPezinhoRepository;

	public Iterable<HorarioPezinho> exibirTodoshorariosPezinho() {
		return horarioPezinhoRepository.findAll();
	}
	public long quantidadeHorarioPezinho() {
		return horarioPezinhoRepository.count();
	}
	
	 public HorarioPezinho pegarHorarioPorId(int id) {
		 return horarioPezinhoRepository.findById(id).get();
	 }
	 
	 public void agendarPezinho(HorarioPezinho horarioPezinho) {
		 horarioPezinhoRepository.save(horarioPezinho);
	 }
	 

	public void gerarHorariosPezinho(String nomeMes, int diasMes) {

		for (int i = 1; i <= diasMes; i++) {
			int hora = 8;
			for (int j = 1; j <= 8; j++) {

				HorarioPezinho pezinho = new HorarioPezinho();
				pezinho.setDia(i);
				pezinho.setMes(nomeMes);

				pezinho.setHorario((hora) + ":00 as " + (hora) + ":30");
				horarioPezinhoRepository.save(pezinho);

				HorarioPezinho pezinho1 = new HorarioPezinho();
				pezinho1.setDia(i);
				pezinho1.setMes(nomeMes);

				pezinho1.setHorario((hora) + ":30 as " + (hora + 1) + ":00");
				horarioPezinhoRepository.save(pezinho1);

				hora++;
			}

		}
		

	}
	
	public Iterable<HorarioPezinho> horariosPezinhoNuloPorDia( int dia, String mes){
		return horarioPezinhoRepository.findByDiaAndMesAndUsuarioIsNull(dia, mes);
		
	}

	public Iterable<HorarioPezinho> horariosAgendadosPorDia(int dia, String mes){
		return horarioPezinhoRepository.findByDiaAndMesAndUsuarioIsNotNull(dia, mes);
	}
	public void  excluirHorarioId(int id) {
		horarioPezinhoRepository.deleteById(id);
	}
	
}
