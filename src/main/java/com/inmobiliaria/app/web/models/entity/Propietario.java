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
//import javax.persistence.JoinColumn;
//import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;


@Entity
@Table(name = "PROPIETARIO")
public class Propietario implements Serializable {
	
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "IDPROPIETARIO")
	private Integer idpropietario;
	
	@Size(max = 15)
	@NotEmpty
	@Column(name = "CEDULA")
	private String cedula;
	
	@Size(max = 55)
	@NotEmpty
	@Column(name = "NOMBRE")
	private String nombre;
	
	@Size(max = 55)
	@NotEmpty
	@Column(name = "APELLIDO")
	private String apellido;
	
	@Size(max = 55)
	@NotEmpty
	@Column(name = "DIRECCION")
	private String direccion;
	
	@Size(max = 15)
	@NotEmpty
	@Column(name = "TELEFONO")
	private String telefono;

	@JoinColumn(name = "IDCIUDAD", referencedColumnName = "IDCIUDAD")
	@ManyToOne
	private Ciudad ciudad;
	
	@OneToMany(mappedBy="propietario", fetch=FetchType.LAZY)
	private List<Inmueble> inmuebles;
	
	public Propietario() {
		this.ciudad=new Ciudad();
	}

	public Propietario(Integer idpropietario) {
		
		this.idpropietario = idpropietario;
	}
	public List<Inmueble> getInmuebles(){
		return this.inmuebles;
	}
	public Integer getIdpropietario() {
		return idpropietario;
	}

	public void setIdpropietario(Integer idpropietario) {
		this.idpropietario = idpropietario;
	}

	public String getCedula() {
		return cedula;
	}

	public void setCedula(String cedula) {
		this.cedula = cedula;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellido() {
		return apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	public String getDireccion() {
		return direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	public String getTelefono() {
		return telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

	public Ciudad getCiudad() {
		return ciudad;
	}

	public void setCiudad(Ciudad ciudad) {
		this.ciudad = ciudad;
	}
	
	
}
