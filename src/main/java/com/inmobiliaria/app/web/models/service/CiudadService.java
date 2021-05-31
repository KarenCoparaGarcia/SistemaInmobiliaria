package com.inmobiliaria.app.web.models.service;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.inmobiliaria.app.web.models.dao.ICiudadDao;
import com.inmobiliaria.app.web.models.entity.Ciudad;
@Service
public class CiudadService implements ICiudadService {

	@Autowired
	private ICiudadDao dao;
	@Override
	public List<Ciudad> findall() {
		// TODO Auto-generated method stub
		return (List<Ciudad>)dao.findAll();
	}

	@Override
	public void save(Ciudad ciudad) {
		// TODO Auto-generated method stub
		dao.save(ciudad);
	}

	@Override
	public Ciudad findById(Integer id) {
		// TODO Auto-generated method stub
		return dao.findById(id).get();
	}

	@Override
	public void delete(Integer id) {
		// TODO Auto-generated method stub
		dao.deleteById(id);
	}

}
