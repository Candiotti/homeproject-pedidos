package br.com.homeproject.pedidos.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.homeproject.pedidos.model.Cliente;

public interface ClienteRepository extends JpaRepository<Cliente, Integer> {

}
