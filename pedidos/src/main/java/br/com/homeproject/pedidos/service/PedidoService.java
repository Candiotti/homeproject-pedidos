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
import br.com.homeproject.pedidos.exception.PedidoException;
import br.com.homeproject.pedidos.components.PedidoSender;

@Service
public class PedidoService {

	@Autowired
	private PedidoRepository pedidoRepository;

	@Autowired
	private ClienteRepository clienteRepository;

	@Autowired
	private ProdutoRepository produtoRepository;

	@Autowired
	private PedidoSender pedidoSender;

	public void adicionarNovoPedido(PedidoDTO pedidoDto) {
		Pedido pedido = preencherNovoPedido(pedidoDto);

		pedidoRepository.save(pedido);

		pedidoDto.setPedidoId(pedido.getId());

		pedidoSender.enviarParaFila(pedidoDto);
	}

	public Pedido preencherNovoPedido(PedidoDTO pedidoDto) {
		Pedido pedido = new Pedido();

		Optional<Cliente> cliente = clienteRepository.findById(pedidoDto.getClienteId());

		List<Produto> produtos = pedidoDto.getProdutosId().stream().map(i -> produtoRepository.getOne(i))
				.collect(Collectors.toList());

		if (cliente.isPresent()) {
			pedido.setCliente(cliente.get());
		} else {
			throw new PedidoException("Cliente não encontrado!");
		}

		if (!produtos.isEmpty()) {
			pedido.setProdutos(produtos);
			pedido.setValorTotal(pedidoDto.somarValorTotalPedido(produtos));
		} else {
			throw new PedidoException("Lista de produtos vazia!");
		}

		return pedido;
	}
}