package com.bolsadeideas.springboot.form.app.models.domain;

import javax.validation.constraints.NotNull;

public class Pais {

	//@NotNull
	private Integer id;
	private String codigo;
	private String nombre;
	
	public Pais() {
		// TODO Auto-generated constructor stub
	}
	
	
	public Pais(Integer id, String codigo, String nombre) {
		this.id = id;
		this.codigo = codigo;
		this.nombre = nombre;
	}


	public String getCodigo() {
		return codigo;
	}
	public Integer getId() {
		return id;
	}
	public String getNombre() {
		return nombre;
	}
	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
}
