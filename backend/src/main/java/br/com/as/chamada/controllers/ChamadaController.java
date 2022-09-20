package br.com.as.chamada.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.as.chamada.model.entities.TurmaDisciplinaModel;
import br.com.as.chamada.model.services.ProfessorService;
import br.com.as.chamada.model.services.TurmaDiscService;

@RestController
@RequestMapping(value = "api/v1/chamada")
public class ChamadaController {
	
	@Autowired
	private ProfessorService pService;
	@Autowired
	private TurmaDiscService tService;
	
	@GetMapping(value = "/check")
	public void check() {
		pService.salvarNoBanco();
	}

	@GetMapping(value = "/check2")
	public void check2() {
		tService.SalvarNoBanco();
	}
}
