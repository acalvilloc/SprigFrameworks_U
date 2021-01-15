package com.bolsadeideas.springboot.di.app.models.domain;


import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.context.annotation.RequestScope;

@Component
@RequestScope
public class Cliente {
	
	@Value("${cliente.nombre:default value}")
	private String nombre;
	
	@Value("${cliente.apellido:default value}")
	private String apellido;
	
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
}
