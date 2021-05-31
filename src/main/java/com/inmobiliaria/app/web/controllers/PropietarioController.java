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

import com.inmobiliaria.app.web.models.entity.Ciudad;
import com.inmobiliaria.app.web.models.entity.Propietario;
import com.inmobiliaria.app.web.models.service.ICiudadService;
import com.inmobiliaria.app.web.models.service.IPropietarioService;

@Controller
@RequestMapping("/propietario")
@SessionAttributes({"propietario","title"})

public class PropietarioController {
	
	@Autowired //Inyección de dependencias de un componente a otro componente
	private IPropietarioService service;
	
	@Autowired //Inyección de dependencias de un componente a otro componente
	private ICiudadService srvCiudad;
		
	@GetMapping("/list")
	public String list(Model model) {		
		model.addAttribute("title", "Lista de Propietarios");
		List<Propietario> propietarios = service.findall();
		model.addAttribute("propietarios", propietarios);
		return "propietario/list"; //Nombre de la vista
	}
	@GetMapping("/form")
	private String create(Model model) {
		model.addAttribute("title", "Registro del Propietario");
		Propietario propietario= new Propietario();
		model.addAttribute("propietario",propietario);
		
		List<Ciudad> ciudades = srvCiudad.findall();
		model.addAttribute("ciudades", ciudades);
		return "propietario/form";		
	}
	@GetMapping("/card/{id}")
	private String retrieve(@PathVariable(value="id") Integer id, Model model) {
		Propietario propietario = service.findById(id);
		model.addAttribute("propietario",propietario);
		model.addAttribute("title",propietario.getNombre());
		
		return "propietario/card";
	}
	@GetMapping("/form/{id}")
	private String update(@PathVariable(value="id") Integer id,
			Model model) {
		Propietario propietario = service.findById(id);
		model.addAttribute("propietario",propietario);
		model.addAttribute("title","Actualizacion de datos del Propietario :"+propietario.getNombre());
		
		List<Ciudad> ciudades = srvCiudad.findall();
		model.addAttribute("ciudades", ciudades);
		return "propietario/form";
	}
	
	@GetMapping("/delete/{id}")
	private String delete(@PathVariable(value="id") Integer id, Model model) {
		service.delete(id);
		return "redirect:/propietario/list";		
	}
	
	@PostMapping("/form")
	private String save(@Valid Propietario propietario ,BindingResult result,SessionStatus session
			,RedirectAttributes flash,Model model) 
	{	
		try {
		if(result.hasErrors()) {
			return "propietario/form";
		}
		
			String message= "";
			
			if(propietario.getIdpropietario() == null)
			{
	
				message="Propietario creado con exito";
			}
			else
			{
			
				message="Propietario actualizado con exito";
			}
			service.save(propietario);
			session.setComplete();	
			flash.addFlashAttribute("success",message);
			return "redirect:/propietario/list";
		}catch (Exception e) {
			// TODO: handle exception
			List<Ciudad> ciudades = srvCiudad.findall();
			model.addAttribute("ciudades", ciudades);
			flash.addFlashAttribute("error",e.getMessage());
			return "redirect:/";
		}

	}
	
}
