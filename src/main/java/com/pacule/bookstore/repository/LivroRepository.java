package com.pacule.bookstore.repository;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.pacule.bookstore.dominio.Livro;

@Repository
public interface LivroRepository extends JpaRepository<Livro, Integer> {

	@Query(value ="SELECT * FROM livro l WHERE l.categoria_id =:id_cat", nativeQuery=true)
	List<Livro> findAllByCategoria(@Param("id_cat") Integer id_cat);
	

}
