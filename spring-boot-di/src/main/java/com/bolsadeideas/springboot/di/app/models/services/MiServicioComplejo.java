package com.bolsadeideas.springboot.di.app.models.services;


//@Controller("ServicioComplejo")
public class MiServicioComplejo implements IServicio {

	@Override
	public String operacion() {
		return "Ejecutando algún proceso bien complejoso...";
	}
	
 
	
}
