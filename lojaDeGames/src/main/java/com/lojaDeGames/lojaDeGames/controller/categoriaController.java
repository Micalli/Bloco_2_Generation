package com.lojaDeGames.lojaDeGames.controller;

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

import com.lojaDeGames.lojaDeGames.model.Categoria;

import com.lojaDeGames.lojaDeGames.repository.categoriaRepository;

@RequestMapping("/categoria")
@CrossOrigin("*")
@RestController

public class categoriaController {
	
	@Autowired
	private categoriaRepository repository;
	
	@GetMapping
	public ResponseEntity<List<Categoria>> getAll()
	{
		return ResponseEntity.ok(repository.findAll());
	}
	
	@GetMapping("/{idCategoria}")
	public ResponseEntity<Categoria> getById(@PathVariable Long idCategoria)
	{
		return repository.findById(idCategoria).map(resp -> ResponseEntity.ok(resp))
				.orElse(ResponseEntity.notFound().build());
	
	}
	
	@GetMapping("/nome/{nome}")
	public ResponseEntity<List<Categoria>> getByCategoria(@PathVariable String Categoria)
	{
		return ResponseEntity.ok(repository.findAllByCategoriaContainingIgnoreCase(Categoria));
	}
	
	@PostMapping
	public ResponseEntity<Categoria> post (@RequestBody Categoria categoria)
	{
		return ResponseEntity.status(HttpStatus.CREATED).body(repository.save(categoria));
	}
	
	@PutMapping
	public ResponseEntity<Categoria> put (@RequestBody Categoria categoria)
	{
		return ResponseEntity.status(HttpStatus.OK).body(repository.save(categoria));
	}
	
	@DeleteMapping("/{idCategoria}")
	public void delete(@PathVariable Long idCategoria)
	{
		repository.deleteById(idCategoria);
	}

}
