package br.com.application.tdd.jpa;

import java.sql.SQLException;

import org.junit.Ignore;
import org.junit.Test;

import br.com.application.domain.Estoque;
import br.com.application.domain.Mercadoria;
import br.com.application.domain.Modelo;
import br.com.application.enumerator.EstoqueEnum;
import br.com.application.persistence.jpa.EstoquePersistence;
import br.com.application.persistence.jpa.MercadoriaPersistence;
import br.com.application.persistence.jpa.ModeloPersistence;


public class EstoqueTest {


	
	@Test
	@Ignore
	public static void adicionarEstoque(Mercadoria mercadoria) throws Exception {

		EstoquePersistence estoquePersistence = new EstoquePersistence();
		Estoque estoque = estoquePersistence.findBy(Long.parseLong("2"));

		MercadoriaPersistence mercadoriaPersistence = new MercadoriaPersistence();

		if (mercadoria.getProduto().getModelo().getModelo().equalsIgnoreCase(estoque.getModelo())) {
			estoque.getMercadorias().add(mercadoria);
			estoque.setQuantidade(estoque.getMercadorias().size());
			mercadoria.setEstoque(estoque);
			mercadoria.setEstocada(Boolean.TRUE);

			mercadoriaPersistence.merge(mercadoria);
			estoquePersistence.merge(estoque);
		} else {
			System.out.println("A mercadoria deve ser adicionada no estoque correto.");
		}

	}

	
	@Test
	@Ignore
	public static void removeEstoque(Mercadoria mercadoria) throws Exception {

		EstoquePersistence estoquePersistence = new EstoquePersistence();
		Estoque estoque = estoquePersistence.findBy(Long.parseLong("2"));

		MercadoriaPersistence mercadoriaPersistence = new MercadoriaPersistence();

		mercadoria.setEstocada(Boolean.FALSE);
		for (Mercadoria m : estoque.getMercadorias()) {
			if (m.getId().equals(mercadoria.getId())) {
				estoque.getMercadorias().remove(m);
				
				estoque.setQuantidade(estoque.getMercadorias().size());
				mercadoria.setEstoque(null);

				mercadoriaPersistence.merge(mercadoria);
				estoquePersistence.merge(estoque);
				
				break;
			}
		}
		

	}
	
}
