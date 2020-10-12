package br.com.homeproject.pedidos.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.homeproject.pedidos.model.EnderecoEntrega;

public interface EnderecoEntregaRepository extends JpaRepository<EnderecoEntrega, Integer> {

	EnderecoEntrega findByClienteId(Integer clienteId);
}
