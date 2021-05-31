package com.inmobiliaria.app.web.models.dao;

import java.util.ArrayList;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import com.inmobiliaria.app.web.models.entity.Inmueble;
import com.inmobiliaria.app.web.reportes.INombreEstado;


public interface IInmuebleDao extends CrudRepository<Inmueble, Integer>{
	
	@Query("SELECT Im.ciudad.nombre as nombre, "
			+ "COUNT(Im.ciudad.nombre) as numero "
			+ "FROM Inmueble Im "
			+ "WHERE Im.estado = :estado "
			+ "GROUP BY Im.ciudad.nombre")
	public ArrayList<INombreEstado> findByCiudadEstado(
			@Param("estado") int estado);
}
