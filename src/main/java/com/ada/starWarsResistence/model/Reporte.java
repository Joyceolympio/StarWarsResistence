package com.ada.starWarsResistence.model;

import jakarta.persistence.*;
import lombok.Data;

import java.io.Serializable;

@Data
@Entity
@Table(name = "TB_REPORTE")

@NamedQuery(name = "Reporte.qtdReporteRebelde", query = "SELECT COUNT(r.idAcusado) FROM Reporte r WHERE r.idAcusado=?1")
public class Reporte implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	@Column(nullable = false)
	private Long idAcusado;
}