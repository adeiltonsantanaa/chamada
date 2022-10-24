package br.com.as.chamada.model.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.ResponseStatus;

import br.com.as.chamada.exceptions.NullInputException;
import br.com.as.chamada.model.entities.AlunoModel;
import br.com.as.chamada.model.repositories.AlunoRepository;
import br.com.as.chamada.model.vo.AlunoVO;

@Service
public class AlunoService {

	@Autowired
	private AlunoRepository alunoRepository;

	@ResponseStatus(code = HttpStatus.OK)
	public AlunoVO salvaAluno(AlunoModel aluno) {
		validaEntradas(aluno);
		alunoRepository.save(aluno);
		return AlunoVO.parseToVO(aluno);
	}

	private boolean validaEntradas(AlunoModel aluno) throws NullInputException {
		if (aluno.getMatricula() == null) {
			throw new NullInputException("A matrícula do aluno não pode ser nula!");
		} else if (aluno.getNome() == null) {
			throw new NullInputException("O nome do aluno não pode ser nulo!");
		}
		return true;
	}

}
