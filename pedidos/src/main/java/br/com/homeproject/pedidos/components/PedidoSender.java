package br.com.homeproject.pedidos.components;

import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import br.com.homeproject.pedidos.dto.PedidoDTO;

@Component
public class PedidoSender {

	@Autowired
	private AmqpTemplate rabbitTemplate;

	public void enviarParaFila(PedidoDTO pedidoDto) {
		rabbitTemplate.convertAndSend("exchange", "routingkey", pedidoDto);
	}
}
