package br.com.application.tdd.jpa;

import org.junit.Ignore;
import org.junit.Test;

import br.com.application.domain.Estoque;
import br.com.application.domain.Mercadoria;
import br.com.application.domain.Modelo;
import br.com.application.enumerator.EstoqueEnum;
import br.com.application.persistence.jpa.EstoquePersistence;
import br.com.application.persistence.jpa.MercadoriaPersistence;

public class EstoqueTDD {

	
	@Test
	public void findAll() throws Exception {
		EstoquePersistence estoquePersistence = new EstoquePersistence();
		for(Estoque e : estoquePersistence.findAll()) {
			
		}
	}
	
	@Test
	@Ignore
	public void novo() throws Exception {

		EstoquePersistence estoquePersistence = new EstoquePersistence();
		Estoque estoque = new Estoque();

		Modelo modelo = null;

		estoque.setEstoque(EstoqueEnum.INFORMÁTICA);
		estoque.setModelo(modelo.getModelo());
		estoque.setQuantidade(0);
		estoquePersistence.save(estoque);

	}

	@Test
	@Ignore
	public void adicionarEstoque() throws Exception {

		EstoquePersistence estoquePersistence = new EstoquePersistence();
		Estoque estoque = estoquePersistence.findBy(Long.parseLong("2"));

		MercadoriaPersistence mercadoriaPersistence = new MercadoriaPersistence();
		Mercadoria mercadoria = new Mercadoria();
		mercadoria = mercadoriaPersistence.findBy(Long.parseLong("1"));

		if (mercadoria.getProduto().getModelo().getModelo().equals(estoque.getModelo())) {
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
	public void removeEstoque() throws Exception {

		EstoquePersistence estoquePersistence = new EstoquePersistence();
		Estoque estoque = estoquePersistence.findBy(Long.parseLong("2"));

		MercadoriaPersistence mercadoriaPersistence = new MercadoriaPersistence();
		Mercadoria mercadoria = new Mercadoria();
		mercadoria = mercadoriaPersistence.findBy(Long.parseLong("1"));

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
