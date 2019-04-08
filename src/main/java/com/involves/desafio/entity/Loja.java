package com.involves.desafio.entity;

import java.util.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OrderBy;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name="tbl_loja")
@SequenceGenerator(name = "seq_loja", sequenceName = "seq_loja", allocationSize = 1, initialValue = 1)
public class Loja extends DesafioEntity{

	@Id
	@GeneratedValue(generator="seq_loja")
	private Long id;
	
	private String nome;
	
	private Double latitude;
	
	private Double longitude;
	
	private Date dataRemocao; // Atributo de remoção lógica;
	
	@ManyToOne
	@JoinColumn(name="representante_id")
	private Representante representante;
	
	@OneToMany(mappedBy="loja")
	@OrderBy("distancia ASC")
	private List<RepresentanteLoja> representantesProximos;

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

	public Representante getRepresentante() {
		return representante;
	}

	public void setRepresentante(Representante representante) {
		this.representante = representante;
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

	public List<RepresentanteLoja> getRepresentantesProximos() {
		return representantesProximos;
	}

	public void setRepresentantesProximos(List<RepresentanteLoja> representantesProximos) {
		this.representantesProximos = representantesProximos;
	}

	public Date getDataRemocao() {
		return dataRemocao;
	}

	public void setDataRemocao(Date dataRemocao) {
		this.dataRemocao = dataRemocao;
	}
	
	@Override
	public String toString() {
		return nome;
	}

}
