package com.bolsadeideas.springboot.di.app.models.services;

import org.springframework.stereotype.Component;

@Component("MiServicioS")
public class MiServicio implements IServicio {

	@Override
	public String operacion() {
		return "Ejecutando algún proceso bien cariñoso...";
	}
}
