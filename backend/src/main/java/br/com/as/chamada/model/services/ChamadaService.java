package br.com.as.chamada.model.services;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.as.chamada.exceptions.NullInputException;
import br.com.as.chamada.exceptions.ResourceNotFoundException;
import br.com.as.chamada.mapper.DozerMapper;
import br.com.as.chamada.model.entities.ChamadaModel;
import br.com.as.chamada.model.entities.DisciplinaModel;
import br.com.as.chamada.model.repositories.AlunoRepository;
import br.com.as.chamada.model.repositories.ChamadaRepository;
import br.com.as.chamada.model.repositories.DisciplinaRepository;
import br.com.as.chamada.model.vo.ChamadaVO;
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
		List<DisciplinaVO> vo = DozerMapper.parseListObjects(disciplinaRepository.findAll(), DisciplinaVO.class);
		return vo;
	}

	public ChamadaVO adicionaUmRegistro(ChamadaVO vo) {
		if (vo.getMatricula() == null || vo.getDisciplina() == null) {
			if (vo.getMatricula() == null) {
				throw new NullInputException("Matrícula não pode ser nula!");
			}
			throw new NullInputException("Disciplina não pode ser nula");
		}
		if (verificaMatricula(vo.getMatricula())) {
			DisciplinaModel disciplina = disciplinaRepository.getReferenceById(vo.getDisciplina());
			ChamadaModel obj = DozerMapper.parseObject(vo, ChamadaModel.class);
			obj.setDatetime(new Date());
			obj.setDiscModel(disciplina);
			chamadaRepository.save(obj);
			ChamadaVO result = DozerMapper.parseObject(obj, ChamadaVO.class);
			result.setDisciplinaNome(disciplina.getDisciplinaNome());
			return result;
		}
		throw new ResourceNotFoundException("Matrícula não encontrada");
	}

	private boolean verificaMatricula(Long matricula) {
		if (alunoRepository.buscaPorMatricula((Long) matricula) == null) {
			return false;
		}
		return true;
	}

}
