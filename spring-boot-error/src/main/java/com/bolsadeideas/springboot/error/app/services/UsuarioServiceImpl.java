package com.bolsadeideas.springboot.error.app.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.bolsadeideas.springboot.error.app.models.domain.Usuario;

@Service
public class UsuarioServiceImpl implements UsuarioService {

	private List<Usuario> lista;
	
	public UsuarioServiceImpl() {
		this.lista = new ArrayList<>();
		this.lista.add(new Usuario(1,"Juan","Gutierritos"));
		this.lista.add(new Usuario(2,"Jazmin","Hernández"));
		this.lista.add(new Usuario(3,"Rosa","De la Rosa"));
		this.lista.add(new Usuario(4,"Andrea","Vieyra"));
	}
	@Override
	public List<Usuario> listar() {
		// TODO Auto-generated method stub
		return this.lista;
	}

	@Override
	public Usuario obtenerPorId(Integer id) {
		Usuario usuario = null;
		for (Usuario u :this.lista)
			if(u.getId().equals(id)) {
				usuario=u;
				break;
			}
		return usuario;
	}
	
	@Override
	public Optional<Usuario> obtenerPorIdOptional(Integer id) {
		Usuario usuario = this.obtenerPorId(id);
		return Optional.ofNullable(usuario);
	}

}
