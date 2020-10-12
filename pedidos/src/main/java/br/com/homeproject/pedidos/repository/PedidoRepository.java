package br.com.homeproject.pedidos.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.homeproject.pedidos.model.Pedido;

public interface PedidoRepository extends JpaRepository<Pedido, Integer> {

}
