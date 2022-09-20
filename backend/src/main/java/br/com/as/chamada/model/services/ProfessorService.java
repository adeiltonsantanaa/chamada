package br.com.as.chamada.model.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.as.chamada.model.entities.ProfessorModel;
import br.com.as.chamada.model.repositories.ProfessorRepository;

@Service
public class ProfessorService {
	
	
	@Autowired
	private ProfessorRepository pRepository;
	
	
	
	public void salvarNoBanco() {
		ProfessorModel p1 = new ProfessorModel();
		p1.setNome("pesssoa1");
		pRepository.save(p1);
	}

}
