package com.ada.starWarsResistence.service;

import com.ada.starWarsResistence.model.Item;
import com.ada.starWarsResistence.model.Rebelde;
import com.ada.starWarsResistence.model.Negociacao;

import java.util.List;

public interface RebeldeService {

	void save(Rebelde rebelde);

	Rebelde findById(long id);

	void realizarNegociacao(Negociacao ofertante, Negociacao receptor);

	List<Item> validarItens(List<Item> ofertante, List<Item> oferta);

	boolean validarPontos(List<Item> ofertante, List<Item> receptor);

	List<Item> adicionarItens(List<Item> ofertante, List<Item> oferta);

	List<Item> removerItens(List<Item> ofertante, List<Item> oferta);

	List<Rebelde> findAll();
}