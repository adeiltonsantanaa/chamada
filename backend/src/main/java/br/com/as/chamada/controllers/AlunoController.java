package br.com.as.chamada.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.as.chamada.model.entities.AlunoModel;
import br.com.as.chamada.model.services.AlunoService;

@RestController
@RequestMapping(value = "/api/v1/aluno")
public class AlunoController {

	@Autowired
	private AlunoService alunoService;

	@GetMapping(value = "/buscar")
	public List<AlunoModel> buscarTodos() {
		return alunoService.consultarAlunos();
	}

	@PostMapping(value = "/salvar", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
	public AlunoModel salvar(@RequestBody AlunoModel aluno) {
		return alunoService.salvarAluno(aluno);
	}
	
	@DeleteMapping(value = "/deletar/{id}")
	public ResponseEntity<?> deletarAluno(@PathVariable(value = "id") Long id){
		alunoService.deletarAluno(id);
		return ResponseEntity.noContent().build();
	}

}
