package br.com.homeproject.pedidos.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import br.com.homeproject.pedidos.dto.PedidoDTO;
import br.com.homeproject.pedidos.service.PedidoService;


@RestController
@RequestMapping("/pedido")
public class PedidoController {

	@Autowired
	private PedidoService service;

	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public void criar(@RequestBody PedidoDTO pedidoDto) {
		service.adicionarNovoPedido(pedidoDto);
	}
}
