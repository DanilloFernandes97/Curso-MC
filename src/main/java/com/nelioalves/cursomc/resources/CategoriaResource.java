package com.nelioalves.cursomc.resources;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.nelioalves.cursomc.domain.Categoria;
import com.nelioalves.cursomc.servicies.CategoriaService;

@RestController // Notação do SpringBoot para demarcar classes controladoras de REST.
@RequestMapping(value = "/categorias") // Notação do SpringBoot para demarcar o endpoint dessa classe.
// As exceções não são tratadas diretamente aqui pois por convenção os métodos devem ser pequenos em controladores REST, por isso
// existe os "handlers" que são objetos que capturam a excessão e lançam o código HTTP correto. 
public class CategoriaResource {

	@Autowired // Com a anotação Autowired, essa dependência automaticamente vai ser instânciada
	// pelo spring, pelo mecanismo de injeção de dependência ou inversão de controle.
	private CategoriaService CategoriaService;
	
	// O 'method = RequestMethod.GET)' para determinar qual o verbo da requisição.
	// O 'value = "/{id}"' é pra demarcar que tem um parâmetro a ser passado.
	// Já o '@PathVariable' é para definir que o valor passado em {id} da URL vai nessa variável.
	// O retorno ResponseEntity (especial do spring) é pelo fato dele já encapsular/armazenar 
	// várias informações de uma reposta HTTP para um serviço REST
	@RequestMapping(value = "/{id}", method = RequestMethod.GET) 	
	public ResponseEntity<?> find(@PathVariable Integer id) { // Esse ? é para definir que pode  ser qlqr tipo, pois pode encontrar ou não encontrar.
			
		Categoria categoria = this.CategoriaService.buscar(id);

		// Retorna o objeto especialista com códigos HTTPS resposta, etc, com no seu corpo o
		// objeto categoria.
		return ResponseEntity.ok().body(categoria); 
		
	}
	
}
