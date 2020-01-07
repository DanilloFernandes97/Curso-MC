package com.nelioalves.cursomc;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.nelioalves.cursomc.domain.Categoria;
import com.nelioalves.cursomc.repositories.CategoriaRepository;

@SpringBootApplication
// CommandLineRunner usado para fazer a aplicação executar alguma ação quando for iniciada.
public class CursomcApplication implements CommandLineRunner {

	@Autowired // @Autowired: vai ser criado automaticamente. 
	private CategoriaRepository categoriaRepository;
	
	public static void main(String[] args) {
		SpringApplication.run(CursomcApplication.class, args);
	}

	// Run, vai ser rodado quando a aplicação iniciar.
	@Override
	public void run(String... args) throws Exception {
		
		Categoria categoriaInformatica = new Categoria(null, "Informática");
		Categoria categoriaEscritorio = new Categoria(null, "Escritório");
		
		// Arrays.asList, cria um objeto array list e já itera eles com os objetos dos parâmetros.
		this.categoriaRepository.saveAll(Arrays.asList(categoriaInformatica, categoriaEscritorio));
		
		
	}

}
