package br.com.homeproject.pedidos.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.homeproject.pedidos.dto.PedidoDTO;
import br.com.homeproject.pedidos.model.Entrega;
import br.com.homeproject.pedidos.repository.EnderecoEntregaRepository;
import br.com.homeproject.pedidos.repository.EntregaRepository;
import br.com.homeproject.pedidos.repository.PedidoRepository;

@Service
public class EntregaService {

	@Autowired
	private PedidoRepository pedidoRepository;

	@Autowired
	private EntregaRepository entregaRepository;

	@Autowired
	private EnderecoEntregaRepository enderecoEntregaRepository;

	public void adicionarNovaEntrega(PedidoDTO pedidoDto) {
		Entrega entrega = new Entrega();

		entrega.setEndereco(enderecoEntregaRepository.findByClienteId(pedidoDto.getClienteId()));
		entrega.setPedido(pedidoRepository.getOne(pedidoDto.getPedidoId()));

		entregaRepository.save(entrega);
	}
}
