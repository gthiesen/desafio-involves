package com.involves.desafio.entity;

import java.util.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name="tbl_representante")
@SequenceGenerator(name = "seq_representante", sequenceName = "seq_representante", allocationSize = 1, initialValue = 1)
public class Representante extends DesafioEntity {

	@Id
	@GeneratedValue(generator="seq_representante")
	private Long id;

	private String nome;
	
	private Double latitude;
	
	private Double longitude;
	
	private Date dataRemocao; // Atributo de remoção lógica;
	
	@OneToMany(mappedBy="representante")
	private List<Loja> lojas;
	
	@OneToMany(mappedBy="representante")
	private List<RepresentanteLoja> lojasProximas;
	
	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Double getLatitude() {
		return latitude;
	}

	public void setLatitude(Double latitude) {
		this.latitude = latitude;
	}

	public Double getLongitude() {
		return longitude;
	}

	public void setLongitude(Double longitude) {
		this.longitude = longitude;
	}

	public List<Loja> getLojas() {
		return lojas;
	}

	public void setLojas(List<Loja> lojas) {
		this.lojas = lojas;
	}

	public List<RepresentanteLoja> getLojasProximas() {
		return lojasProximas;
	}

	public void setLojasProximas(List<RepresentanteLoja> lojasProximas) {
		this.lojasProximas = lojasProximas;
	}

	public Date getDataRemocao() {
		return dataRemocao;
	}

	public void setDataRemocao(Date dataRemocao) {
		this.dataRemocao = dataRemocao;
	}

}
