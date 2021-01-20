package com.bolsadeideas.springboot.horariointerceptor.app.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class AppController {

	@GetMapping({"","/","/index"})
	public String index(Model model) {
		
		model.addAttribute("titulo","Bienvenido al horario de atención a clientes");
		return "index";
	}
	
	@GetMapping("/cerrado")
	public String cerrado(Model model) {
		StringBuilder mensaje = new StringBuilder("Cerrado, por favor visítenos entre: ");
		mensaje.append(" apertura");
		mensaje.append(" hrs");
		mensaje.append(" y las");
		mensaje.append(" cierre");
		mensaje.append(" hrs");
		model.addAttribute("titulo", "Fuera del horario de atención");
		model.addAttribute("mensaje", mensaje);
		return "cerrado";
		
	}
}
