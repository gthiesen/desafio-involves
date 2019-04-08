package com.involves.desafio.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="tbl_representante_loja")
@IdClass(RepresentanteLojaId.class)
public class RepresentanteLoja extends DesafioEntity{

	@Id
	@ManyToOne
	@JoinColumn(name="representante_id")
	private Representante representante;
	
	@Id
	@ManyToOne()
	@JoinColumn(name="loja_id")
	private Loja loja;

	private Double distancia;

	public Double getDistancia() {
		return distancia;
	}

	public void setDistancia(Double distancia) {
		this.distancia = distancia;
	}

	public Representante getRepresentante() {
		return representante;
	}

	public void setRepresentante(Representante representante) {
		this.representante = representante;
	}

	public Loja getLoja() {
		return loja;
	}

	public void setLoja(Loja loja) {
		this.loja = loja;
	}

	public String getLabel() {
		return getRepresentante().getNome() + " ( "+getDistancia() + " Km ) ";

	}
}
