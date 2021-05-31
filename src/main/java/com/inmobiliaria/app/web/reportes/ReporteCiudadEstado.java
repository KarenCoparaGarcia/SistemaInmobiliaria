package com.inmobiliaria.app.web.reportes;

import java.io.Serializable;

public class ReporteCiudadEstado implements Serializable {
	
	
	private static final long serialVersionUID = 1L;
	private String ciudad;
	private Long Disponibles;
	private Long noDisponibles;
	
	
	public ReporteCiudadEstado() {
		super();
	}


	public String getCiudad() {
		return ciudad;
	}


	public void setCiudad(String ciudad) {
		this.ciudad = ciudad;
	}


	public Long getDisponibles() {
		return Disponibles;
	}


	public void setDisponibles(Long disponibles) {
		Disponibles = disponibles;
	}


	public Long getNoDisponibles() {
		return noDisponibles;
	}


	public void setNoDisponibles(Long noDisponibles) {
		this.noDisponibles = noDisponibles;
	}
	
	
}
