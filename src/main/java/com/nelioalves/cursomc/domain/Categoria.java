package com.nelioalves.cursomc.domain;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

import com.fasterxml.jackson.annotation.JsonManagedReference;

// Serializable é uma interface que diz que os objetos dessa classe podem ser convertidos em uma
// sequência de bytes, para gravar os dados em arquivos, trafegar em redes, etc.

@Entity // <-- Entidade do JPA.
public class Categoria implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY) // Define a estratégia de geração automática dos Ids.
	private Integer Id;
	
	private String Nome;
	
	// Imita o mapeamento de muitos p/ muitos feito na entidade CATEGORIA, nesse caso o foi feito
	// na classe produto.
	@ManyToMany(mappedBy = "categorias") 
	@JsonManagedReference // Resolvendo o problema da referência cíclica entre categoria e produtos na hora de serializar os objetos,
	// se coloca essa notação para informar que será uma referência gerenciado pelo JSON.  
	private List<Produto> produtos = new ArrayList<>();
	
	public Categoria() {
		
	}

	public Categoria(Integer id, String nome) {
		super();
		this.Id = id;
		this.Nome = nome;
	}

	public Integer getId() {
		return Id;
	}

	public void setId(Integer id) {
		Id = id;
	}

	public String getNome() {
		return Nome;
	}

	public void setNome(String nome) {
		Nome = nome;
	}

	public List<Produto> getProdutos() {
		return produtos;
	}

	public void setProdutos(List<Produto> produtos) {
		this.produtos = produtos;
	}
	
	// Para comparar pelo conteúdo e não pelo ponteiro.
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((Id == null) ? 0 : Id.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Categoria other = (Categoria) obj;
		if (Id == null) {
			if (other.Id != null)
				return false;
		} else if (!Id.equals(other.Id))
			return false;
		return true;
	}
	
}
