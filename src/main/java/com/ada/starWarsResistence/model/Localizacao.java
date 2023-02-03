/**
 * 
 */
package com.ada.starWarsResistence.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import lombok.Data;

import java.io.Serializable;

/*
 * Entidade que representa localização dentro da aplicação.
 * 
 * Utilizei as três letras iniciais da entidade como padrão para nomear suas
 * colunas no banco de dados, creio que torna mais facil diferenciar as
 * entidades.
 * 
 */
@Data
@Entity
@Table(name = "TB_LOCALIZACAO")

@NamedQuery(name = "Localizacao.update", query = "UPDATE Localizacao l SET l.latitude=?1, l.longitude=?2, l.galaxia=?3 WHERE l.id=(SELECT r.localizacao.id FROM Rebelde r WHERE r.id=?4)")
public class Localizacao implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	@NotEmpty
	@Column(nullable = false)
	private String latitude;

	@NotEmpty
	@Column(nullable = false)
	private String longitude;

	@NotEmpty
	@Column(nullable = false)
	private String galaxia;

	@NotEmpty
	@Column(nullable = false)
	private String base;
}