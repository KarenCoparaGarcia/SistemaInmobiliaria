package com.inmobiliaria.app.web.models.dao;
import org.springframework.data.repository.CrudRepository;

import com.inmobiliaria.app.web.models.entity.Alquiler;


public interface IAlquilerDao extends CrudRepository<Alquiler, Integer>{

}
