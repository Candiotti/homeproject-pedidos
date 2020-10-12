package br.com.homeproject.pedidos.components;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

import br.com.homeproject.pedidos.dto.PedidoDTO;

@Component
public class PedidoReceiver {

	@RabbitListener(queues = "pedidos.queue")
	public void receivedMessage(PedidoDTO pedidoDto) {
	}
}
