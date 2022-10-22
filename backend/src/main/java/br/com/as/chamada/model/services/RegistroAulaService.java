package br.com.as.chamada.model.services;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.as.chamada.model.entities.RegistroAulaModel;
import br.com.as.chamada.model.repositories.DisciplinaRepository;
import br.com.as.chamada.model.repositories.ProfessorRepository;
import br.com.as.chamada.model.repositories.RegistroAulaRepository;
import br.com.as.chamada.model.vo.RegistroAulaRequestVO;
import br.com.as.chamada.model.vo.RegistroAulaResponseVO;

@Service
public class RegistroAulaService {

	@Autowired
	private RegistroAulaRepository registroAulaRepository;
	@Autowired
	private ProfessorRepository professorRepository;
	@Autowired
	private DisciplinaRepository disciplinaRepository;

	public RegistroAulaResponseVO salvaRegistro(RegistroAulaRequestVO vo) {
		var disciplina = disciplinaRepository.getReferenceById(vo.getProfessor());
		var professor = professorRepository.getReferenceById(vo.getDiscModel());
		RegistroAulaModel reg = new RegistroAulaModel(vo.getDescricao(), vo.getDataRegistro(), professor, disciplina);
		reg.setProfessor(professor);
		reg.setDiscModel(disciplina);
		registroAulaRepository.save(reg);
		return new RegistroAulaResponseVO(reg.getId(), reg.getDescricao(), reg.getDataRegistro(),
				reg.getProfessor().getNome(), reg.getDiscModel().getDisciplinaNome());
	}

	public List<RegistroAulaResponseVO> buscarRegistros() {
		List<RegistroAulaModel> reg = registroAulaRepository.findAll();
		return reg.stream().map(r -> new RegistroAulaResponseVO(r.getId(), r.getDescricao(), r.getDataRegistro(),
				r.getProfessor().getNome(), r.getDiscModel().getDisciplinaNome())).collect(Collectors.toList());
	}

}
