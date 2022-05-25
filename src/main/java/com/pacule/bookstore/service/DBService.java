package com.pacule.bookstore.service;

import java.util.Arrays;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.pacule.bookstore.dominio.Categoria;
import com.pacule.bookstore.dominio.Livro;
import com.pacule.bookstore.repository.CategoriaRepository;
import com.pacule.bookstore.repository.LivroRepository;

@Service
public class DBService {

	@Autowired
	private CategoriaRepository categoriaRepository;
	@Autowired
	private LivroRepository livroRepository;
	
	public void instanciaBasedeDados(){
		
		Categoria cat1 = new Categoria(null, "informatica", "Livros de IT");
		Categoria cat2 = new Categoria(null, "Tecnologias Renovaveis", "Livros de TI");
		Categoria cat3 = new Categoria(null, "inteligencia Artificial", "Livros de LA");
		
		Livro l1 = new Livro(null, "As Mentiras que os homens Contam", "Arlindo Pacule", "Spring Boot Teste", cat1);
		Livro l2 = new Livro(null, "As 4 maravilhas do mundo", "Arlindo Pacule", "Spring Boot Teste", cat1);
		Livro l3 = new Livro(null, "Os Animais mais fantasticos", "Arlindo Pacule", "Spring Boot Teste", cat2);
		Livro l4 = new Livro(null, "A tranfiguracao do Homem", "Arlindo Pacule", "Spring Boot Teste", cat2);
		
		cat1.getLivros().addAll(Arrays.asList(l1,l2));
		cat2.getLivros().addAll(Arrays.asList(l3,l4));
		
		this.categoriaRepository.saveAll(Arrays.asList(cat1,cat2,cat3));
		this.livroRepository.saveAll(Arrays.asList(l1,l2,l3,l4));
		
		
	}
	
	
	
}
