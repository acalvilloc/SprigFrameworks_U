package com.bolsadeideas.springboot.di.app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.bolsadeideas.springboot.di.app.models.services.IServicio;

@Controller
public class IndexController {

	//1: Acoplado, sin inyección de dependencias
	//private MiServicio s = new MiServicio();
	
	//2: DI
	@Autowired
	private IServicio s;
	@GetMapping({"/index", "/", ""})
	public String index(Model model) {
		//1
		model.addAttribute("objeto",s.operacion());
		return "index";
	}
	
	
}
