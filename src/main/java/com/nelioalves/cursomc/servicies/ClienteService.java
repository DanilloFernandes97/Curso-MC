package com.nelioalves.cursomc.servicies;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

import com.nelioalves.cursomc.domain.Cliente;
import com.nelioalves.cursomc.repositories.ClienteRepository;
import com.nelioalves.cursomc.servicies.exceptions.ObjectNotFoundException;

@Service
public class ClienteService {

	@Autowired // Com a anotação Autowired, essa dependência automaticamente vai ser instânciada
	// pelo spring, pelo mecanismo de injeção de dependência ou inversão de controle.
	private ClienteRepository clienteRepository;

	public Cliente buscar(Integer id) throws ObjectNotFoundException {
		
		Optional<Cliente> optional = clienteRepository.findById(id);
		
		return optional.orElseThrow(() -> new ObjectNotFoundException("Objeto não encontrado! Id: " + id + ", Tipo: " + Cliente.class.getName()));
		
	}
		
}
