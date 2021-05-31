package com.inmobiliaria.app.web.models.dao;

import org.springframework.data.repository.CrudRepository;

import com.inmobiliaria.app.web.models.entity.Arrendatario;


public interface IArrendatarioDao extends CrudRepository<Arrendatario, Integer> {

}
