package com.ada.starWarsResistence.controller;

import com.ada.starWarsResistence.model.Rebelde;
import com.ada.starWarsResistence.model.Negociacao;
import com.ada.starWarsResistence.service.RebeldeServiceImpl;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/rebelde", produces = "application/json")
public class RebeldeController {

	@Autowired
	private RebeldeServiceImpl rebeldeService;

	@PostMapping
	public void save(@Valid @RequestBody Rebelde rebelde) {
		rebeldeService.save(rebelde);
	}

	@GetMapping
	public Rebelde getById(@RequestParam("id") long id) {
		return rebeldeService.findById(id);
	}

	@PostMapping("/negociacao")
	public void realizarNegociacao(@RequestBody Negociacao[] negociacao) {
		rebeldeService.realizarNegociacao(negociacao[0], negociacao[1]);
	}
	
	@GetMapping("/all")
	public List<Rebelde> getAll() {
		return rebeldeService.findAll();
	}
}
