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
import br.com.as.chamada.model.services.RegistroAulaService;
import br.com.as.chamada.model.vo.RegistroAulaRequestVO;
import br.com.as.chamada.model.vo.RegistroAulaResponseVO;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping(value = "api/v1/registro")
public class RegistrarAulaController {

	@Autowired
	private RegistroAulaService registroAulaService;

	@GetMapping(value = "/check")
	@PreAuthorize("hasAnyRole('ADMINISTRADOR')")
	@ResponseStatus(code = HttpStatus.OK)
	public String check() {
		return "check ok";
	}

	@PreAuthorize("hasAnyRole('ADMINISTRADOR', 'OPERADOR', 'CONSULTA')")
	@GetMapping(value = "/buscar/chamadas")
	@ResponseStatus(code = HttpStatus.OK)
	public List<ChamadaModel> BuscarChamadas() {
		return null;
	}

	@GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseStatus(code = HttpStatus.OK)
	public List<RegistroAulaResponseVO> BuscarTurmas() {
		return registroAulaService.buscarRegistros();
	}

	@PostMapping(produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
	@ResponseStatus(code = HttpStatus.OK)
	public RegistroAulaResponseVO salvar(@RequestBody RegistroAulaRequestVO vo) {
		return registroAulaService.salvaRegistro(vo);
	}

}
