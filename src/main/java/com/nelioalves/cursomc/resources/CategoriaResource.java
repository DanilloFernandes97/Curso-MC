package com.nelioalves.cursomc.resources;



import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.nelioalves.cursomc.domain.Categoria;

@RestController // Notação do SpringBoot para demarcar classes controladoras de REST.
@RequestMapping(value = "/categorias") // Notação do SpringBoot para demarcar o endpoint dessa classe.
public class CategoriaResource {

	@RequestMapping(method = RequestMethod.GET) // Notação do SpringBoot para determinar qual o verbo da requisição.	
	public List<Categoria> Lista() {
		
		List<Categoria> list = new ArrayList<>();
		
		Categoria categoria1 = new Categoria(1, "Guitarras");
		
		list.add(categoria1);
		
		Categoria categoria2 = new Categoria(1, "Violões");		
				
		list.add(categoria2);
		
		return list;
	}
	
}
