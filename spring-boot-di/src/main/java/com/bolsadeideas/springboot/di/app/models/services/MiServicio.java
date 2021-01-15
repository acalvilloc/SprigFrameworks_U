package com.bolsadeideas.springboot.di.app.models.services;

//@Component("Servicio")
//@Primary
public class MiServicio implements IServicio {

	@Override
	public String operacion() {
		return "Ejecutando algún proceso bien cariñoso...";
	}
	
 
	
}
