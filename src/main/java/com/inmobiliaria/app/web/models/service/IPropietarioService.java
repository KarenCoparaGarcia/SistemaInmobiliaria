package com.inmobiliaria.app.web.models.service;

import java.util.List;
import com.inmobiliaria.app.web.models.entity.Propietario;

public interface IPropietarioService {
	public List<Propietario> findall();
	public void save(Propietario propietario);
	public Propietario findById(Integer id);
	public void delete(Integer id);
}
