package com.inmobiliaria.app.web.models.entity;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

@Entity
@Table(name = "CIUDAD")
public class Ciudad implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "IDCIUDAD")
	private Integer idciudad;
	
	@Size(max = 55)
	@NotEmpty
	@Column(name = "NOMBRE")
	private String nombre;
	
	//AGREGAR EL MAPPEDBY DESPUES DEL CONTROLADOR
	//RELACION CIUDAD-PROPIETARIO
	@OneToMany(mappedBy="ciudad", fetch=FetchType.LAZY)
	private List<Propietario> propietarios;
	
	//RELACION CIUDAD-INMUEBLE
	
	@OneToMany(mappedBy="ciudad", fetch=FetchType.LAZY)
	private List<Inmueble> inmuebles;
	
	public Ciudad() {

	}
	public Ciudad(Integer idciudad) {
	
		this.idciudad = idciudad;
	}
	public List<Propietario> getPropietarios(){
		return this.propietarios;
	}
	
	public List<Inmueble> getInmuebles(){
		return this.inmuebles;
	}
	public Integer getIdciudad() {
		return idciudad;
	}
	public void setIdciudad(Integer idciudad) {
		this.idciudad = idciudad;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
}
