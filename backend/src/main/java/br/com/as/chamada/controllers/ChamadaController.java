package br.com.as.chamada.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "api/v1/chamada")
public class ChamadaController {
	
	@GetMapping(value = "/check")
	public String check() {
		return "check ok";
	}

}
