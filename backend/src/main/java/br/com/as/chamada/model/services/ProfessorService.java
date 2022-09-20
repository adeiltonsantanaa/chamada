package br.com.as.chamada.model.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.as.chamada.exceptions.NullInputException;
import br.com.as.chamada.exceptions.ResourceNotFoundException;
import br.com.as.chamada.model.entities.ProfessorModel;
import br.com.as.chamada.model.repositories.ProfessorRepository;

@Service
public class ProfessorService {

	@Autowired
	private ProfessorRepository professorRepository;

	public List<ProfessorModel> buscarTodos() {
		return professorRepository.findAll();
	}

	public ProfessorModel salvar(ProfessorModel professor) {
		if(professor.getNome() == null) {
			throw new NullInputException("O campo nome não pode ser nulo!");
		}
		return professorRepository.save(professor);
	}

	public void deletar(Long id) {
		var result = professorRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Id não encontrado! id:" + id));
		professorRepository.delete(result);
	}
}
