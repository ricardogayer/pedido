package com.mwave.pedido;

import com.mwave.pedido.model.Pedido;
import com.mwave.pedido.model.PedidoItem;
import com.mwave.pedido.model.Produto;
import com.mwave.pedido.repository.ProdutoRepository;
import com.mwave.pedido.service.PedidoService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.time.LocalDate;
import java.util.Optional;

import static org.junit.jupiter.api.Assumptions.assumeTrue;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@ExtendWith(SpringExtension.class)
@SpringBootTest
class PedidoApplicationTests {

	@Autowired
	ProdutoRepository produtoRepository;

	@Autowired
	PedidoService pedidoService;

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

}
