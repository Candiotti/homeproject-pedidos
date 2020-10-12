package br.com.homeproject.pedidos.model;

import java.math.BigDecimal;

public class Produto {

	private Integer id;
	private String nome;
	private BigDecimal valor;

	public Produto() {
	}

	public Produto(Integer id) {
		this.id = id;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public BigDecimal getValor() {
		return valor;
	}

	public void setValor(BigDecimal valor) {
		this.valor = valor;
	}
}
