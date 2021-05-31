package com.inmobiliaria.app.web.models.entity;

import java.io.Serializable;


import javax.persistence.Column;
import javax.persistence.Entity;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

@Entity
@Table(name="DETALLEPAGO")

public class DetallePago implements Serializable  {
	
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "IDDETALLE")
	private Integer iddetalle;
	
	@Size(max = 15)
	@NotEmpty
	@Column(name = "MES")
	private String mes;
	
	@Column(name = "VALOR")
	private float valor;
	
	@Size(max = 65)
	@NotEmpty
	@Column(name = "ESTADOPAGO")
	private String estado;
	
	@JoinColumn(name = "IDALQUILER", referencedColumnName = "IDALQUILER")
	@ManyToOne
	private Alquiler alquiler;
	
	public DetallePago() {
		this.alquiler=new Alquiler();
	}
	public DetallePago(Integer iddetalle) {
		this.iddetalle=iddetalle;
	}
	public Integer getIddetalle() {
		return iddetalle;
	}
	public void setIddetalle(Integer iddetalle) {
		this.iddetalle = iddetalle;
	}
	public String getMes() {
		return mes;
	}
	public void setMes(String mes) {
		this.mes = mes;
	}
	public float getValor() {
		return valor;
	}
	public void setValor(float valor) {
		this.valor = valor;
	}
	public String getEstado() {
		return estado;
	}
	public void setEstado(String estado) {
		this.estado = estado;
	}
	public Alquiler getAlquiler() {
		return alquiler;
	}
	public void setAlquiler(Alquiler alquiler) {
		this.alquiler = alquiler;
	}
	
}
