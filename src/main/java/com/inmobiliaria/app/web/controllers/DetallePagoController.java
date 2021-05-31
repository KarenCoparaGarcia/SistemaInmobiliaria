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
import com.inmobiliaria.app.web.models.entity.DetallePago;
import com.inmobiliaria.app.web.models.service.IAlquilerService;
import com.inmobiliaria.app.web.models.service.IDetallePagoService;

@Controller
@RequestMapping("/detallepago")
@SessionAttributes({"detallepago","title"})
public class DetallePagoController {
	@Autowired //Inyección de dependencias de un componente a otro componente
	private IDetallePagoService service;
	
	@Autowired //Inyección de dependencias de un componente a otro componente
	private IAlquilerService srvAlquiler;
		
	@GetMapping("/list")
	public String list(Model model) {		
		model.addAttribute("title", "Lista de Detalle de pagos");
		List<DetallePago> detallepagos = service.findall();
		model.addAttribute("detallepagos", detallepagos);
		return "detallepago/list"; //Nombre de la vista
	}
	@GetMapping("/form")
	private String create(Model model) {
		model.addAttribute("title", "Ingreso del Detalle de Pago");
		DetallePago detallepago= new DetallePago();
		model.addAttribute("detallepago",detallepago);
		
		List<Alquiler> alquileres = srvAlquiler.findall();
		model.addAttribute("alquileres", alquileres);
		return "detallepago/form";		
	}
	@GetMapping("/card/{id}")
	private String retrieve(@PathVariable(value="id") Integer id, Model model) {
		DetallePago detallepago= service.findById(id);
		model.addAttribute("detallepago", detallepago);
		model.addAttribute("title", detallepago.getMes());
		
		return "detallepago/card";
	}
	@GetMapping("/form/{id}")
	private String update(@PathVariable(value="id") Integer id,
			Model model) {
		DetallePago detallepago = service.findById(id);
		model.addAttribute("detallepago ", detallepago );
		model.addAttribute("title","Actualizacion de Detalle de Pago en el mes de :"+ detallepago.getMes());
		
		List<Alquiler> alquileres = srvAlquiler.findall();
		model.addAttribute("alquileres", alquileres);
		return "detallepago/form";	
	}
	
	@GetMapping("/delete/{id}")
	private String delete(@PathVariable(value="id") Integer id, Model model) {
		service.delete(id);
		return "redirect:/detallepago/list";		
	}
	
	@PostMapping("/form")
	private String save(@Valid DetallePago detallepago ,BindingResult result,SessionStatus session
			,RedirectAttributes flash,Model model) 
	{	
		try {
		if(result.hasErrors()) {
			return "detallepago/form";
		}
		
			String message= "";
			
			if(detallepago.getIddetalle() == null)
			{
				
				message="Detalle de pago creado con exito";
			}
			else
			{
				
				message="Detalle de pago actualizado con exito";
			}
			service.save(detallepago);
			session.setComplete();	
			flash.addFlashAttribute("success",message);
			return "redirect:/detallepago/list";
		}catch (Exception e) {
			// TODO: handle exception
			List<Alquiler> alquileres = srvAlquiler.findall();
			model.addAttribute("alquileres", alquileres);
			flash.addFlashAttribute("error",e.getMessage());
			return "redirect:/";
		}

	}
	
}
