package com.mwave.pedido.model;

import javax.persistence.*;
import javax.validation.constraints.DecimalMin;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Pedido {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "nr_pedido")
    private Long id;
    private LocalDate dtPedido;
    @DecimalMin(value = "0.0", inclusive = false, message = "O valor do pedido precisa ser maior que zero!")
    private BigDecimal vrTotalPedido = new BigDecimal(0);

    @OneToMany(mappedBy = "pedido", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<PedidoItem> pedidoItens = new ArrayList<>();


    public Pedido() {
    }

    public void addPedidoItem(PedidoItem pedidoItem) {
        this.vrTotalPedido = vrTotalPedido.add(pedidoItem.getVlTotalItemPedido());
        this.pedidoItens.add(pedidoItem);
        pedidoItem.setPedido(this);
    }

    public void deletePedidoItem(PedidoItem pedidoItem) {
        this.vrTotalPedido = vrTotalPedido.subtract(pedidoItem.getVlTotalItemPedido());
        pedidoItem.setPedido(null);
        this.pedidoItens.remove(pedidoItem);
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

    public BigDecimal getVrTotalPedido() {
        return vrTotalPedido;
    }

    public void setVrTotalPedido(BigDecimal vrTotalPedido) {
        this.vrTotalPedido = vrTotalPedido;
    }

    @PrePersist
    public void dataPedido() {
        this.setDtPedido(LocalDate.now());
    }

}
