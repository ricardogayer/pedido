package com.mwave.pedido.repository;

import com.mwave.pedido.model.Produto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ProdutoRepository extends JpaRepository<Produto,Long> {

    Optional<Produto> findByCdProduto(Long cdProduto);

}
