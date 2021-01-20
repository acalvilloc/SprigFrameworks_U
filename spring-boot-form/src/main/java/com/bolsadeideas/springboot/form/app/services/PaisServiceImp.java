package com.bolsadeideas.springboot.form.app.services;

import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Service;

import com.bolsadeideas.springboot.form.app.models.domain.Pais;

@Service
public class PaisServiceImp implements PaisService {

	private List<Pais> lista;
	public PaisServiceImp() {
		lista = Arrays.asList(new Pais(1,"ES","España"),
				new Pais(2,"MX","México"),
				new Pais(3,"IN","Inglaterra"),
				new Pais(4,"PU","Perú"),
				new Pais(5,"CO","Colombia"));
	} 	
	
	@Override
	public List<Pais> listar() {
		// TODO Auto-generated method stub
		return lista;
	}

	@Override
	public Pais obtenerPorId(Integer id) {
		Pais resultado = null;
		for (Pais pais: this.lista)
			if(id==pais.getId()) {
				resultado=pais;
				break;
			}
		return resultado;
	}

}
