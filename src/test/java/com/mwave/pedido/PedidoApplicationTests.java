package com.mwave.pedido;

import com.mwave.pedido.model.Pedido;
import com.mwave.pedido.model.PedidoItem;
import com.mwave.pedido.model.Produto;
import com.mwave.pedido.repository.PedidoRepository;
import com.mwave.pedido.repository.ProdutoRepository;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;

@ExtendWith(SpringExtension.class)
@SpringBootTest
@TestMethodOrder(MethodOrderer.Alphanumeric.class)
		// Ordenar os testes!!!
class PedidoApplicationTests {

	@Autowired
	ProdutoRepository produtoRepository;

	@Autowired
	PedidoRepository pedidoRepository;

	@Test
	public void test1Produto() {

		Produto produto1 = new Produto();
		produto1.setDsProduto("Maça");
		produto1.setVrUnitproduto(new BigDecimal(8.5));
		produtoRepository.save(produto1);

		Produto produto2 = new Produto();
		produto2.setDsProduto("Banana");
		produto2.setVrUnitproduto(new BigDecimal(4.5));
		produtoRepository.save(produto2);

		Produto produto3 = new Produto();
		produto3.setDsProduto("Uva");
		produto3.setVrUnitproduto(new BigDecimal(7.8));
		produtoRepository.save(produto3);

		List<Produto> produtos = produtoRepository.findAll();

		for (Produto p : produtos) {
			System.out.println("Produto " + p.getCdProduto() + " - " + p.getDsProduto());
		}

		assertEquals(3, produtos.size());

	}

	@Test
	public void test2Pedido() {

		Produto produto1 = new Produto();
		produto1.setDsProduto("Chocolate em Pó");
		produto1.setVrUnitproduto(new BigDecimal(12.5));
		produtoRepository.save(produto1);

		Produto produto2 = new Produto();
		produto2.setDsProduto("Biscoito Maisena");
		produto2.setVrUnitproduto(new BigDecimal(8.5));
		produtoRepository.save(produto2);

		Produto produto3 = new Produto();
		produto3.setDsProduto("Queijo Frescal");
		produto3.setVrUnitproduto(new BigDecimal(22));
		produtoRepository.save(produto3);

		PedidoItem pedidoItem1 = new PedidoItem();
		pedidoItem1.setProduto(produto1);
		pedidoItem1.setQtdeItemPedido(new BigDecimal(2));

		PedidoItem pedidoItem2 = new PedidoItem();
		pedidoItem2.setProduto(produto2);
		pedidoItem2.setQtdeItemPedido(new BigDecimal(2));

		PedidoItem pedidoItem3 = new PedidoItem();
		pedidoItem3.setProduto(produto2);
		pedidoItem3.setQtdeItemPedido(new BigDecimal(1));

		Pedido pedido = new Pedido();

		pedido.addPedidoItem(pedidoItem1);
		pedido.addPedidoItem(pedidoItem2);
		pedido.addPedidoItem(pedidoItem3);
		pedidoRepository.save(pedido);

		assertEquals(new BigDecimal(50.5), pedido.getVrTotalPedido());
		assertEquals(LocalDate.now(), pedido.getDtPedido());

		pedido.deletePedidoItem(pedidoItem2);
		pedidoRepository.save(pedido);

		assertEquals(new BigDecimal(33.5), pedido.getVrTotalPedido());

	}

	@Test
	public void test3GetPedido() {

		Optional<Pedido> p = pedidoRepository.findById(1l);

		if (p.isPresent()) {
			Pedido pedido = p.get();
			assertEquals(1L, pedido.getId());
			System.out.println("Pedido - Valor Total do Pedido = " + pedido.getVrTotalPedido());
		}


	}

	/*
	@Test
	void test1() {

		Produto produto = new Produto("iPhone X",4500.67F);

		produtoRepository.save(produto);

		assumeTrue(produto.getCdProduto()==1);

	}

	@Test
	void test2() {

		Produto produto = new Produto();
		produto.setDsProduto("IPhone 8 Plus");
		produto.setVrUnitproduto(5600F);

		produtoRepository.save(produto);

		Optional<Produto> p = produtoRepository.findByCdProduto(2L);

		if (p.isPresent()) {
			produto = p.get();
			assertEquals(produto.getDsProduto(),"IPhone 8 Plus");
		}

	}

	@Test
	void test3() {
		Optional<Produto> p = produtoRepository.findByCdProduto(2L);
		assertNotNull(p);
	}

	@Test
	void test4() {

		Produto produto = new Produto();
		Optional<Produto> p = produtoRepository.findByCdProduto(2L);

		if (p.isPresent()) {
			produto = p.get();
		}

		produto.setVrUnitproduto(produto.getVrUnitproduto()*2);

		assertEquals(produto.getVrUnitproduto(),5600F*2);
	}

	@Test
	void test5() {

		Produto produto = new Produto();
		produto.setDsProduto("iPad Pro 11");
		produto.setVrUnitproduto(7500F);

		produtoRepository.save(produto);

		Pedido pedido = new Pedido();
		pedido.setDtPedido(LocalDate.now());
		pedido.setVrTotalPedido(0F);

		Pedido  p = pedidoService.createPedido(pedido);

		PedidoItem pedidoItem = new PedidoItem();
		pedidoItem.setPedido(p);
		pedidoItem.setProduto(produto);
		pedidoItem.setQtdeItemPedido(2F);

		pedidoService.adicionaPedidoItem(pedido,pedidoItem);

		assertNotNull(pedido.getPedidoItens());

	}

	 */

}
