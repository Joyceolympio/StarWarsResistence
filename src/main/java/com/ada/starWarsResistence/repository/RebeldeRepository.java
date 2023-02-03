package com.ada.starWarsResistence.repository;


import com.ada.starWarsResistence.model.Rebelde;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface RebeldeRepository extends JpaRepository<Rebelde, Long> {

	Rebelde findById(long id);

	List<Rebelde> findAll();

	@Transactional(readOnly = false)
	@Modifying
	void confirmarTraicao(long idRebelde);

	@Transactional(readOnly = true)
	int totalTraidores(boolean situacao);

	@Transactional(readOnly = true)
	int totalRebeldes();
}
