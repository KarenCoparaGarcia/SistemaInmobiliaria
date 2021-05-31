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
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name="ALQUILER")

public class Alquiler implements Serializable  {

	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "IDALQUILER")
	private Integer idalquiler;
	//Alquiler-detalle
	
	@OneToMany(mappedBy="alquiler", fetch=FetchType.LAZY)
	private List<DetallePago> detalles;
	
	//relacion inmueble
	
	@JoinColumn(name = "IDINMUEBLE", referencedColumnName = "IDINMUEBLE")
	@ManyToOne
	private Inmueble inmueble;
	
	@Size(max = 15)
	@NotEmpty
	@Column(name = "GARANTIA")
	private String garantia;
	
	//relacion  
	@JoinColumn(name = "IDARRENDATARIO", referencedColumnName = "IDARRENDATARIO")
	@ManyToOne
	private Arrendatario arrendatario;
	
	
	@Temporal(TemporalType.DATE)
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	@Column(name = "FECHAINICIO")
	private Date fechainicio;
	
	@Temporal(TemporalType.DATE)
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	@Column(name = "FECHAFINAL")
	private Date fechafinal;
	
	@Size(max = 55)
	@NotEmpty
	@Column(name = "FORMAPAGO")
	private String formapago;
	
	public Alquiler() {
		this.inmueble=new Inmueble();
		this.arrendatario=new Arrendatario();
	}
	
	public Alquiler(Integer idalquiler) {
		this.idalquiler=idalquiler;
	}

	public Integer getIdalquiler() {
		return idalquiler;
	}

	public void setIdalquiler(Integer idalquiler) {
		this.idalquiler = idalquiler;
	}

	public Inmueble getInmueble() {
		return inmueble;
	}

	public void setInmueble(Inmueble inmueble) {
		this.inmueble = inmueble;
	}

	public String getGarantia() {
		return garantia;
	}

	public void setGarantia(String garantia) {
		this.garantia = garantia;
	}

	public Arrendatario getArrendatario() {
		return arrendatario;
	}

	public void setArrendatario(Arrendatario arrendatario) {
		this.arrendatario = arrendatario;
	}

	public Date getFechainicio() {
		return fechainicio;
	}

	public void setFechainicio(Date fechainicio) {
		this.fechainicio = fechainicio;
	}

	public Date getFechafinal() {
		return fechafinal;
	}

	public void setFechafinal(Date fechafinal) {
		this.fechafinal = fechafinal;
	}

	public String getFormapago() {
		return formapago;
	}

	public void setFormapago(String formapago) {
		this.formapago = formapago;
	}

	
	//Agregar setter y getter
	
	
	
}
