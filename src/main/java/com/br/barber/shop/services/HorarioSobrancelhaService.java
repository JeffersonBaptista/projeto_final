package com.br.barber.shop.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.br.barber.shop.models.HorarioPezinho;
import com.br.barber.shop.models.HorarioSobrancelha;
import com.br.barber.shop.repositories.HorarioSobrancelhaRepository;

@Service
public class HorarioSobrancelhaService {

	@Autowired
	HorarioSobrancelhaRepository horarioSobrancelhaRepository;

	public Iterable<HorarioSobrancelha> exibirTodosHorariosSobrancelha() {
		return horarioSobrancelhaRepository.findAll();
	}
	
	public long quantidadeHorarioSobrancelha() {
		return horarioSobrancelhaRepository.count();
	}
	public HorarioSobrancelha pegarHorarioPorId(int id) {
		 return horarioSobrancelhaRepository.findById(id).get();
	 }
	 
	 public void agendarSobrancelha(HorarioSobrancelha horarioSobrancelha) {
		 horarioSobrancelhaRepository.save(horarioSobrancelha);
	 }

	public void gerarHorariosSobrancelha(String nomeMes, int diasMes) {

		for (int i = 1; i <= diasMes; i++) {
			int hora = 8;
			for (int j = 1; j <= 8; j++) {

				HorarioSobrancelha sobrancelha = new HorarioSobrancelha();

				sobrancelha.setDia(i);
				sobrancelha.setMes(nomeMes);

				sobrancelha.setHorario((hora) + ":00 as " + (hora) + ":30");
				horarioSobrancelhaRepository.save(sobrancelha);

				HorarioSobrancelha sobrancelha1 = new HorarioSobrancelha();
				sobrancelha1.setDia(i);
				sobrancelha1.setMes(nomeMes);

				sobrancelha1.setHorario((hora) + ":30 as " + (hora + 1) + ":00");
				horarioSobrancelhaRepository.save(sobrancelha1);

				hora++;
			}

		}

	}
	
	public Iterable<HorarioSobrancelha> horariosSobrancelhaNuloPorDia( int dia, String mes){
		return horarioSobrancelhaRepository.findByDiaAndMesAndUsuarioIsNull(dia, mes);
		
	}
	public Iterable<HorarioSobrancelha> horariosAgendadosPorDia(int dia, String mes){
		return horarioSobrancelhaRepository.findByDiaAndMesAndUsuarioIsNotNull(dia, mes);
	}
	public void  excluirHorarioId(int id) {
		horarioSobrancelhaRepository.deleteById(id);
	}

}
