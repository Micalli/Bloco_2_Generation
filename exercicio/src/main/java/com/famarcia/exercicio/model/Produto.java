package com.famarcia.exercicio.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;


@Entity
@Table(name="produto")
public class Produto {
	
	@Id
	@GeneratedValue
	private Long idProduto;
	
	@NotNull
	@Size (min= 2, max=20)
	private String nome;
	
	
	@NotNull
	private Long preco;
	
	@NotNull
	private boolean generico;
	
	@NotNull
	private boolean tarjaPreta;
	
	@ManyToOne
	@JsonIgnoreProperties ("produto")
	private Categoria categoria;

	public Long getIdProduto() {
		return idProduto;
	}

	public void setIdProduto(Long idProduto) {
		this.idProduto = idProduto;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Long getPreco() {
		return preco;
	}

	public void setPreco(Long preco) {
		this.preco = preco;
	}

	public boolean isGenerico() {
		return generico;
	}

	public void setGenerico(boolean generico) {
		this.generico = generico;
	}

	public boolean isTarjaPreta() {
		return tarjaPreta;
	}

	public void setTarjaPreta(boolean tarjaPreta) {
		this.tarjaPreta = tarjaPreta;
	}

	public Categoria getCategoria() {
		return categoria;
	}

	public void setCategoria(Categoria categoria) {
		this.categoria = categoria;
	}
	
	
	
	
	
	

}
