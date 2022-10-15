package br.com.as.chamada.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.as.chamada.model.dto.ChamadaDTO;
import br.com.as.chamada.model.entities.ChamadaModel;
import br.com.as.chamada.model.entities.DisciplinaModel;
import br.com.as.chamada.model.services.ChamadaService;

@RestController
@RequestMapping(value = "api/v1/chamada")
public class ChamadaController {

	@Autowired
	private ChamadaService chamadaService;

	@GetMapping(value = "/check")
	@PreAuthorize("hasAnyRole('ADMINISTRADOR')")
	public String check() {
		return "check ok";
	}

	@PreAuthorize("hasAnyRole('ADMINISTRADOR', 'OPERADOR', 'CONSULTA')")
	@GetMapping(value = "/buscar/chamadas")
	public List<ChamadaModel> BuscarChamadas() {
		return chamadaService.buscarChamadas();
	}

	@GetMapping(value = "/buscar/turmas")
	public List<DisciplinaModel> BuscarTurmas() {
		return chamadaService.buscarTurmas();
	}

	@PostMapping(value = "/salvar", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
	public ChamadaDTO salvar(@RequestBody ChamadaDTO dto) {
		return chamadaService.adicionaUmRegistro(dto);
	}

}
