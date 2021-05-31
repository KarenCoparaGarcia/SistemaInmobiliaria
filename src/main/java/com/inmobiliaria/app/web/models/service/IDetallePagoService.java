package com.inmobiliaria.app.web.models.service;

import java.util.List;
import com.inmobiliaria.app.web.models.entity.DetallePago;

public interface IDetallePagoService {
	public List<DetallePago> findall();
	public void save(DetallePago detalle);
	public DetallePago findById(Integer id);
	public void delete(Integer id);
}
