package br.com.as.chamada.model.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.as.chamada.model.entities.AlunoModel;
import br.com.as.chamada.model.repositories.AlunoRepository;
import br.com.as.chamada.model.vo.AlunoVO;

@Service
public class AlunoService {

	@Autowired
	private AlunoRepository alunoRepository;

	public AlunoVO salvaAluno(AlunoModel aluno) {
		alunoRepository.save(aluno);
		return AlunoVO.parseToVO(aluno);
	}

}
