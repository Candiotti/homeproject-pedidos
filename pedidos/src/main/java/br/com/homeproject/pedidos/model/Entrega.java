package br.com.homeproject.pedidos.model;

public class Entrega {

	private Integer id;
	private Pedido pedido;
	private EnderecoEntrega endereco;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Pedido getPedido() {
		return pedido;
	}

	public void setPedido(Pedido pedido) {
		this.pedido = pedido;
	}

	public EnderecoEntrega getEndereco() {
		return endereco;
	}

	public void setEndereco(EnderecoEntrega endereco) {
		this.endereco = endereco;
	}
}
