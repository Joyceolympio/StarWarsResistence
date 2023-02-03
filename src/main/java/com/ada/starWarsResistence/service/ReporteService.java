package com.ada.starWarsResistence.service;

import com.ada.starWarsResistence.model.Reporte;

public interface ReporteService {

	void save(Reporte reporte);

	void confirmarTraicao(long idRebelde);

	long qtdReporteRebelde(long idRebelde);

}
