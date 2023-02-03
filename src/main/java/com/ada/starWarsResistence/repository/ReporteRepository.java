package com.ada.starWarsResistence.repository;

import com.ada.starWarsResistence.model.Reporte;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ReporteRepository extends JpaRepository<Reporte, Long>{

	long qtdReporteRebelde(long idRebelde);
}
