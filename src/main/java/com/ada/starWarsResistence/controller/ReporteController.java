package com.ada.starWarsResistence.controller;

import com.ada.starWarsResistence.model.Reporte;
import com.ada.starWarsResistence.service.ReporteServiceImpl;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/reporte")
public class ReporteController {

	@Autowired
	private ReporteServiceImpl reporteService;

	@PostMapping
	public void save(@Valid @RequestBody Reporte reporte) {
		reporteService.save(reporte);
	}
}
