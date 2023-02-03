package com.ada.starWarsResistence.model;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class Negociacao {
	private Long idRebelde;
	private List<Item> itens;
}
