package br.com.as.chamada.model.services;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.as.chamada.exceptions.NullInputException;
import br.com.as.chamada.exceptions.ResourceNotFoundException;
import br.com.as.chamada.model.entities.ChamadaModel;
import br.com.as.chamada.model.entities.DisciplinaModel;
import br.com.as.chamada.model.repositories.AlunoRepository;
import br.com.as.chamada.model.repositories.ChamadaRepository;
import br.com.as.chamada.model.repositories.DisciplinaRepository;
import br.com.as.chamada.model.vo.ChamadaRequestVO;
import br.com.as.chamada.model.vo.ChamadaResponseVO;
import br.com.as.chamada.model.vo.DisciplinaVO;

@Service
public class ChamadaService {

	@Autowired
	private ChamadaRepository chamadaRepository;
	@Autowired
	private DisciplinaRepository disciplinaRepository;
	@Autowired
	private AlunoRepository alunoRepository;

	public List<ChamadaModel> buscarChamadas() {
		return chamadaRepository.findAll();
	}

	public List<DisciplinaVO> buscarTurmas() {
		List<DisciplinaModel> vo = disciplinaRepository.findAll();
		return vo.stream().map(v -> DisciplinaVO.parseToVO(v)).collect(Collectors.toList());
	}

 	public ChamadaResponseVO adicionaUmRegistro(ChamadaRequestVO vo) {
		verificaEntradas(vo);
		verificaSeAlunoEstaNaBase(vo.getMatricula());
		DisciplinaModel disciplina = disciplinaRepository.getReferenceById(vo.getDisciplina());
		ChamadaModel obj = ChamadaModel.parseToChamadaModel(vo, disciplina);
		chamadaRepository.save(obj);
		return ChamadaResponseVO.parseToVO(obj);
	}

	private boolean verificaSeAlunoEstaNaBase(Long matricula) throws ResourceNotFoundException {
		if (alunoRepository.buscaPorMatricula((Long) matricula) == null) {
			throw new ResourceNotFoundException(
					"Matrícula " + matricula + " não encontrado no banco, tente novamente com a matrícula correta!");
		}
		return true;
	}

	private Boolean verificaEntradas(ChamadaRequestVO vo) throws NullInputException {
		if (vo.getMatricula() == null || vo.getDisciplina() == null) {
			if (vo.getMatricula() == null) {
				throw new NullInputException("Matrícula não pode ser nula!");
			}
			throw new NullInputException("Disciplina não pode ser nula");
		}
		return true;
	}

}
