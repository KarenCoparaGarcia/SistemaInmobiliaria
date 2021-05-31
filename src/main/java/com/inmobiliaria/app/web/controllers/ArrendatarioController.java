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
import com.inmobiliaria.app.web.models.entity.Arrendatario;
import com.inmobiliaria.app.web.models.service.IArrendatarioService;

@Controller
@RequestMapping("/arrendatario")
@SessionAttributes({"arrendatario","title"})
public class ArrendatarioController {
	@Autowired //Inyección de dependencias de un componente a otro componente
	private IArrendatarioService service;
		
	@GetMapping("/list")
	public String list(Model model) {		
		model.addAttribute("title", "Lista de Arrendatarios");
		List<Arrendatario> arrendatarios = service.findall();
		model.addAttribute("arrendatarios", arrendatarios);
		return "arrendatario/list"; //Nombre de la vista
	}
	@GetMapping("/form")
	private String create(Model model) {
		model.addAttribute("title", "Registro del Arrendatario");
		Arrendatario arrendatario= new Arrendatario();
		model.addAttribute("arrendatario",arrendatario);
		return "arrendatario/form";		
	}
	@GetMapping("/card/{id}")
	private String retrieve(@PathVariable(value="id") Integer id, Model model) {
		Arrendatario arrendatario = service.findById(id);
		model.addAttribute("arrendatario", arrendatario);
		model.addAttribute("title", arrendatario.getNombre());
		
		return "arrendatario/card";
	}
	@GetMapping("/form/{id}")
	private String update(@PathVariable(value="id") Integer id,
			Model model) {
		Arrendatario arrendatario = service.findById(id);
		model.addAttribute("arrendatario ", arrendatario );
		model.addAttribute("title","Actualizacion de datos del Arrendatario :"+ arrendatario .getNombre());
		return "arrendatario/form";
	}
	
	@GetMapping("/delete/{id}")
	private String delete(@PathVariable(value="id") Integer id, Model model) {
		service.delete(id);
		return "redirect:/arrendatario/list";		
	}
	
	@PostMapping("/form")
	private String save(@Valid Arrendatario arrendatario ,BindingResult result,SessionStatus session
			,RedirectAttributes flash) 
	{	
		try {
		if(result.hasErrors()) {
			return "arrendatario/form";
		}
		
			String message= "";
			
			if(arrendatario.getIdarrendatario() == null)
			{
				
				message="Arrendatario creado con exito";
			}
			else
			{
			
				message="Arrendatario actualizado con exito";
			}
			service.save(arrendatario);
			session.setComplete();	
			flash.addFlashAttribute("success",message);
			return "redirect:/arrendatario/list";
		}catch (Exception e) {
			// TODO: handle exception
			flash.addFlashAttribute("error",e.getMessage());
			return "redirect:/";
		}

	}
	
}
