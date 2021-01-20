package com.bolsadeideas.springboot.error.app.models.domain;

public class Usuario {

	private Integer id;
	private String nombre;
	private String apellido;
	
	public String getApellido() {
		return apellido;
	}
	public Integer getId() {
		return id;
	}
	public String getNombre() {
		return nombre;
	}
	public void setApellido(String apellido) {
		this.apellido = apellido;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
	public Usuario(Integer id, String nombre, String apellido) {
		this.id = id;
		this.nombre = nombre;
		this.apellido = apellido;
	}
	
}
