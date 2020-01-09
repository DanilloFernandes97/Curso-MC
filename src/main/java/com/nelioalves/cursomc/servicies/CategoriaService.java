package com.nelioalves.cursomc.servicies;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

import com.nelioalves.cursomc.domain.Categoria;
import com.nelioalves.cursomc.repositories.CategoriaRepository;
import com.nelioalves.cursomc.servicies.exceptions.ObjectNotFoundException;

@Service
public class CategoriaService {

	@Autowired // Com a anotação Autowired, essa dependência automaticamente vai ser instânciada
	// pelo spring, pelo mecanismo de injeção de dependência ou inversão de controle.
	private CategoriaRepository categoriaRepository;

	public Categoria buscar(Integer id) throws ObjectNotFoundException {
		
		Optional<Categoria> optional = categoriaRepository.findById(id);
		
		return optional.orElseThrow(() -> new ObjectNotFoundException("Objeto não encontrado! Id: " + id + ", Tipo: " + Categoria.class.getName()));
		
	}
		
}
