package br.com.homeproject.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.homeproject.pedidos.model.Produto;

public interface ProdutoRepository extends JpaRepository<Produto, Integer> {

}
