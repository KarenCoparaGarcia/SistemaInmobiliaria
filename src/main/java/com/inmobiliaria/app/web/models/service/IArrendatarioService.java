package com.inmobiliaria.app.web.models.service;

import java.util.List;

import com.inmobiliaria.app.web.models.entity.Arrendatario;

public interface IArrendatarioService {
	public List<Arrendatario> findall();
	public void save(Arrendatario arrendatario);
	public Arrendatario findById(Integer id);
	public void delete(Integer id);
}
