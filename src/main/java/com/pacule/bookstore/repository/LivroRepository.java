package com.pacule.bookstore.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.pacule.bookstore.dominio.Livro;

@Repository
public interface LivroRepository extends JpaRepository<Livro, Integer> {

}
