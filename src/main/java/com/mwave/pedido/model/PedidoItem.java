package com.mwave.pedido.model;

import javax.persistence.*;

@Entity
public class PedidoItem {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "produto_id")
    private Produto produto;

    @ManyToOne
    @JoinColumn(name = "pedido_id")
    private Pedido pedido;

    private Float qtdeItemPedido;
    private Float vlUnitProduto;
    private Float vlTotalItemPedido;

    public PedidoItem() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Produto getProduto() {
        return produto;
    }

    public void setProduto(Produto produto) {
        this.produto = produto;
    }

    public Pedido getPedido() {
        return pedido;
    }

    public void setPedido(Pedido pedido) {
        this.pedido = pedido;
    }

    public Float getQtdeItemPedido() {
        return qtdeItemPedido;
    }

    public void setQtdeItemPedido(Float qtdeItemPedido) {
        this.qtdeItemPedido = qtdeItemPedido;
    }

    public Float getVlUnitProduto() {
        return vlUnitProduto;
    }

    public void setVlUnitProduto(Float vlUnitProduto) {
        this.vlUnitProduto = vlUnitProduto;
    }

    public Float getVlTotalItemPedido() {
        return vlTotalItemPedido;
    }

    public void setVlTotalItemPedido(Float vlTotalItemPedido) {
        this.vlTotalItemPedido = vlTotalItemPedido;
    }
}
