package com.inmobiliaria.app.web.models.service;

import java.util.List;

import com.inmobiliaria.app.web.models.entity.Alquiler;

public interface IAlquilerService {
	public List<Alquiler> findall();
	public void save(Alquiler alquiler);
	public Alquiler findById(Integer id);
	public void delete(Integer id);
}
