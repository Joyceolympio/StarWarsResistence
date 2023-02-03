package com.ada.starWarsResistence.service;

import com.ada.starWarsResistence.model.Localizacao;
import com.ada.starWarsResistence.repository.LocalizacaoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LocalizacaoServiceImpl implements LocalizacaoService {
	
	@Autowired
	private LocalizacaoRepository localizacaoRepository;
	
	@Override
	public void update(Localizacao localizacao , Long id) {
		localizacaoRepository.update(localizacao.getLatitude(), localizacao.getLongitude(), localizacao.getGalaxia(), id);
	}

}
