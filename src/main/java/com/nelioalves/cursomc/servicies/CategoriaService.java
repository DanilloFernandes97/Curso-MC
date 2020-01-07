package com.nelioalves.cursomc.servicies;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

import com.nelioalves.cursomc.domain.Categoria;
import com.nelioalves.cursomc.repositories.CategoriaRepository;

@Service
public class CategoriaService {

	@Autowired // Com a anotação Autowired, essa dependência automaticamente vai ser instânciada
	// pelo spring, pelo mecanismo de injeção de dependência ou inversão de controle.
	private CategoriaRepository categoriaRepository;
	
	public Categoria buscar(Integer id) {
		
		Optional<Categoria> categoria = this.categoriaRepository.findById(id);	
		
		return categoria.orElse(null);
		
	}
	
}
