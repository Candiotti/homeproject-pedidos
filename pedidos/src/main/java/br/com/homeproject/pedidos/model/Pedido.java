package br.com.homeproject.pedidos.model;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class Pedido {

	private Integer id;
	private Cliente cliente;
	private List<Produto> produtos = new ArrayList<>();
	private BigDecimal valorTotal = new BigDecimal(0);

	public Pedido() {
	}

	public Pedido(Cliente cliente, List<Produto> produtos, BigDecimal valorTotal) {
		this.cliente = cliente;
		this.produtos = produtos;
		this.valorTotal = valorTotal;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public List<Produto> getProdutos() {
		return produtos;
	}

	public void setProdutos(List<Produto> produtos) {
		this.produtos = produtos;
	}

	public BigDecimal getValorTotal() {
		return valorTotal;
	}

	public void setValorTotal(BigDecimal valorTotal) {
		this.valorTotal = valorTotal;
	}
}
