package com.famarcia.exercicio.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.famarcia.exercicio.model.Categoria;

@Repository
public interface categoriaRepository extends JpaRepository<Categoria, Long> {
	
	
	public List<Categoria> findAllByCategoriaContainingIgnoreCase(String categoria);
	
	

}
