package br.com.homeproject.pedidos.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.homeproject.pedidos.model.Entrega;

public interface EntregaRepository extends JpaRepository<Entrega, Integer> {

}
