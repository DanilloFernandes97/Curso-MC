package com.nelioalves.cursomc.resources;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController // Notação do SpringBoot para demarcar classes controladoras de REST.
@RequestMapping(value = "/categorias") // Notação do SpringBoot para demarcar o endpoint dessa classe.
public class CategoriaResource {

	@RequestMapping(method = RequestMethod.GET) // Notação do SpringBoot para determinar qual o verbo da requisição.	
	public String Lista() {
		return "Rest está funcionando!";
	}
	
}
