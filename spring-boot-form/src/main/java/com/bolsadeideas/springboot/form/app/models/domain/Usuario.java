package com.bolsadeideas.springboot.form.app.models.domain;

import javax.validation.constraints.NotEmpty;

public class Usuario {

	
	private String identificador;
	
	@NotEmpty
	private String nombre;
	
	@NotEmpty
	private String apellido;
	
	@NotEmpty
	private String username;
	@NotEmpty
	private String pass;
	@NotEmpty
	private String email;
	
	public String getEmail() {
		return email;
	}
	public String getPass() {
		return pass;
	}
	public String getUsername() {
		return username;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public void setPass(String pass) {
		this.pass = pass;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getApellido() {
		return apellido;
	}
	public String getNombre() {
		return nombre;
	}
	public void setApellido(String apellido) {
		this.apellido = apellido;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getIdentificador() {
		return identificador;
	}
	public void setIdentificador(String identificador) {
		this.identificador = identificador;
	}
}
