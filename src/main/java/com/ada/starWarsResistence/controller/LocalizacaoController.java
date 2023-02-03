package com.ada.starWarsResistence.controller;

import com.ada.starWarsResistence.model.Localizacao;
import com.ada.starWarsResistence.service.LocalizacaoServiceImpl;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/localizacao")
public class LocalizacaoController {

	@Autowired
	private LocalizacaoServiceImpl localizacaoService;

	@PutMapping("/reportar/{id}")
	public void reportarLocalizacao(@Valid @RequestBody Localizacao localizacao, @PathVariable("id") Long id) {
		localizacaoService.update(localizacao, id);
	}

}
