package com.mwave.pedido.controller;

import com.mwave.pedido.model.Produto;
import com.mwave.pedido.repository.ProdutoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/")
public class PedidoResource {

    @Autowired
    ProdutoRepository produtoRepository;

    @GetMapping("/produtos")
    public ResponseEntity<List<Produto>> getProdutos() {

        List<Produto> produtos = produtoRepository.findAll();

        return new ResponseEntity<List<Produto>>(produtos, HttpStatus.OK);
    }


}
