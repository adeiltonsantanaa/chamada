package br.com.as.chamada.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.as.chamada.model.entities.TurmaDisciplinaModel;
import br.com.as.chamada.model.services.TurmaDisciplinaService;

@RestController
@RequestMapping(value = "api/v1/chamada")
public class ChamadaController {
	
	@Autowired
	private TurmaDisciplinaService turmaDisciplinaService;
	
	@GetMapping(value = "/check")
	public String check() {
		return "check ok";
	}
	@GetMapping(value = "/api/v1/chamada")
	public List<TurmaDisciplinaModel> buscarTurmas() {
		return turmaDisciplinaService.buscarTodos();
	}

}
