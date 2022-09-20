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

import br.com.as.chamada.model.entities.ProfessorModel;
import br.com.as.chamada.model.services.ProfessorService;

@RestController
@RequestMapping(value = "/api/v1/professor")
public class ProfessorController {

	@Autowired
	private ProfessorService professorService;

	@GetMapping(value = "/buscar")
	public List<ProfessorModel> buscarTodos() {
		return professorService.buscarTodos();
	}

	@PostMapping(value = "/salvar", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
	public ProfessorModel salvar(@RequestBody ProfessorModel professor) {
		return professorService.salvar(professor);
	}

	@DeleteMapping(value = "/deletar/{id}")
	private ResponseEntity<?> deletar(@PathVariable(value = "id") Long id) {
		professorService.deletar(id);
		return ResponseEntity.noContent().build();
	}

}
