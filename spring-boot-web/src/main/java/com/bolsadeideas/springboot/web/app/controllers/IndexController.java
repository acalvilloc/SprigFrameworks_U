package com.bolsadeideas.springboot.web.app.controllers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RequestMethod;

import com.bolsadeideas.springboot.web.app.models.Usuario;

@Controller
@RequestMapping ("/app")
public class IndexController {


	@Value("${texto.indexcontroller.index.titulo}")
	private String titulo;

	@Value("${texto.indexcontroller.perfil.titulo}")
	private String textoPerfil;
	
	@Value("${texto.indexcontroller.listar.titulo}")
	private String textoListar;
	
	//@RequestMapping(value="/index", method=RequestMethod.GET)
	@GetMapping({"/index","/","","/home"})
	public String index(Model model) {
		model.addAttribute("titulo", titulo);
		return "index";
	}
	
	@RequestMapping("/perfil")
	public String perfil(Model model) {
		Usuario user = new Usuario();
		user.setApellido("Calvillo M.");
		user.setNombre("Alexis");
		user.setEmail("acalvillm@gmail.com");
		//model.addAttribute("nombre", "Alexis");
		//model.addAttribute("apellido","Calvillo");
		model.addAttribute("usuario",user);
		model.addAttribute("titulo", "Hola:" + textoPerfil);
		return "perfil";
	}
	
	@RequestMapping("/listar")
	public String listar (Model model) {
		model.addAttribute("titulo",textoListar);
		//model.addAttribute("usuarios",usuarios);
		return "listar";
	}
	
	@ModelAttribute("usuarios")
	public List<Usuario> poblarUsuarios(){
		List<Usuario> usuarios = Arrays.asList(new Usuario("Alexis","Calvillo","acalvillm@gmail.com"),
				new Usuario("Andrea","Vieyra","andreaVieyra@gmail.com"),
				new Usuario("Auden","Vieyra","rozyB@gmail.com"),
				new Usuario("Karla", "Garza", "holi@outlook.com"));
		return usuarios;
	}
}
