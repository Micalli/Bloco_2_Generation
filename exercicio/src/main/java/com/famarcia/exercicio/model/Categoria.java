package com.famarcia.exercicio.model;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;


@Entity
@Table(name="categoria")
public class Categoria {
	
	@Id
	@GeneratedValue (strategy= GenerationType.IDENTITY)
	private long idCategoria;
	
	
	@NotNull
	@Size (min= 2, max=20)
	private String categoria;
	
	
	
	
	@OneToMany (mappedBy= "categoria")
	@JsonIgnoreProperties("categoria")
	private List<Produto> produto;

	public long getIdCategoria() {
		return idCategoria;
	}

	public void setIdCategoria(long idCategoria) {
		this.idCategoria = idCategoria;
	}

	
	

	public List<Produto> getProduto() {
		return produto;
	}

	public void setProduto(List<Produto> produto) {
		this.produto = produto;
	}

	public String getCategoria() {
		return categoria;
	}

	public void setCategoria(String categoria) {
		this.categoria = categoria;
	}
	

}
