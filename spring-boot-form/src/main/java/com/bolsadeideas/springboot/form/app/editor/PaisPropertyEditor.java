package com.bolsadeideas.springboot.form.app.editor;

import java.beans.PropertyEditorSupport;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.bolsadeideas.springboot.form.app.services.PaisService;

@Component
public class PaisPropertyEditor extends PropertyEditorSupport{

	@Autowired
	private PaisService service;
	
	@Override
	public void setAsText(String id) throws IllegalArgumentException {
		try {
				Integer idInt = Integer.parseInt(id);
				this.setValue(service.obtenerPorId(idInt));
			} catch(NumberFormatException e) {
				setValue(null);
		}
	}
}
