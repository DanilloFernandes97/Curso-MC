package com.nelioalves.cursomc;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.nelioalves.cursomc.domain.Categoria;
import com.nelioalves.cursomc.domain.Cidade;
import com.nelioalves.cursomc.domain.Cliente;
import com.nelioalves.cursomc.domain.Endereco;
import com.nelioalves.cursomc.domain.Estado;
import com.nelioalves.cursomc.domain.Produto;
import com.nelioalves.cursomc.domain.enums.TipoCliente;
import com.nelioalves.cursomc.repositories.CategoriaRepository;
import com.nelioalves.cursomc.repositories.CidadeRepository;
import com.nelioalves.cursomc.repositories.ClienteRepository;
import com.nelioalves.cursomc.repositories.EnderecoRepository;
import com.nelioalves.cursomc.repositories.EstadoRepository;
import com.nelioalves.cursomc.repositories.ProdutoRepository;

@SpringBootApplication
// CommandLineRunner usado para fazer a aplicação executar alguma ação quando for iniciada.
public class CursomcApplication implements CommandLineRunner {

	@Autowired // @Autowired: vai ser criado automaticamente. 
	private CategoriaRepository categoriaRepository;
	
	@Autowired // @Autowired: vai ser criado automaticamente. 
	private ProdutoRepository produtoRepository;	
	
	@Autowired // @Autowired: vai ser criado automaticamente.
	private EstadoRepository estadoRepository;
	
	@Autowired // @Autowired: vai ser criado automaticamente.
	private CidadeRepository cidadeRepository;
	
	@Autowired // @Autowired: vai ser criado automaticamente.
	private ClienteRepository clienteRepository;
	
	@Autowired // @Autowired: vai ser criado automaticamente.
	private EnderecoRepository enderecoRepository;
	
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
		
		// As associações (entidade PRODUTO_CATEGORIA será populada automaticamente.)
		
		Estado estadoMinasGerais = new Estado(null, "Minas Gerais");
		Estado estadoSaoPaulo = new Estado(null, "São Paulo");
		
		Cidade cidadeUberlandia = new Cidade(null, "Uberlândia", estadoMinasGerais);
		Cidade cidadeSaoPaulo = new Cidade(null, "São Paulo", estadoSaoPaulo);
		Cidade cidadeCampinas = new Cidade(null, "Campinas", estadoSaoPaulo);
		
		estadoMinasGerais.getCidades().addAll(Arrays.asList(cidadeUberlandia));
		
		estadoSaoPaulo.getCidades().addAll(Arrays.asList(cidadeSaoPaulo, cidadeCampinas));
	
		this.estadoRepository.saveAll(Arrays.asList(estadoMinasGerais, estadoSaoPaulo));
		this.cidadeRepository.saveAll(Arrays.asList(cidadeUberlandia, cidadeSaoPaulo, cidadeCampinas));
		
		Cliente cliente = new Cliente(null, "Maria Silva", "maria@gmail.com", "36378912377", TipoCliente.PESSOAFISICA);
		
		cliente.getTelefones().addAll(Arrays.asList("27363323", "93838393"));
		
		Endereco endereco1 = new Endereco(null, "Rua das Flores", "310", "Apto 203", "Jardim", "38220834", cliente, cidadeUberlandia);
		
		Endereco endereco2 = new Endereco(null, "Avenida Matos", "105", "Sala 800", "Centro", "38777012", cliente, cidadeSaoPaulo);
		
		cliente.getEnderecos().addAll(Arrays.asList(endereco1, endereco2));
		
		this.clienteRepository.saveAll(Arrays.asList(cliente));
		
		this.enderecoRepository.saveAll(Arrays.asList(endereco1, endereco2));
		
	}

}
