package br.com.as.chamada.model.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.as.chamada.exceptions.NullInputException;
import br.com.as.chamada.exceptions.ResourceNotFoundException;
import br.com.as.chamada.model.entities.TurmaDisciplinaModel;
import br.com.as.chamada.model.repositories.TurmaDisciplinaRepository;

@Service
public class TurmaDisciplinaService {

	@Autowired
	private TurmaDisciplinaRepository turmaDisciplinaRepository;

	public List<TurmaDisciplinaModel> buscarTodos() {
		return turmaDisciplinaRepository.findAll();
	}

	public TurmaDisciplinaModel salvar(TurmaDisciplinaModel td) {
		if (td.getDisciplinaNome() == null || td.getTurmaNome() == null || td.getProfessor() == null) {
			throw new NullInputException(
					"Não pode haver campos nulos! DISCIPLINA: " + (td.getDisciplinaNome() != null ? "ok" : "Campo nulo")
							+ " TURMA NOME: " + (td.getTurmaNome() != null ? "ok" : "Campo nulo")
							+ " PROFESSOR "+ (td.getProfessor() != null ? "ok" : "Campo nulo"));
		}
		return turmaDisciplinaRepository.save(td);
	}

	public void deletar(Long id) {
		var result = turmaDisciplinaRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Id não encontrado! id:" + id));
		turmaDisciplinaRepository.delete(result);
	}
}
