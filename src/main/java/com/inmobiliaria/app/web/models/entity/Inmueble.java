package com.inmobiliaria.app.web.models.entity;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;


@Entity
@Table(name= "INMUEBLE")

public class Inmueble implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "IDINMUEBLE")
	private Integer idinmueble;
	
	@Size(max = 55)
	@NotEmpty
	@Column(name = "DIRECCION")
	private String direccion;
	
	@Size(max = 55)
	@NotEmpty
	@Column(name = "BARRIO")
	private String barrio;
	
	@OneToMany(mappedBy="inmueble", fetch=FetchType.LAZY)
	private List<Alquiler> alquileres;
	

	
	@JoinColumn(name = "IDCIUDAD", referencedColumnName = "IDCIUDAD")
	@ManyToOne
	private Ciudad ciudad;
	
	@JoinColumn(name = "IDPROPIETARIO", referencedColumnName = "IDPROPIETARIO")
	@ManyToOne
	private Propietario propietario;
	
	@Column(name = "ANIO")
	private int anio;
	
	@Size(max = 55)
	@NotEmpty
	@Column(name = "TIPO")
	private String tipo;
	
	@Size(max = 20)
	@NotEmpty
	@Column(name = "SUPERFICIE")
	private String superficie;
	
	
	@Column(name = "DORMITORIOS")
	private int dormitorios;
	
	
	@Size(max = 6)
	@NotEmpty
	@Column(name = "GARAGE")
	private String garage;
	
	@Column(name = "PRECIO")
	private int precio;
	

	@Column(name = "ESTADO")
	private int estado;
	
	@Size(max = 55)
	@NotEmpty
	@Column(name = "OBSERVACIONES")
	private String observaciones;
	
	public Inmueble() {
		this.ciudad=new Ciudad();
		this.propietario=new Propietario();
	}
	
	public Inmueble(Integer id) {
		this.idinmueble=id;
	}

	public Integer getIdinmueble() {
		return idinmueble;
	}

	public void setIdinmueble(Integer idinmueble) {
		this.idinmueble = idinmueble;
	}

	public String getDireccion() {
		return direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	public String getBarrio() {
		return barrio;
	}

	public void setBarrio(String barrio) {
		this.barrio = barrio;
	}

	public int getAnio() {
		return anio;
	}

	public void setAnio(int anio) {
		this.anio = anio;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public String getSuperficie() {
		return superficie;
	}

	public void setSuperficie(String superficie) {
		this.superficie = superficie;
	}

	public int getDormitorios() {
		return dormitorios;
	}

	public void setDormitorios(int dormitorios) {
		this.dormitorios = dormitorios;
	}

	public String getGarage() {
		return garage;
	}

	public void setGarage(String garage) {
		this.garage = garage;
	}

	public int getPrecio() {
		return precio;
	}

	public void setPrecio(int precio) {
		this.precio = precio;
	}

	public String getObservaciones() {
		return observaciones;
	}

	public void setObservaciones(String observaciones) {
		this.observaciones = observaciones;
	}

	public Ciudad getCiudad() {
		return ciudad;
	}

	public void setCiudad(Ciudad ciudad) {
		this.ciudad = ciudad;
	}

	public Propietario getPropietario() {
		return propietario;
	}

	public void setPropietario(Propietario propietario) {
		this.propietario = propietario;
	}

	public List<Alquiler> getAlquileresin() {
		return this.alquileres;
	}

	public int getEstado() {
		return estado;
	}

	public void setEstado(int estado) {
		this.estado = estado;
	}


	
}
