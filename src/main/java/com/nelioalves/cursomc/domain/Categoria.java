package com.nelioalves.cursomc.domain;

import java.io.Serializable;

// Serializable é uma interface que diz que os objetos dessa classe podem ser convertidos em uma
// sequência de bytes, para gravar os dados em arquivos, trafegar em redes, etc.
public class Categoria implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	private Integer Id;
	private String Nome;
	
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