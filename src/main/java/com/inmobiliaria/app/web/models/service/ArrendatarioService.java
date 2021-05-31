package com.inmobiliaria.app.web.models.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.inmobiliaria.app.web.models.dao.IArrendatarioDao;
import com.inmobiliaria.app.web.models.entity.Arrendatario;
@Service
public class ArrendatarioService implements IArrendatarioService {
	@Autowired
	private IArrendatarioDao daoarrendatario;
	@Override
	public List<Arrendatario> findall() {
		// TODO Auto-generated method stub
		return (List<Arrendatario>)daoarrendatario.findAll();
	}

	@Override
	public void save(Arrendatario arrendatario) {
		// TODO Auto-generated method stub
		daoarrendatario.save(arrendatario);
	}

	@Override
	public Arrendatario findById(Integer id) {
		// TODO Auto-generated method stub
		return daoarrendatario.findById(id).get();
	}

	@Override
	public void delete(Integer id) {
		// TODO Auto-generated method stub
		daoarrendatario.deleteById(id);
	}

}
