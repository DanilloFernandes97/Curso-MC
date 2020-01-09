package com.nelioalves.cursomc.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.nelioalves.cursomc.domain.Categoria;
import com.nelioalves.cursomc.domain.Produto;

// Repository (também conhecida como DAO)

// JpaRepository: Interface específica do spring capaz de acessar os dados com base no tipo que
// você passar (no caso o objeto categoria) e o atributo identificador desse objeto.

@Repository
public interface ProdutoRepository extends JpaRepository<Produto, Integer> {

	
	
}
