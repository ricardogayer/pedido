package com.mwave.pedido.service;

import com.mwave.pedido.model.Pedido;
import com.mwave.pedido.model.PedidoItem;
import com.mwave.pedido.repository.PedidoItemRepository;
import com.mwave.pedido.repository.PedidoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class PedidoService {

    @Autowired
    PedidoRepository pedidoRepository;

    @Autowired
    PedidoItemRepository pedidoItemRepository;

    public Pedido createPedido(Pedido pedido) {

        Pedido p = pedidoRepository.save(pedido);

        return p;
    }

    @Transactional
    public void adicionaPedidoItem(Pedido pedido, PedidoItem pedidoItem) {
        Pedido pedidoEncontrado = new Pedido();
        Optional<Pedido> p = pedidoRepository.findById(pedido.getId());

        if (p.isPresent()) {
            pedidoEncontrado = p.get();
        } else {
            pedidoEncontrado = pedidoRepository.save(pedido);
        }

        pedidoItemRepository.save(pedidoItem);

        List<PedidoItem> itens = new ArrayList<>();
        itens.add(pedidoItem);

        pedido.setPedidoItens(itens);

        pedidoRepository.save(pedido);
    }

}
