package com.bolsadeideas.springboot.di.app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.bolsadeideas.springboot.di.app.models.domain.Facturar;

@Controller
@RequestMapping("/factura")
public class FacturaController {
	
	@Autowired
	private Facturar fac;
	
	@GetMapping("/ver")
	public String ver(Model model) {
		model.addAttribute("titulo", "Ejemplo de facturación con ID");
		model.addAttribute("factura",fac);
		
		return "factura/ver";
	}

}
