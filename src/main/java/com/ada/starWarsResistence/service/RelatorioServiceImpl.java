package com.ada.starWarsResistence.service;

import com.ada.starWarsResistence.model.Relatorio;
import com.ada.starWarsResistence.repository.RebeldeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RelatorioServiceImpl {

	@Autowired
	private RebeldeRepository rebeldeRepository;

	public Relatorio getRelatorio() {
		Relatorio relatorio = new Relatorio();
		relatorio.setPorcentagemTraidores(calcularPorcentagemTraidores());
		relatorio.setPorcentagemRebeldes(calcularPorcentagemRebeldes());
		return relatorio;
	}

	public double calcularPorcentagemTraidores() {
		double result = ((double) rebeldeRepository.totalTraidores(true) / 100) * rebeldeRepository.totalRebeldes();
		return result;
	}

	public double calcularPorcentagemRebeldes() {
		double result = ((double) rebeldeRepository.totalTraidores(false) / 100) * rebeldeRepository.totalRebeldes();
		return result;
	}
}
