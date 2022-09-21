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

import br.com.as.chamada.model.entities.TurmaDisciplinaModel;
import br.com.as.chamada.model.services.TurmaDisciplinaService;

@RestController
@RequestMapping(value = "/api/v1/turmaDisc")
public class TurmaDisciplinaController {

	
	@Autowired
	private TurmaDisciplinaService turmaDisciplinaService;

	@GetMapping(value = "/buscar", produces = MediaType.APPLICATION_JSON_VALUE)
	public List<TurmaDisciplinaModel> buscarTodos() {
		return turmaDisciplinaService.buscarTodos();
	}

	@PostMapping(value = "/salvar", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
	public TurmaDisciplinaModel salvar(@RequestBody TurmaDisciplinaModel td) {
		return turmaDisciplinaService.salvar(td);
	}

	@DeleteMapping(value = "/deletar/{id}")
	private ResponseEntity<?> deletar(@PathVariable(value = "id") Long id) {
		turmaDisciplinaService.deletar(id);
		return ResponseEntity.noContent().build();
	}
}
