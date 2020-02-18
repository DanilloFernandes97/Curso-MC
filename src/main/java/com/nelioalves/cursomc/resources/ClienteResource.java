package com.nelioalves.cursomc.resources;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.nelioalves.cursomc.domain.Cliente;
import com.nelioalves.cursomc.servicies.ClienteService;

@RestController // Notação do SpringBoot para demarcar classes controladoras de REST.
@RequestMapping(value = "/clientes") // Notação do SpringBoot para demarcar o endpoint dessa classe.
// As exceções não são tratadas diretamente aqui pois por convenção os métodos devem ser pequenos em controladores REST, por isso
// existe os "handlers" que são objetos que capturam a excessão e lançam o código HTTP correto. 
public class ClienteResource {

	@Autowired // Com a anotação Autowired, essa dependência automaticamente vai ser instânciada
	// pelo spring, pelo mecanismo de injeção de dependência ou inversão de controle.
	private ClienteService clienteService;
	
	// O 'method = RequestMethod.GET)' para determinar qual o verbo da requisição. @GetMapping, seria um atalho pra isso.
	// O 'value = "/{id}"' é pra demarcar que tem um parâmetro a ser passado.
	// Já o '@PathVariable' é para definir que o valor passado em {id} da URL vai nessa variável.
	// O retorno ResponseEntity (especial do spring) é pelo fato dele já encapsular/armazenar 
	// várias informações de uma reposta HTTP para um serviço REST
	@RequestMapping(value = "/{id}", method = RequestMethod.GET) 	
	public ResponseEntity<?> find(@PathVariable Integer id) { // Esse ? é para definir que pode  ser qlqr tipo, pois pode encontrar ou não encontrar.
			
		Cliente Cliente = this.clienteService.buscar(id);

		// Retorna o objeto especialista com códigos HTTPS resposta, etc, com no seu corpo o
		// objeto Cliente.
		return ResponseEntity.ok().body(Cliente); 
		
	}
	
}
