package com.involves.desafio.entity;

import java.io.Serializable;

public class RepresentanteLojaId implements Serializable{

	private static final long serialVersionUID = -9152061334292577191L;

	private Long representante;
	
	private Long loja;

	public Long getRepresentante() {
		return representante;
	}

	public void setRepresentante(Long representante) {
		this.representante = representante;
	}

	public Long getLoja() {
		return loja;
	}

	public void setLoja(Long loja) {
		this.loja = loja;
	}



}
