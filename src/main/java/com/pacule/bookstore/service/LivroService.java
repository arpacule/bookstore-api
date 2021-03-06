package com.pacule.bookstore.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pacule.bookstore.dominio.Categoria;
import com.pacule.bookstore.dominio.Livro;
import com.pacule.bookstore.repository.LivroRepository;
import com.pacule.bookstore.service.exceptions.ObjectNotFoundException;

@Service
public class LivroService {

	@Autowired
	private LivroRepository repository;
	@Autowired
	private CategoriaService categoriaservice;

	public Livro findById(Integer id) {
		Optional<Livro> obj = repository.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException(
				"Objeto nao encontrdo id: " + id + " Tipo: " + Livro.class.getName()));
	}

	public List<Livro> findAll(Integer id_cat) {
		categoriaservice.findById(id_cat);
		return repository.findAllByCategoria(id_cat);
	}

	public Livro update(Integer id, Livro obj) {
		Livro newObj = findById(id);
		UpdateData(newObj, obj);
		return repository.save(newObj);
	}

	private void UpdateData(Livro newObj, Livro obj) {
		newObj.setTitulo(obj.getTitulo());
		newObj.setTexto(obj.getTexto());
		newObj.setNome_autor(obj.getNome_autor());

	}

	public Livro create(Integer id_cat, Livro obj) {
		obj.setId(null);
		Categoria cat = categoriaservice.findById(id_cat);
		obj.setCategoria(cat);
		return repository.save(obj);
	}

	public void delete(Integer id) {
		Livro obj=findById(id);
		repository.delete(obj);
	}
}
