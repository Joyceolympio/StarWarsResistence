package com.ada.starWarsResistence.service;

import com.ada.starWarsResistence.model.Reporte;
import com.ada.starWarsResistence.repository.RebeldeRepository;
import com.ada.starWarsResistence.repository.ReporteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ReporteServiceImpl implements ReporteService {

	@Autowired
	private ReporteRepository reporteRepository;

	@Autowired
	private RebeldeRepository rebeldeRepository;

	@Override
	public void save(Reporte reporte) {
		if (qtdReporteRebelde(reporte.getIdAcusado()) >= 2) {
			confirmarTraicao(reporte.getIdAcusado());
			reporteRepository.save(reporte);
		} else {
			reporteRepository.save(reporte);
		}
	}
	@Override
	public void confirmarTraicao(long idRebelde) {
		rebeldeRepository.confirmarTraicao(idRebelde);
	}

	@Override
	public long qtdReporteRebelde(long idRebelde) {
		return reporteRepository.qtdReporteRebelde(idRebelde);
	}
}
