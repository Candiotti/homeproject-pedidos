package br.com.homeproject.pedidos.service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import br.com.homeproject.pedidos.dto.PedidoDTO;
import br.com.homeproject.pedidos.model.Cliente;
import br.com.homeproject.pedidos.model.Pedido;
import br.com.homeproject.pedidos.model.Produto;
import br.com.homeproject.pedidos.repository.ClienteRepository;
import br.com.homeproject.pedidos.repository.PedidoRepository;
import br.com.homeproject.pedidos.repository.ProdutoRepository;


@Service
public class PedidoService {

	@Autowired
	private PedidoRepository pedidoRepository;

	@Autowired
	private ClienteRepository clienteRepository;

	@Autowired
	private ProdutoRepository produtoRepository;

	public void adicionarNovoPedido(PedidoDTO pedidoDto) {
		Pedido pedido = preencherNovoPedido(pedidoDto);

		pedidoRepository.save(pedido);

		pedidoDto.setPedidoId(pedido.getId());
	}

	public Pedido preencherNovoPedido(PedidoDTO pedidoDto) {
		Pedido pedido = new Pedido();

		Optional<Cliente> cliente = clienteRepository.findById(pedidoDto.getClienteId());

		List<Produto> produtos = pedidoDto.getProdutosId().stream().map(i -> produtoRepository.getOne(i))
				.collect(Collectors.toList());

			pedido.setCliente(cliente.get());
			pedido.setProdutos(produtos);
			pedido.setValorTotal(pedidoDto.somarValorTotalPedido(produtos));

		return pedido;
	}
}