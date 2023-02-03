package com.ada.starWarsResistence.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import lombok.Data;
import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CascadeType;

import java.io.Serializable;

@Data
@Entity
@Table(name = "TB_REBELDE")

@NamedQueries({
		@NamedQuery(name = "Rebelde.confirmarTraicao", query = "UPDATE Rebelde r SET r.traidor=true WHERE r.id=?1"),
		@NamedQuery(name = "Rebelde.totalTraidores", query = "SELECT COUNT(r.id) FROM Rebelde r WHERE r.traidor=?1"),
		@NamedQuery(name = "Rebelde.totalRebeldes", query = "SELECT COUNT(r.id) FROM Rebelde r") })

public class Rebelde implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	@NotEmpty
	@Column(nullable = false)
	private String nome;

	@Column(nullable = false)
	private int idade;

	@Column(nullable = false)
	private char genero;

	@Column(nullable = false)
	private boolean traidor;

	public boolean isTraidor() {
		return traidor;
	}

	@OneToOne
	@Cascade(CascadeType.PERSIST)
	@JoinColumn(nullable = false)
	private Localizacao localizacao;

	@OneToOne
	@Cascade(CascadeType.PERSIST)
	@JoinColumn(nullable = false)
	private Inventario inventario;

}