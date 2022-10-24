package br.com.as.chamada.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import br.com.as.chamada.model.entities.ChamadaModel;
import br.com.as.chamada.model.services.ChamadaService;
import br.com.as.chamada.model.vo.ChamadaRequestVO;
import br.com.as.chamada.model.vo.ChamadaResponseVO;
import br.com.as.chamada.model.vo.DisciplinaVO;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping(value = "api/v1/chamada")
public class ChamadaController {

	@Autowired
	private ChamadaService chamadaService;

	@GetMapping(value = "/check")
	@PreAuthorize("hasAnyRole('ADMINISTRADOR', 'OPERADOR', 'CONSULTA')")
	@ResponseStatus(code = HttpStatus.OK)
	public String check() {
		return "check ok";
	}

	@PreAuthorize("hasAnyRole('ADMINISTRADOR', 'OPERADOR', 'CONSULTA')")
	@GetMapping(value = "/buscar/chamadas", produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseStatus(code = HttpStatus.OK)
	public List<ChamadaModel> BuscarChamadas() {
		return chamadaService.buscarChamadas();
	}

	@GetMapping(value = "/buscar/turmas", produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseStatus(code = HttpStatus.OK)
	public List<DisciplinaVO> BuscarTurmas() {
		return chamadaService.buscarTurmas();
	}

	@PostMapping(value = "/salvar", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
	@ResponseStatus(code = HttpStatus.OK)
	public ChamadaResponseVO salvar(@RequestBody ChamadaRequestVO vo) {
		return chamadaService.adicionaUmRegistro(vo);
	}

}
