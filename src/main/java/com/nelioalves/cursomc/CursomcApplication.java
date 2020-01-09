package com.nelioalves.cursomc;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.nelioalves.cursomc.domain.Categoria;
import com.nelioalves.cursomc.domain.Produto;
import com.nelioalves.cursomc.repositories.CategoriaRepository;
import com.nelioalves.cursomc.repositories.ProdutoRepository;

@SpringBootApplication
// CommandLineRunner usado para fazer a aplicação executar alguma ação quando for iniciada.
public class CursomcApplication implements CommandLineRunner {

	@Autowired // @Autowired: vai ser criado automaticamente. 
	private CategoriaRepository categoriaRepository;
	
	@Autowired // @Autowired: vai ser criado automaticamente. 
	private ProdutoRepository produtoRepository;	
	
	public static void main(String[] args) {
		SpringApplication.run(CursomcApplication.class, args);
	}

	// Run, vai ser rodado quando a aplicação iniciar.
	@Override
	public void run(String... args) throws Exception {
		
		Categoria categoriaInformatica = new Categoria(null, "Informática");
		Categoria categoriaEscritorio = new Categoria(null, "Escritório");

		Produto produtoComputador = new Produto(null, "Computador", 2.000);
		Produto produtoImpressora = new Produto(null, "Impressora", 800.00);
		Produto produtoMouse = new Produto(null, "Mouse", 80.00);		
		
		// Realiza as associações.
		categoriaInformatica.getProdutos().addAll(Arrays.asList(produtoComputador, produtoImpressora, produtoMouse));		
		categoriaEscritorio.getProdutos().addAll(Arrays.asList(produtoImpressora));
		
		produtoComputador.getCategorias().addAll(Arrays.asList(categoriaInformatica));
		produtoImpressora.getCategorias().addAll(Arrays.asList(categoriaInformatica, categoriaEscritorio));
		produtoMouse.getCategorias().addAll(Arrays.asList(categoriaInformatica));
		
		// Arrays.asList, cria um objeto array list e já itera eles com os objetos dos parâmetros.	
		this.categoriaRepository.saveAll(Arrays.asList(categoriaInformatica, categoriaEscritorio));		
		
		this.produtoRepository.saveAll(Arrays.asList(produtoComputador, produtoImpressora, produtoMouse));
		
	}

}
