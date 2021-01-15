package com.bolsadeideas.springboot.di.app.models.domain;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.context.annotation.RequestScope;
import org.springframework.web.context.annotation.SessionScope;

@Component
@SessionScope
public class Facturar implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -2548943924388610931L;
	@Value("${factura.desc}")
	private String descripcion;
	@Autowired
	private Cliente cliente;
	@Autowired
	private List<ItemFactura> items;

	@PostConstruct
	public void inicializar() {
		cliente.setNombre(cliente.getNombre().concat(" Arcadio"));
		
		descripcion = descripcion.concat(" del cliente ").concat(cliente.getNombre());
	}
	
	@PreDestroy
	public void destruir() {
		System.out.println("Factura destruida: ".concat(descripcion));
	}
	
	public Cliente getCliente() {
		return cliente;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public List<ItemFactura> getItems() {
		return items;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public void setDescripcion(String descricion) {
		this.descripcion = descricion;
	}

	public void setItems(List<ItemFactura> items) {
		this.items = items;
	}
	
	

}
