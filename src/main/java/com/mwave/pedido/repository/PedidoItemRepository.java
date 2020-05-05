package com.mwave.pedido.repository;

import com.mwave.pedido.model.PedidoItem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PedidoItemRepository extends JpaRepository<PedidoItem,Long> {

}
