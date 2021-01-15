package com.bolsadeideas.springboot.di.app;

import java.util.Arrays;
import java.util.List;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.context.annotation.PropertySource;

import com.bolsadeideas.springboot.di.app.models.domain.ItemFactura;
import com.bolsadeideas.springboot.di.app.models.domain.Producto;
import com.bolsadeideas.springboot.di.app.models.services.IServicio;
import com.bolsadeideas.springboot.di.app.models.services.MiServicio;
import com.bolsadeideas.springboot.di.app.models.services.MiServicioComplejo;

@Configuration
@PropertySource(value = "classpath:application.properties")
public class AppConfig {

	@Bean("ServicioSimple")
	public IServicio registrarServicio() {
		return new MiServicio();
	}
	
	@Bean("ServicioComplejo")
	@Primary
	public IServicio registrarServicioComplejo() {
		return new MiServicioComplejo();
	}
	
	@Bean("FacturaFlores")
	public List<ItemFactura> registrarItems(){
		Producto p1 = new Producto("Flores", 31416);
		Producto p2 = new Producto("Ajos", 27182);
		
		ItemFactura l1 = new ItemFactura(p1, 14);
		ItemFactura l2 = new ItemFactura(p2, 2);
		
		return Arrays.asList(l1,l2);
	}
	

	@Primary
	@Bean("FacturaRopa")
	public List<ItemFactura> registrarItemsRopa(){
		Producto p1 = new Producto("Trench Coat", 1234);
		Producto p2 = new Producto("Calcetines", 1123);
		Producto p3 = new Producto("Camisa", 23);
		Producto p4 = new Producto("Cuello tortuga", 1597);
		
		ItemFactura l1 = new ItemFactura(p1, 2);
		ItemFactura l2 = new ItemFactura(p2, 5);
		ItemFactura l3 = new ItemFactura(p3, 6);
		ItemFactura l4 = new ItemFactura(p4, 1);
		
		
		
		return Arrays.asList(l1,l2,l3,l4);
	}
	
}
