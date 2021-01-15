package com.bolsadeideas.springboot.di.app.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.bolsadeideas.springboot.di.models.services.MiServicio;

@Controller
public class IndexController {

	//1: Acoplado, sin inyección de dependencias
	private MiServicio s = new MiServicio();
	
	@GetMapping({"/index", "/", ""})
	public String index(Model model) {
		//1
		model.addAttribute("objeto",s.operacion());
		return "index";
	}
	
	
}
