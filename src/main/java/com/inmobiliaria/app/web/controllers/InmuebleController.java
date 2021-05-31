package com.inmobiliaria.app.web.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import com.inmobiliaria.app.web.models.entity.Ciudad;
import com.inmobiliaria.app.web.models.entity.Inmueble;
import com.inmobiliaria.app.web.models.entity.Propietario;
import com.inmobiliaria.app.web.models.service.ICiudadService;
import com.inmobiliaria.app.web.models.service.IInmuebleService;
import com.inmobiliaria.app.web.models.service.IPropietarioService;
import com.inmobiliaria.app.web.reportes.ReporteCiudadEstado;

@Controller
@RequestMapping("/inmueble")
@SessionAttributes({"inmueble","title"})
public class InmuebleController {
	@Autowired //Inyección de dependencias de un componente a otro componente
	private IInmuebleService service;
	
	@Autowired 
	private IPropietarioService srvPropietario;
	
	@Autowired 
	private ICiudadService srvCiudad;

		
	@GetMapping("/list")
	public String list(Model model) {		
		model.addAttribute("title", "Lista de Inmuebles");
		List<Inmueble> inmuebles = service.findall();
		model.addAttribute("inmuebles", inmuebles);
		return "inmueble/list"; //Nombre de la vista
	}
	@GetMapping(value="/reports")
	public String reports(Model model) {
		model.addAttribute("title", "Reporte de Arrendamientos");		
		return "inmueble/report";
	}
	@PostMapping(value="/byCiudadEstado", produces="application/json")
	public @ResponseBody List<ReporteCiudadEstado> inmuebleByCiudadEstado() {
		return service.findByCiudadEstado();
	}
	
	@GetMapping("/form")
	private String create(Model model) {
		model.addAttribute("title", "Registro de un Inmueble");
		Inmueble inmueble= new Inmueble();
		model.addAttribute("inmueble",inmueble);
		
		//CIUDAD
		List<Ciudad> ciudades = srvCiudad.findall();
		model.addAttribute("ciudades", ciudades);
		
		//PROPIETARIO
		List<Propietario> propietarios = srvPropietario.findall();
		model.addAttribute("propietarios", propietarios);
		return "inmueble/form";		
	}
	@GetMapping("/card/{id}")
	private String retrieve(@PathVariable(value="id") Integer id, Model model) {
		Inmueble inmueble= service.findById(id);
		model.addAttribute("inmueble",inmueble);
		model.addAttribute("title","Consulta de datos de Inmueble");
		return "inmueble/card";
	}
	@GetMapping("/form/{id}")
	private String update(@PathVariable(value="id") Integer id,
			Model model) {
				
		Inmueble inmueble = service.findById(id); //Consulta la materia a traves del servicio
		
		model.addAttribute("inmueble",inmueble);
		model.addAttribute("title", "Actualizando datos del inmueble");
		//CIUDAD
		List<Ciudad> ciudades = srvCiudad.findall();
		model.addAttribute("ciudades", ciudades);
		
		//PROPIETARIO
		List<Propietario> propietarios = srvPropietario.findall();
		model.addAttribute("propietarios", propietarios);
		return "inmueble/form";		
	}
	
	@GetMapping("/delete/{id}")
	private String delete(@PathVariable(value="id") Integer id, Model model) {
		service.delete(id);
		return "redirect:/inmueble/list";		
	}
	
	@PostMapping("/form")
	private String save(@Valid Inmueble inmueble,BindingResult result,SessionStatus session
			,RedirectAttributes flash,Model model) 
	{	
		try {
		if(result.hasErrors()) {
			return "inmueble/form";
		}
		
			String message= "";
			
			if(inmueble.getIdinmueble() == null)
			{
				
				message="Inmueble creado con exito";
			}
			else
			{
				
				message="Inmueble actualizado con exito";
			}
			service.save(inmueble);
			session.setComplete();	
			flash.addFlashAttribute("success",message);
			return "redirect:/inmueble/list";
		}catch (Exception e) {
			// TODO: handle exception
			//CIUDAD
			List<Ciudad> ciudades = srvCiudad.findall();
			model.addAttribute("ciudades", ciudades);
			
			//PROPIETARIO
			List<Propietario> propietarios = srvPropietario.findall();
			model.addAttribute("propietarios", propietarios);
			
			flash.addFlashAttribute("error",e.getMessage());
			return "redirect:/";
		}

	}
	
}
