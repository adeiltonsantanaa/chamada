package br.com.as.chamada.model.services;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.as.chamada.model.dto.ChamadaDTO;
import br.com.as.chamada.model.entities.ChamadaModel;
import br.com.as.chamada.model.entities.DisciplinaModel;
import br.com.as.chamada.model.repositories.ChamadaRepository;
import br.com.as.chamada.model.repositories.DisciplinaRepository;

@Service
public class ChamadaService {

	@Autowired
	private ChamadaRepository chamadaRepository;
	@Autowired
	private DisciplinaRepository disciplinaRepository;

	public List<ChamadaModel> buscarTurmas() {
		return chamadaRepository.findAll();
	}

	public ChamadaDTO adicionaUmRegistro(ChamadaDTO dto, ChamadaModel chamada) {

		DisciplinaModel disciplina = disciplinaRepository.getById((long) 1);
		chamada.setDiscModel(disciplina);

		chamada.setDatetime(new Date());

		chamadaRepository.save(chamada);

		var result = dto.transformaParaDTO(chamada.getId(), disciplina.getId(), chamada.getDatetime(),
				disciplina.getProfessor().getId());

		return result;
	}

}
