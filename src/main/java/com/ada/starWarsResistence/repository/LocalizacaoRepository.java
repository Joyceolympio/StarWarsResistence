package com.ada.starWarsResistence.repository;

import com.ada.starWarsResistence.model.Localizacao;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;

public interface LocalizacaoRepository extends JpaRepository<Localizacao, Long>{

	@Transactional
	@Modifying
	void update(String lat, String lon, String gal, Long id);
}
