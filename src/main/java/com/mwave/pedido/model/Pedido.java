package com.mwave.pedido.model;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Pedido {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "nr_pedido")
    private Long id;
    private LocalDate dtPedido;
    private Float vrTotalPedido;

    @OneToMany(mappedBy = "pedido")
    private List<PedidoItem> pedidoItens = new ArrayList<>();


    public Pedido() {
    }

    public List<PedidoItem> getPedidoItens() {
        return pedidoItens;
    }

    public void setPedidoItens(List<PedidoItem> pedidoItens) {
        this.pedidoItens = pedidoItens;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public LocalDate getDtPedido() {
        return dtPedido;
    }

    public void setDtPedido(LocalDate dtPedido) {
        this.dtPedido = dtPedido;
    }

    public Float getVrTotalPedido() {
        return vrTotalPedido;
    }

    public void setVrTotalPedido(Float vrTotalPedido) {
        this.vrTotalPedido = vrTotalPedido;
    }
}
