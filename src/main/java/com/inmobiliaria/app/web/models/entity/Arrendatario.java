package com.inmobiliaria.app.web.models.entity;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Past;
import javax.validation.constraints.Size;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name = "ARRENDATARIO")
public class Arrendatario implements Serializable {
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "IDARRENDATARIO")
	private Integer idarrendatario;
	
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
	
	@Past
	@Temporal(TemporalType.DATE)
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	@Column(name = "FECHANACIMIENTO")
	private Date fechanacimiento;
	
	@Size(max = 15)
	@NotEmpty
	@Column(name = "TELEFONO")
	private String telefono;
	
	@Size(max = 15)
	@NotEmpty
	@Column(name = "SEXO")
	private String sexo;
	
	@Size(max = 20)
	@NotEmpty
	@Column(name = "ESTADOCIVIL")
	private String estadocivil;
	
	@OneToMany(mappedBy="arrendatario", fetch=FetchType.LAZY)
	private List<Alquiler> alquileres;
	
	public Arrendatario() {
		
	}	

	public Arrendatario(Integer idarrendatario) {
		this.idarrendatario = idarrendatario;
	}

	public Integer getIdarrendatario() {
		return idarrendatario;
	}

	public void setIdarrendatario(Integer idarrendatario) {
		this.idarrendatario = idarrendatario;
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

	public Date getFechanacimiento() {
		return fechanacimiento;
	}

	public void setFechanacimiento(Date fechanacimiento) {
		this.fechanacimiento = fechanacimiento;
	}

	public String getTelefono() {
		return telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

	public String getSexo() {
		return sexo;
	}

	public void setSexo(String sexo) {
		this.sexo = sexo;
	}

	public String getEstadocivil() {
		return estadocivil;
	}

	public void setEstadocivil(String estadocivil) {
		this.estadocivil = estadocivil;
	}

	public List<Alquiler> getAlquileres() {
		return this.alquileres;
	}


	
	
}
