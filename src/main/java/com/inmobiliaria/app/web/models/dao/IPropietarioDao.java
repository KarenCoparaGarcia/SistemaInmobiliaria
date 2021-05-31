package com.inmobiliaria.app.web.models.dao;



import org.springframework.data.repository.CrudRepository;

import com.inmobiliaria.app.web.models.entity.Propietario;


public interface IPropietarioDao extends CrudRepository<Propietario, Integer>{
	
}
