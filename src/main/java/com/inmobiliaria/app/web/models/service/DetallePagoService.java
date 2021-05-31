package com.inmobiliaria.app.web.models.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.inmobiliaria.app.web.models.dao.IDetallePagoDao;
import com.inmobiliaria.app.web.models.entity.DetallePago;
@Service
public class DetallePagoService implements IDetallePagoService{

	@Autowired
	private IDetallePagoDao dao;
	@Override
	public List<DetallePago> findall() {
		// TODO Auto-generated method stub
		return (List<DetallePago>)dao.findAll();
	}

	@Override
	public void save(DetallePago detalle) {
		// TODO Auto-generated method stub
		dao.save(detalle);
	}

	@Override
	public DetallePago findById(Integer id) {
		// TODO Auto-generated method stub
		return dao.findById(id).get();
	}

	@Override
	public void delete(Integer id) {
		// TODO Auto-generated method stub
		dao.deleteById(id);
	}

}
