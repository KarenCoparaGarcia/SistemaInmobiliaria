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
import com.inmobiliaria.app.web.models.service.ICiudadService;

@Controller
@RequestMapping("/ciudad")
@SessionAttributes({"ciudad","title"})
public class CiudadController {
	
	@Autowired //Inyección de dependencias de un componente a otro componente
	private ICiudadService service;
		
	@GetMapping("/list")
	public String list(Model model) {		
		model.addAttribute("title", "Lista de Ciudades");
		List<Ciudad> ciudades = service.findall();
		model.addAttribute("ciudades", ciudades);
		return "ciudad/list"; //Nombre de la vista
	}
	@GetMapping("/form")
	private String create(Model model) {
		model.addAttribute("title", "Registro de la Ciudad");
		Ciudad ciudad= new Ciudad();
		model.addAttribute("ciudad",ciudad);
		return "ciudad/form";		
	}
	@GetMapping("/card/{id}")
	private String retrieve(@PathVariable(value="id") Integer id, Model model) {
		Ciudad ciudad = service.findById(id);
		model.addAttribute("ciudad", ciudad);
		model.addAttribute("title","Consulta de datos de la Ciudad de :"+ ciudad.getNombre());
		return "ciudad/card";
	}
	@GetMapping("/form/{id}")
	private String update(@PathVariable(value="id") Integer id,
			Model model) {
				
		Ciudad ciudad = service.findById(id); //Consulta la materia a traves del servicio
		
		model.addAttribute("ciudad",ciudad);
		model.addAttribute("title", "Actualizando datos de la Ciudad de: " + ciudad.getNombre());
		return "ciudad/form";		
	}
	
	@GetMapping("/delete/{id}")
	private String delete(@PathVariable(value="id") Integer id, Model model) {
		service.delete(id);
		return "redirect:/ciudad/list";		
	}
	
	@PostMapping("/form")
	private String save(@Valid Ciudad ciudad,BindingResult result,SessionStatus session
			,RedirectAttributes flash,Model model) 
	{	
		try {
		if(result.hasErrors()) {
			return "ciudad/form";
		}
		
			String message= "";
			
			if(ciudad.getIdciudad() == null)
			{
				
				message="Ciudad creada con exito";
			}
			else
			{
			
				message="Ciudad actualizada con exito";
			}
			service.save(ciudad);
			session.setComplete();	
			flash.addFlashAttribute("success",message);
			return "redirect:/ciudad/list";
		}catch (Exception e) {
			// TODO: handle exception
			List<Ciudad> ciudades = service.findall();
			model.addAttribute("ciudades", ciudades);
			flash.addFlashAttribute("error",e.getMessage());
			return "redirect:/";
		}

	}
	
}
