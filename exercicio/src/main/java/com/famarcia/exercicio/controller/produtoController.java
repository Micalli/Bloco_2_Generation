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


import com.famarcia.exercicio.model.Produto;
import com.famarcia.exercicio.repository.produtoRepository;

@RequestMapping("/produto")
@CrossOrigin ("*")
@RestController
public class produtoController {
	
	@Autowired
	private produtoRepository repository;
	
	@GetMapping
	public ResponseEntity<List<Produto>> getAll()
	{
		return ResponseEntity.ok(repository.findAll());
	}
	
	@GetMapping("/{idProduto}")
	public ResponseEntity<List<Produto>> getById(@PathVariable long idProduto)
	{
		if(repository.findById(idProduto).isEmpty())
			{
			  return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
			}
		else
			{
				return ResponseEntity.status(HttpStatus.OK).build();
			}
	}
	
	@PostMapping
	public ResponseEntity<Produto> post(@RequestBody Produto produto)
	{
		return ResponseEntity.status(HttpStatus.CREATED)
				.body(repository.save(produto));
	}
	
	@PutMapping
	public ResponseEntity<Produto> put(@RequestBody Produto produto)
	{
		return ResponseEntity.ok(repository.save(produto));			
	}
	
	@DeleteMapping("/{idProduto}")
	public void delete (@PathVariable long idProduto)
	{
		repository.deleteById(idProduto);
	}
	
	
	
}
