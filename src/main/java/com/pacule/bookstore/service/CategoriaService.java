package com.pacule.bookstore.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;
import com.pacule.bookstore.dominio.Categoria;
import com.pacule.bookstore.dtos.CategoriaDTO;
import com.pacule.bookstore.repository.CategoriaRepository;
import com.pacule.bookstore.service.exceptions.ObjectNotFoundException;

@Service
public class CategoriaService {

	@Autowired
	private CategoriaRepository repository;
	public Categoria findById(Integer id) {
		Optional<Categoria> obj=repository.findById(id);
		return obj.orElseThrow(()-> new ObjectNotFoundException("Objeto nao encontrdo id: "+id+" Tipo: "+ Categoria.class.getName() ));
	}
	
	public List<Categoria> findAll(){
		return repository.findAll();
		
	}
	public Categoria create(Categoria obj) {
		obj.setId(null);
		return repository.save(obj);
	}

	public Categoria create(Integer id, CategoriaDTO objDTO) {
		Categoria obj= findById(id);
		obj.setNome(objDTO.getNome());
		obj.setDescricao(objDTO.getDescricao());
		return repository.save(obj);
	}

	public void delete(Integer id) {
		findById(id);
		try {
			repository.deleteById(id);
		} catch (DataIntegrityViolationException e) {
			throw new DataIntegrityViolationException("Categoria nao pode ser deletada, \n possue livros associados");
		}
		
	}
	
	
}
