package com.bolsadeideas.springboot.di.app.models.services;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

@Component("Servicio")
@Primary
public class MiServicio implements IServicio {

	@Override
	public String operacion() {
		return "Ejecutando algún proceso bien cariñoso...";
	}
	
 
	
}
