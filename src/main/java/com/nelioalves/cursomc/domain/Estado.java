package com.nelioalves.cursomc.domain;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

//Serializable é uma interface que diz que os objetos dessa classe podem ser convertidos em uma
//sequência de bytes, para gravar os dados em arquivos, trafegar em redes, etc.

@Entity // <-- Entidade do JPA.
public class Estado implements Serializable {
	
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY) // Define a estratégia de geração automática dos Ids.	
	private Integer id;
	
	private String nome;

	@OneToMany(mappedBy = "estado") // Um pra muitos (Um estado para muitas cidades). O mappedBy informa qual atributo da outra classe
	// que mapeou o @ManyToOne (o mapeamento reverso).
	private List<Cidade> cidades = new ArrayList<Cidade>();
	
	public Estado() {
		
	}
		
	public Estado(Integer id, String nome) {
		super();
		this.id = id;
		this.nome = nome;
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
	
	public List<Cidade> getCidades(){
		return cidades;
	}
	
	public void setCidades(List<Cidade> cidades) {
		this.cidades = cidades;
	}

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
		Estado other = (Estado) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
	
}
