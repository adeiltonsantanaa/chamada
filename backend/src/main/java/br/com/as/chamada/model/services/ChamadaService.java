package br.com.as.chamada.model.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.as.chamada.model.entities.TurmaDisciplinaModel;
import br.com.as.chamada.model.repositories.TurmaDisciplinaRepository;

@Service
public class ChamadaService {

	@Autowired
	private TurmaDisciplinaRepository turmaDisciplinaRepository;
	
	
	public List<TurmaDisciplinaModel> buscarTurmas(){
		return turmaDisciplinaRepository.findAll();
	}
	
	
}
