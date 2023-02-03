package com.ada.starWarsResistence.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import lombok.Data;
import org.hibernate.annotations.ColumnDefault;

import java.io.Serializable;

@Data
@Entity
@Table(name = "TB_ITEM")
public class Item implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	@NotEmpty
	@Column(nullable = false)
	private String nome;

	@ColumnDefault("0")
	private int qtd;

	private int pontos;

	public void adicionarPontos() {

		if (this.nome.equalsIgnoreCase("Arma")) {
			this.pontos = 4;
		} else if (this.nome.equalsIgnoreCase("Munição")) {
			this.pontos = 3;
		} else if (this.nome.equalsIgnoreCase("Água")) {
			this.pontos = 2;
		} else if (this.nome.equalsIgnoreCase("Comida")) {
			this.pontos = 1;
		}
	}
}