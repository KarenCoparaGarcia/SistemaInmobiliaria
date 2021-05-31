package com.inmobiliaria.app.web.models.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.inmobiliaria.app.web.models.dao.ICiudadDao;
import com.inmobiliaria.app.web.models.dao.IInmuebleDao;
import com.inmobiliaria.app.web.models.entity.Ciudad;
import com.inmobiliaria.app.web.models.entity.Inmueble;
import com.inmobiliaria.app.web.reportes.INombreEstado;
import com.inmobiliaria.app.web.reportes.ReporteCiudadEstado;
@Service
public class InmuebleService implements IInmuebleService {
	@Autowired
	private IInmuebleDao daoinmueble;
	
	@Autowired
	private ICiudadDao daoCiudad;
	
	@Override
	public List<Inmueble> findall() {
		// TODO Auto-generated method stub
		return (List<Inmueble>)daoinmueble.findAll();
	}

	@Override
	public void save(Inmueble inmueble) {
		// TODO Auto-generated method stub
		daoinmueble.save(inmueble);
	}

	@Override
	public Inmueble findById(Integer id) {
		// TODO Auto-generated method stub
		return daoinmueble.findById(id).get();
	}

	@Override
	public void delete(Integer id) {
		// TODO Auto-generated method stub
		daoinmueble.deleteById(id);
	}

	@Override
	public List<ReporteCiudadEstado> findByCiudadEstado() {
		List<Ciudad> ciudades = (List<Ciudad>) daoCiudad.findAll();
		List<ReporteCiudadEstado> ResultadoEstado = new ArrayList<>();
		for (Ciudad ciu:ciudades){
			ReporteCiudadEstado reportCiudadEstado=new ReporteCiudadEstado();
			reportCiudadEstado.setCiudad(ciu.getNombre());
			reportCiudadEstado.setDisponibles(0L);;
			reportCiudadEstado.setNoDisponibles(0L);
			ResultadoEstado.add(reportCiudadEstado);
		}
		List<INombreEstado> Disponibles = daoinmueble.findByCiudadEstado(1);
		List<INombreEstado> noDisponibles = daoinmueble.findByCiudadEstado(2);

		for (ReporteCiudadEstado res : ResultadoEstado) {
			res.setDisponibles(this.getInmuebleCiudad(res.getCiudad(), Disponibles));
			res.setNoDisponibles(this.getInmuebleCiudad(res.getCiudad(), noDisponibles));
		}

		return ResultadoEstado;
	}
	private Long getInmuebleCiudad(String nombre, List<INombreEstado> numeros) {
		for (INombreEstado ob : numeros) {
			String datoNombre=ob.getNombre();
			if (nombre.equals(datoNombre)) {
				Long valor=ob.getNumero();	
				return valor;
			}
		}
		return 0L;
	}

}
