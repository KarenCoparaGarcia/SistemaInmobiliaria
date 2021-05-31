package com.inmobiliaria.app.web.models.service;

import java.util.List;

import com.inmobiliaria.app.web.models.entity.Inmueble;
import com.inmobiliaria.app.web.reportes.ReporteCiudadEstado;

public interface IInmuebleService {
	public List<Inmueble> findall();
	public void save(Inmueble inmueble);
	public Inmueble findById(Integer id);
	public void delete(Integer id);
	public List<ReporteCiudadEstado> findByCiudadEstado();
}
