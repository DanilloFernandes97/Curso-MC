package com.nelioalves.cursomc.domain;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;

import com.fasterxml.jackson.annotation.JsonBackReference;

@Entity
public class Produto implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY) // Define a estratégia de geração automática dos Ids.
	private Integer id;
	private String nome;
	private Double Preco;
	
	@ManyToMany // Especifíca que a relação da lista categoria com o produto é muito pra muito.
	// @JoinTable: Define que ela vai a tabela que vai fazer a tabela de muitos pra muitos (quem vai guardar o id dos dois lados).
	// A entidade PRODUTO_CATEGORIA será criada automaticamente.
	@JoinTable(name = "PRODUTO_CATEGORIA", 
	    joinColumns = @JoinColumn(name = "produto_id"), // Chave estrangeira dentro da classe produto.
	    inverseJoinColumns = @JoinColumn(name = "categoria_id") // Chave estrangeira da categoria. 
	)
	@JsonBackReference // Do lado outro da associação, já foram buscados os objetos (notação @JsonManagedReference na categoria), então ele omite 
	// a lista de categorias para cada produto na serialização.
	private List<Categoria> categorias = new ArrayList<>();

	public Produto() {
		
	}
	
	public Produto(Integer id, String nome, Double preco) {
		super();
		this.id = id;
		this.nome = nome;
		Preco = preco;
	}

	public Integer getId() {
		return id;
	}
	
	public void setId(Integer id) {
		this.id = id;
	}
	
	public String getNome() {
		return nome;
	}
	
	public void setNome(String nome) {
		this.nome = nome;
	}
	
	public Double getPreco() {
		return Preco;
	}
	
	public void setPreco(Double preco) {
		Preco = preco;
	}
	
	public List<Categoria> getCategorias() {
		return categorias;
	}
	
	public void setCategorias(List<Categoria> categorias) {
		this.categorias = categorias;
	}

	// Para comparar pelo conteúdo e não pelo ponteiro.	
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
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
		Produto other = (Produto) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}


	
}
