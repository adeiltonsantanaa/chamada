package br.com.as.chamada.model.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.as.chamada.exceptions.NullInputException;
import br.com.as.chamada.exceptions.ResourceNotFoundException;
import br.com.as.chamada.model.entities.AlunoModel;
import br.com.as.chamada.model.repositories.AlunoRepository;

@Service
public class AlunoService {

	@Autowired
	private AlunoRepository alunoRepository;

	public AlunoModel salvarAluno(AlunoModel aluno) {
		if (aluno.getMatricula() == null || aluno.getNome() == null) {
			throw new NullInputException(
					"Não pode haver campos nulos! MATRICULA: " + (aluno.getMatricula() != null ? "ok" : "Campo nulo")
						+ " NOME: " + (aluno.getNome() != null ? "ok" : "Campo nulo"));
		}

		return alunoRepository.save(aluno);
	}

	public List<AlunoModel> consultarAlunos() {
		return alunoRepository.findAll();
	}

	public void deletarAluno(Long id) {
		var result = alunoRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Id não encontrado! id: " + id));
		alunoRepository.delete(result);
	}
}
