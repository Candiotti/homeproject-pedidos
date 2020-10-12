package br.com.homeproject.pedidos.model;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

@Entity
public class Entrega {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	@OneToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "pedidoId")
	private Pedido pedido;

	@OneToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "enderecoEntregaId")
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
