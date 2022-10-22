package br.com.as.chamada.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.as.chamada.model.entities.AlunoModel;
import br.com.as.chamada.model.repositories.AlunoRepository;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping(value = "api/v1/aluno")
public class AlunoController {

	@Autowired
	private AlunoRepository alunoRepository;

	@PostMapping
	public AlunoModel salvar(@RequestBody AlunoModel aluno) {
		return alunoRepository.save(aluno);
	}

}
