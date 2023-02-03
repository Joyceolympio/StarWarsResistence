package com.ada.starWarsResistence.controller;

import com.ada.starWarsResistence.model.Relatorio;
import com.ada.starWarsResistence.service.RelatorioServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/relatorio")
public class RelatorioController {

	@Autowired(required = true)
	private RelatorioServiceImpl relatorioService;

	@GetMapping
	public Relatorio showRelatorio() {
		return relatorioService.getRelatorio();
	}
}
