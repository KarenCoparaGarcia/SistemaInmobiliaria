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
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.inmobiliaria.app.web.models.entity.Alquiler;
import com.inmobiliaria.app.web.models.entity.Arrendatario;
import com.inmobiliaria.app.web.models.entity.Inmueble;
import com.inmobiliaria.app.web.models.service.IAlquilerService;
import com.inmobiliaria.app.web.models.service.IArrendatarioService;
import com.inmobiliaria.app.web.models.service.IInmuebleService;


@Controller
@RequestMapping("/alquiler")
@SessionAttributes({"alquiler","title"})
public class AlquilerController {
	@Autowired //Inyección de dependencias de un componente a otro componente
	private IInmuebleService srvInmueble;
	
	@Autowired 
	private IArrendatarioService srvArrendatario;
	
	@Autowired 
	private IAlquilerService service;
	
	@GetMapping("/list")
	public String list(Model model) {		
		model.addAttribute("title", "Lista de Alquileres");
		List<Alquiler> alquileres = service.findall();
		model.addAttribute("alquileres", alquileres);
		return "alquiler/list"; //Nombre de la vista
	}
	@GetMapping("/form")
	private String create(Model model) {
		model.addAttribute("title", "Registro de un Alquiler");
		Alquiler alquiler= new Alquiler();
		model.addAttribute("alquiler",alquiler);
		
		//Inmueble
		List<Inmueble> inmuebles = srvInmueble.findall();
		model.addAttribute("inmuebles", inmuebles);
		
		//Arrendatario
		List<Arrendatario> arrendatarios = srvArrendatario.findall();
		model.addAttribute("arrendatarios", arrendatarios);
		return "alquiler/form";		
	}
	@GetMapping("/card/{id}")
	private String retrieve(@PathVariable(value="id") Integer id, Model model) {
		Alquiler alquiler= service.findById(id);
		model.addAttribute("alquiler",alquiler);
		model.addAttribute("title","Consulta de datos de Alquiler");
		return "alquiler/card";
	}
	
	@GetMapping("/form/{id}")
	private String update(@PathVariable(value="id") Integer id,
			Model model) {
				
		Alquiler alquiler = service.findById(id); //Consulta la materia a traves del servicio
		
		model.addAttribute("alquiler",alquiler);
		model.addAttribute("title", "Actualizando datos del Alquiler");
		//CIUDAD
		List<Inmueble> inmuebles = srvInmueble.findall();
		model.addAttribute("inmuebles", inmuebles);
		
		//PROPIETARIO
		List<Arrendatario> arrendatarios = srvArrendatario.findall();
		model.addAttribute("arrendatarios", arrendatarios);
		return "alquiler/form";		
	}
	@GetMapping("/delete/{id}")
	private String delete(@PathVariable(value="id") Integer id, Model model) {
		service.delete(id);
		return "redirect:/alquiler/list";		
	}
	@PostMapping("/form")
	private String save(@Valid Alquiler alquiler,BindingResult result,SessionStatus session
			,RedirectAttributes flash,Model model) 
	{	
		try {
		if(result.hasErrors()) {
			return "alquiler/form";
		}
		
			String message= "";
			
			if(alquiler.getIdalquiler() == null)
			{
				
				message="Alquiler creado con exito";
			}
			else
			{
				
				message="Alquiler actualizado con exito";
			}
			service.save(alquiler);
			session.setComplete();	
			flash.addFlashAttribute("success",message);
			return "redirect:/alquiler/list";
		}catch (Exception e) {
			// TODO: handle exception
			//CIUDAD
			List<Inmueble> inmuebles = srvInmueble.findall();
			model.addAttribute("inmuebles",inmuebles);
			
			//PROPIETARIO
			List<Arrendatario> arrendatarios = srvArrendatario.findall();
			model.addAttribute("arrendatarios",arrendatarios);
			
			flash.addFlashAttribute("error",e.getMessage());
			return "redirect:/";
		}

	}
	
	
	
}

