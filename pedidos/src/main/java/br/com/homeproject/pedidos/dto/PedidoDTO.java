package br.com.homeproject.pedidos.dto;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import br.com.homeproject.pedidos.model.Produto;

public class PedidoDTO {

	private Integer clienteId;
	private Integer pedidoId;
	private List<Integer> produtosId = new ArrayList<>();
	private BigDecimal valorTotal = new BigDecimal(0);

	public Integer getClienteId() {
		return clienteId;
	}

	public void setClienteId(Integer clienteId) {
		this.clienteId = clienteId;
	}

	public Integer getPedidoId() {
		return pedidoId;
	}

	public void setPedidoId(Integer pedidoId) {
		this.pedidoId = pedidoId;
	}

	public List<Integer> getProdutosId() {
		return produtosId;
	}

	public void setProdutosId(List<Integer> produtosId) {
		this.produtosId = produtosId;
	}

	public BigDecimal getValorTotal() {
		return valorTotal;
	}

	public void setValorTotal(BigDecimal valorTotal) {
		this.valorTotal = valorTotal;
	}

	public BigDecimal somarValorTotalPedido(List<Produto> produtos) {
		for (Produto p : produtos) {
			setValorTotal(getValorTotal().add(p.getValor()));
		}

		return this.valorTotal;
	}
}
