package br.com.as.chamada.model.services;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.as.chamada.exceptions.NullInputException;
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
		validaEntradas(vo);
		var disciplina = disciplinaRepository.getReferenceById(vo.getProfessor());
		var professor = professorRepository.getReferenceById(vo.getDiscModel());
		RegistroAulaModel reg = RegistroAulaModel.parseToRegistroAulaModel(vo, professor, disciplina);
		registroAulaRepository.save(reg);
		return RegistroAulaResponseVO.parseToVO(reg);
	}

	public List<RegistroAulaResponseVO> buscarRegistros() {
		List<RegistroAulaModel> reg = registroAulaRepository.findAll();
		return reg.stream().map(r -> RegistroAulaResponseVO.parseToVO(r)).collect(Collectors.toList());
	}

	private boolean validaEntradas(RegistroAulaRequestVO vo) {
		if (vo.getDataRegistro() == null || vo.getDescricao() == null || vo.getDiscModel() == null
				|| vo.getProfessor() == null) {
			throw new NullInputException("Verifique todos os campos. Não é permitido a inserção de campos nulos!");
		}
		return true;
	}
}
