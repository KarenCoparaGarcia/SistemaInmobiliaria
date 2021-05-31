package com.inmobiliaria.app.web.models.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.inmobiliaria.app.web.models.dao.IPropietarioDao;
import com.inmobiliaria.app.web.models.entity.Propietario;
@Service
public class PropietarioService implements IPropietarioService{
	@Autowired
	private IPropietarioDao dao;
	@Override
	public List<Propietario> findall() {
		// TODO Auto-generated method stub
		return (List<Propietario>)dao.findAll() ;
	}

	@Override
	public void save(Propietario propietario) {
		// TODO Auto-generated method stub
		dao.save(propietario);
	}

	@Override
	public Propietario findById(Integer id) {
		// TODO Auto-generated method stub
		return dao.findById(id).get();
	}

	@Override
	public void delete(Integer id) {
		// TODO Auto-generated method stub
		dao.deleteById(id);
	}

}
