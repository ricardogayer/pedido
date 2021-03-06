package com.mwave.pedido.model;

import javax.persistence.*;
import java.math.BigDecimal;

@Entity
public class Produto {

    @Id @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "produto_seq")
    @SequenceGenerator(name="produto_seq",sequenceName = "produto_seq")
    @Column(name = "cd_produto")
    private Long cdProduto;
    @Column(name = "ds_produto")
    private String dsProduto;
    @Column(name = "vr_unitproduto")
    private BigDecimal vrUnitproduto;

    public Produto() {
    }

    public Produto(String dsProduto, BigDecimal vrUnitproduto) {
        this.dsProduto = dsProduto;
        this.vrUnitproduto = vrUnitproduto;
    }

    public Long getCdProduto() {
        return cdProduto;
    }

    public void setCdProduto(Long cdProduto) {
        this.cdProduto = cdProduto;
    }

    public String getDsProduto() {
        return dsProduto;
    }

    public void setDsProduto(String dsProduto) {
        this.dsProduto = dsProduto;
    }

    public BigDecimal getVrUnitproduto() {
        return vrUnitproduto;
    }

    public void setVrUnitproduto(BigDecimal vrUnitproduto) {
        this.vrUnitproduto = vrUnitproduto;
    }
}
