package br.com.as.chamada.model.services;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.as.chamada.exceptions.NullInputException;
import br.com.as.chamada.exceptions.ResourceNotFoundException;
import br.com.as.chamada.model.dto.ChamadaDTO;
import br.com.as.chamada.model.entities.ChamadaModel;
import br.com.as.chamada.model.entities.DisciplinaModel;
import br.com.as.chamada.model.repositories.AlunoRepository;
import br.com.as.chamada.model.repositories.ChamadaRepository;
import br.com.as.chamada.model.repositories.DisciplinaRepository;

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

	public List<DisciplinaModel> buscarTurmas() {
		return disciplinaRepository.findAll();
	}

	public ChamadaDTO adicionaUmRegistro(ChamadaDTO dto) {
		if (dto.getMatricula() == null || dto.getDisciplina() == null) {
			if (dto.getMatricula() == null) {
				throw new NullInputException("Matrícula não pode ser nula!");
			}
			throw new NullInputException("Disciplina não pode ser nula");
		}
		if (verificaMatricula(dto.getMatricula())) {
			DisciplinaModel disciplina = disciplinaRepository.getReferenceById(dto.getDisciplina());
			ChamadaModel obj = ChamadaDTO.transformaParaOBJ(dto.getMatricula(), disciplina, new Date());
			chamadaRepository.save(obj);
			ChamadaDTO result = ChamadaDTO.transformaParaDTO(obj.getId(), obj.getMatricula(), disciplina.getId(),
					obj.getDatetime(), disciplina.getProfessor().getNome());
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
