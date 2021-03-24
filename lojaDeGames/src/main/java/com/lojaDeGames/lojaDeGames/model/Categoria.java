package com.lojaDeGames.lojaDeGames.model;

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
@Table(name= "categoria")
public class Categoria {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY )
	private Long idCategoria;

	
	@NotNull
	@Size(max= 100)
	private String categoria;
	
	@NotNull
	@Size(max=20)
	private String digoufis;

	@OneToMany(mappedBy="categoria")
	@JsonIgnoreProperties("categoria")
	private List<Produto>produto;
	
	public Long getIdCategoria() {
		return idCategoria;
	}

	public void setIdCategoria(Long idCategoria) {
		this.idCategoria = idCategoria;
	}

	public String getCategoria() {
		return categoria;
	}

	public void setCategoria(String categoria) {
		this.categoria = categoria;
	}

	public String getDigoufis() {
		return digoufis;
	}

	public void setDigoufis(String digoufis) {
		this.digoufis = digoufis;
	}

	public List<Produto> getProduto() {
		return produto;
	}

	public void setProduto(List<Produto> produto) {
		this.produto = produto;
	}
	
	
	
}
