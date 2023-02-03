package com.ada.starWarsResistence.service;

import com.ada.starWarsResistence.model.Item;
import com.ada.starWarsResistence.model.Rebelde;
import com.ada.starWarsResistence.model.Negociacao;
import com.ada.starWarsResistence.model.error.NullPointerException;
import com.ada.starWarsResistence.repository.RebeldeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;


@Service
public class RebeldeServiceImpl implements RebeldeService {

	@Autowired
	private RebeldeRepository rebeldeRepository;

	@Override
	public void save(Rebelde rebelde) {
		List<Item> itens = rebelde.getInventario().getItens();

		for (int i = 0; i < itens.size(); i++) {
			itens.get(i).adicionarPontos();
		}
		rebelde.getInventario().setItens(itens);

		rebeldeRepository.save(rebelde);
	}

	@Override
	public Rebelde findById(long id) {
		Rebelde rebelde = rebeldeRepository.findById(id);

		if (rebelde == null) {
			throw new NullPointerException("Rebelde não cadastrado!");
		} else if (rebelde.isTraidor()) {
			throw new NullPointerException("Rebelde traidor!");
		} else {
			return rebelde;
		}

	}

	@Override
	public void realizarNegociacao(Negociacao ofertante, Negociacao receptor) {

		Rebelde rebeldeOfertante = findById(ofertante.getIdRebelde());
		Rebelde rebeldeReceptor = findById(receptor.getIdRebelde());


		List<Item> itensNegociacaoOfertante = validarItens(rebeldeOfertante.getInventario().getItens(), ofertante.getItens());
		List<Item> itensNegociacaoReceptor = validarItens(rebeldeReceptor.getInventario().getItens(), receptor.getItens());


		if (itensNegociacaoOfertante.isEmpty() || itensNegociacaoReceptor.isEmpty()) {
			return;
		} else {

			if (!validarPontos(itensNegociacaoOfertante, itensNegociacaoReceptor)) {
				return;
			} else {

				rebeldeOfertante.getInventario()
						.setItens(adicionarItens(rebeldeOfertante.getInventario().getItens(), itensNegociacaoReceptor));

				rebeldeOfertante.getInventario()
						.setItens(removerItens(rebeldeOfertante.getInventario().getItens(), itensNegociacaoOfertante));


				rebeldeReceptor.getInventario()
						.setItens(adicionarItens(rebeldeReceptor.getInventario().getItens(), itensNegociacaoOfertante));

				rebeldeReceptor.getInventario()
						.setItens(removerItens(rebeldeReceptor.getInventario().getItens(), itensNegociacaoReceptor));

				rebeldeRepository.save(rebeldeOfertante);
				rebeldeRepository.save(rebeldeReceptor);
			}
		}
	}

	@Override
	public List<Item> validarItens(List<Item> ofertante, List<Item> oferta) {
		List<Item> itensProntos = new ArrayList<>();

		for (int i = 0; i < ofertante.size(); i++) {

			for (int j = 0; j < oferta.size(); j++) {

				String nome = ofertante.get(i).getNome();
				int qtd = ofertante.get(i).getQtd();

				if (oferta.get(j).getNome().equals(nome)) {
					if (oferta.get(j).getQtd() > qtd) {
						return itensProntos = new ArrayList<>();
					} else {
						Item item = oferta.get(j);
						item.setId(ofertante.get(i).getId());
						item.adicionarPontos();
						itensProntos.add(item);
					}
				} else {
					itensProntos.add(null);
				}
			}
		}

		itensProntos.removeIf(n -> (n == null));

		if (itensProntos.size() < oferta.size()) {
			return itensProntos = new ArrayList<>();
		}

		return itensProntos;
	}

	@Override
	public boolean validarPontos(List<Item> ofertante, List<Item> receptor) {

		int pontosOfertante = 0, pontosReceptor = 0;

		for (Item it : ofertante) {
			pontosOfertante += (it.getPontos() * it.getQtd());
		}
		for (Item it : receptor) {
			pontosReceptor += (it.getPontos() * it.getQtd());
		}

		if (pontosOfertante != pontosReceptor)
			return false;

		return true;
	}

	@Override
	public List<Item> adicionarItens(List<Item> ofertante, List<Item> oferta) {
		for (int i = 0; i < ofertante.size(); i++) {
			for (int j = 0; j < oferta.size(); j++) {
				if (ofertante.get(i).getNome().equals(oferta.get(j).getNome())) {
					ofertante.get(i).setQtd(ofertante.get(i).getQtd() + oferta.get(j).getQtd());
				}
			}
		}
		return ofertante;
	}

	@Override
	public List<Item> removerItens(List<Item> ofertante, List<Item> oferta) {
		for (int i = 0; i < ofertante.size(); i++) {
			for (int j = 0; j < oferta.size(); j++) {
				if (ofertante.get(i).getId() == oferta.get(j).getId()) {
					ofertante.get(i).setQtd(ofertante.get(i).getQtd() - oferta.get(j).getQtd());
				}
			}
		}
		return ofertante;
	}

	@Override
	public List<Rebelde> findAll() {
		return rebeldeRepository.findAll();
	}
}