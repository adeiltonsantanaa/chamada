package br.com.as.chamada.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import br.com.as.chamada.model.entities.AlunoModel;
import br.com.as.chamada.model.services.AlunoService;
import br.com.as.chamada.model.vo.AlunoVO;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping(value = "api/v1/aluno")
public class AlunoController {

	@Autowired
	private AlunoService alunoService;

	@PostMapping
	@ResponseStatus(code = HttpStatus.OK)
	public AlunoVO salvar(@RequestBody AlunoModel aluno) {
		return alunoService.salvaAluno(aluno);
	}

}
