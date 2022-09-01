package br.edu.ifg.databasetest;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import br.edu.ifg.database.ManageLeilao;
import br.edu.ifg.entidades.Leilao;
import br.edu.ifg.entidades.Situacao;

class ManageLeilaoTest {

	@Test
	void testListProduct() {
		var product = new Leilao();
		assertEquals(true, ManageLeilao.listaLeiloes().add(product));
	}

	@Test
	void testInsertProduct() {
		var produto = new Leilao("PS5", 4000.00, Situacao.ABERTO);
		assertEquals(true, ManageLeilao.insereLeilao(produto));
	}

	@Test
	void testRemoveProduct() {
		assertEquals(true, ManageLeilao.removeLeilao("PS5"));
	}

	@Test
	void testEditProduct() {
		var produto = new Leilao("PS5", 4000.00, Situacao.ABERTO);
		assertEquals(true, ManageLeilao.editaLeilao(produto, "PS5"));
	}
}
