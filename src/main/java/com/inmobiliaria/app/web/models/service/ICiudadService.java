package com.inmobiliaria.app.web.models.service;

import java.util.List;

import com.inmobiliaria.app.web.models.entity.Ciudad;

public interface ICiudadService {
	public List<Ciudad> findall();
	public void save(Ciudad ciudad);
	public Ciudad findById(Integer id);
	public void delete(Integer id);
}
