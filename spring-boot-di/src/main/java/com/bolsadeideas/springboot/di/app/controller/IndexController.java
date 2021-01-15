package com.bolsadeideas.springboot.di.app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.bolsadeideas.springboot.di.app.models.services.IServicio;

@Controller()
public class IndexController {

	//1: Acoplado, sin inyección de dependencias
	//private MiServicio s = new MiServicio();

	//Inyección en atributo
	@Autowired
	private IServicio s;

	//Inyección por constructor, la anotación se puede omitir
	/*@Autowired
	public IndexController(IServicio s) {
		this.s=s;
	}
	*/
	
	//2: DI
	@GetMapping({"/index", "/", ""})
	public String index(Model model) {
		//1
		model.addAttribute("objeto",s.operacion());
		return "index";
	}
	
	public IServicio getS() {
		return s;
	}

	/* Inyección mediante set
	@Autowired
	public void setS(IServicio s) {
		this.s = s;
	}
	*/
}
