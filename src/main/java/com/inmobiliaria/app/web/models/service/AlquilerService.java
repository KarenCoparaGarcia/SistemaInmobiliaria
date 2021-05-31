package com.inmobiliaria.app.web.models.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.inmobiliaria.app.web.models.dao.IAlquilerDao;
import com.inmobiliaria.app.web.models.entity.Alquiler;

@Service
public class AlquilerService implements IAlquilerService{
	@Autowired
	private IAlquilerDao dao;
	@Override
	public List<Alquiler> findall() {
		// TODO Auto-generated method stub
		return (List<Alquiler>)dao.findAll();
	}

	@Override
	public void save(Alquiler alquiler) {
		// TODO Auto-generated method stub
		dao.save(alquiler);
	}

	@Override
	public Alquiler findById(Integer id) {
		// TODO Auto-generated method stub
		return dao.findById(id).get();
	}

	@Override
	public void delete(Integer id) {
		// TODO Auto-generated method stub
		dao.deleteById(id);
	}

}
