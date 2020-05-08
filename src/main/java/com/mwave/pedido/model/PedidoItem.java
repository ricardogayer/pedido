package com.mwave.pedido.model;

import javax.persistence.*;
import java.math.BigDecimal;

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

    private BigDecimal qtdeItemPedido = new BigDecimal(0);
    private BigDecimal vlUnitProduto = new BigDecimal(0);
    private BigDecimal vlTotalItemPedido = new BigDecimal(0);

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
        this.vlUnitProduto = produto.getVrUnitproduto();
    }

    public Pedido getPedido() {
        return pedido;
    }

    public void setPedido(Pedido pedido) {

        this.pedido = pedido;

    }

    public BigDecimal getQtdeItemPedido() {

        return qtdeItemPedido;
    }

    public void setQtdeItemPedido(BigDecimal qtdeItemPedido) {
        this.qtdeItemPedido = qtdeItemPedido;
        this.vlTotalItemPedido = qtdeItemPedido.multiply(this.vlUnitProduto);
    }

    public BigDecimal getVlUnitProduto() {
        return vlUnitProduto;
    }

    public void setVlUnitProduto(BigDecimal vlUnitProduto) {
        this.vlUnitProduto = vlUnitProduto;
    }

    public BigDecimal getVlTotalItemPedido() {
        return vlTotalItemPedido;
    }

    public void setVlTotalItemPedido(BigDecimal vlTotalItemPedido) {
        this.vlTotalItemPedido = vlTotalItemPedido;
    }
}
