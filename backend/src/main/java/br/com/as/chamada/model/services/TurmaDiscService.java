package br.com.as.chamada.model.services;

import org.springframework.stereotype.Service;

import br.com.as.chamada.model.entities.ProfessorModel;
import br.com.as.chamada.model.entities.TurmaDisciplinaModel;
import br.com.as.chamada.model.repositories.TurmaDisciplinaRepository;

import org.springframework.beans.factory.annotation.Autowired;

@Service
public class TurmaDiscService {
	
	@Autowired
	private TurmaDisciplinaRepository tRepository;
	
	
	public void SalvarNoBanco() {
		TurmaDisciplinaModel t1 = new TurmaDisciplinaModel();
		ProfessorModel p1 = new ProfessorModel();
		p1.setId((long) 1);
		t1.setDisciplinaNome("nomeDisc");
		t1.setTurmaNome("nomeTurma");
		t1.setProfessor(p1);
		tRepository.save(t1);
	}
	
}
