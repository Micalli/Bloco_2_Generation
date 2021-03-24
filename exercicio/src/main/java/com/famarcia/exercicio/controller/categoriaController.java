package com.famarcia.exercicio.controller;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.famarcia.exercicio.model.Categoria;
import com.famarcia.exercicio.repository.categoriaRepository;

@RequestMapping ("/categoria")
@CrossOrigin ("*")
@RestController
public class categoriaController {
	
	@Autowired
	private categoriaRepository repository;
	
	@GetMapping
	public ResponseEntity<List<Categoria>> getAll()
	{
		return ResponseEntity.ok(repository.findAll());
	}
	
	@GetMapping("/nome/{nome}")
	public ResponseEntity<List<Categoria>> getByName(@PathVariable String categoria)
	{
		if(repository.findAllByCategoriaContainingIgnoreCase(categoria).isEmpty())
		{
			return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
		}
		else
		{
			return ResponseEntity.status(HttpStatus.OK).build();
		}
	}
	
	@PostMapping
	public ResponseEntity<Categoria>post (@RequestBody Categoria categoria)
	{
		return ResponseEntity.status(HttpStatus.CREATED)
				.body(repository.save(categoria));
		
	}
	
	@PutMapping
	public ResponseEntity<Categoria> put (@RequestBody Categoria categoria)
	{
		return ResponseEntity.ok(repository.save(categoria));				
	}
	
	@DeleteMapping("/{idCategoria}")
	public void delete (@PathVariable long idCategoria)
	{
		repository.deleteById(idCategoria);
	}

}
