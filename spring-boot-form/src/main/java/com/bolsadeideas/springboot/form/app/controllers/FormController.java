package com.bolsadeideas.springboot.form.app.controllers;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttribute;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;

import com.bolsadeideas.springboot.form.app.editor.NombreMayusculaEditor;
import com.bolsadeideas.springboot.form.app.editor.PaisPropertyEditor;
import com.bolsadeideas.springboot.form.app.editor.RolesEditor;
import com.bolsadeideas.springboot.form.app.models.domain.Pais;
import com.bolsadeideas.springboot.form.app.models.domain.Role;
import com.bolsadeideas.springboot.form.app.models.domain.Usuario;
import com.bolsadeideas.springboot.form.app.services.PaisService;
import com.bolsadeideas.springboot.form.app.services.RoleService;
import com.bolsadeideas.springboot.form.app.validation.UsuarioValidador;

@Controller
@SessionAttributes("usuario")
public class FormController {
	
	@Autowired
	private PaisService paisService;
	
	@Autowired
	private RoleService roleService;
	
	@Autowired
	private UsuarioValidador usval;
	@Autowired
	PaisPropertyEditor paisPropEd;
	@Autowired
	RolesEditor roleEditor;
	
	@InitBinder
	public void initBinder(WebDataBinder binder) {
		binder.addValidators(usval);
		SimpleDateFormat dateFormat=	new SimpleDateFormat("yyyy-MM-dd");
		dateFormat.setLenient(false);
		binder.registerCustomEditor(Date.class,"fechaNacimiento" ,new CustomDateEditor(dateFormat, true));
		binder.registerCustomEditor(String.class,"nombre" ,new NombreMayusculaEditor());
		binder.registerCustomEditor(String.class,"apellido" ,new NombreMayusculaEditor());
		
		binder.registerCustomEditor(Pais.class,"pais" ,paisPropEd);
		binder.registerCustomEditor(Role.class,"roles" ,roleEditor);
		
	}
	
	@ModelAttribute("genero")
	public List<String> genero(){
		return Arrays.asList("Hombre","Mujer","Sin Especificar");
	}
	@ModelAttribute("listaRoles")
	public List<Role>listaRoles(){
		return this.roleService.listar();
	}
	
	@ModelAttribute("listaRolesString")
	public List<String> listaRolesString(){
		List<String> roles = new ArrayList<>();
		roles.add("ROLE_ADMIN");
		roles.add("ROLE_USER");
		roles.add("ROLE_MODERATOR");
		return roles;
	}

	@ModelAttribute("listaRolesMap")
	public Map<String,String> listaRolesMap(){
		 Map<String,String> listaRoles = new HashMap<String,String>();
		 listaRoles.put("ROLE_ADMIN","Administrador");
		 listaRoles.put("ROLE_USER","Usuario");
		 listaRoles.put("ROLE_MODERATOR","Moderador");
		 return listaRoles;
	}
	
	@ModelAttribute("listaPaises")
	public List<Pais> listaPaises(){
		return paisService.listar();
	}
	@ModelAttribute("paises")
	public List<String> paises(){
		return Arrays.asList("España","México","Chile","Argentina","Perú");
	}
	
	@ModelAttribute("paisesMap")
	public Map<String,String> paisesMap(){
		 Map<String,String> paises = new HashMap<String,String>();
		 paises.put("ES","España");
		 paises.put("MX","México");
		 paises.put("CL","Chile");
		 paises.put("AR","Argentina");
		 paises.put("VE","Venezuela");
		 return paises;
	}
	
	@GetMapping("/form")
	public String form (Model model) {
		Usuario usuario = new Usuario();
		usuario.setNombre("Rodolfo");
		usuario.setApellido("Madrid");
		usuario.setIdentificador("15.970.222-A");
		usuario.setHabilitar(true);
		usuario.setValorSecreto("Algún valor secretoso ******");
		usuario.setPais(new Pais(2,"MX","México"));
		usuario.setRoles(Arrays.asList(new Role(2,"Usuario","ROLE_USER")));
		model.addAttribute("titulo","Formulario de usuarios");
		model.addAttribute("usuario",usuario);
		return	"form";
		
	}
	
	
	@PostMapping("/form")
	public String procesar(@Valid Usuario usuario,
			BindingResult result,
			Model model,
			SessionStatus status
			) {
	
	
		if(result.hasErrors()) {
			model.addAttribute("titulo","Resultado del formulario");
			return "form";
		}
		return "redirect:/ver";
	}
	
	@GetMapping("/ver")
	public String ver(@SessionAttribute(name="usuario",required=false)Usuario usuario, Model model,SessionStatus status) {
		if(usuario == null)
			return "redirect:/form";
		
		model.addAttribute("titulo","Resultado del formulario");
		status.setComplete();
		return "resultado";
	}

}
