package br.com.homeproject.pedidos.components;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import br.com.homeproject.pedidos.dto.PedidoDTO;
import br.com.homeproject.pedidos.service.EntregaService;

@Component
public class PedidoReceiver {

	@Autowired
	private EntregaService entregaService;

	@RabbitListener(queues = "pedidos.queue")
	public void receivedMessage(PedidoDTO pedidoDto) {
		entregaService.adicionarNovaEntrega(pedidoDto);
	}
}
