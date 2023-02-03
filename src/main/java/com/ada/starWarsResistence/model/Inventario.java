package com.ada.starWarsResistence.model;

import jakarta.persistence.*;
import lombok.Data;
import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CascadeType;

import java.io.Serializable;
import java.util.List;

@Data
@Entity
@Table(name = "TB_INVENTARIO")
public class Inventario implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	@OneToMany
	@Cascade(CascadeType.PERSIST)
	private List<Item> itens;
}