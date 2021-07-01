package br.com.application.tdd.jpa;

import org.junit.Ignore;
import org.junit.Test;

import br.com.application.domain.embeddable.Configuracao;
import br.com.application.persistence.jpa.DepartamentoPersistence;
import br.com.application.persistence.jpa.EstoquePersistence;
import br.com.application.persistence.jpa.MercadoriaPersistence;
import br.com.application.persistence.jpa.PatrimonioPersistence;
import br.com.application.persistence.jpa.ProdutoPersistence;
import br.com.application.domain.Departamento;
import br.com.application.domain.Estoque;
import br.com.application.domain.Mercadoria;
import br.com.application.domain.Produto;
import br.com.application.domain.Patrimonio;

public class MercadoriaTest2 {
	
	DepartamentoPersistence departamentoPersistence;
    Departamento departamento;
	
	EstoquePersistence estoquePersistence;
	Estoque estoque;

	MercadoriaPersistence mercadoriaPersistence;
	Mercadoria mercadoria;
	
	PatrimonioPersistence patrimonioPersistence;
	Patrimonio patrimonio;

	ProdutoPersistence produtoPersistence;
	Produto produto;
	
	Configuracao configuracao;
	
	public Configuracao buscarConfiguracao() throws Exception {

		configuracao = new Configuracao();
		configuracao.setTela("15.6\" Full HD WVA (1920x1080) Antirreflexo Touchpad");
		configuracao.setProcessamento("Intel® Core™ i7-9750H (2.6GHz; 12MB Cache) ");
		configuracao.setArmazenamento("1TB SSD");
		configuracao.setMemoria("8GB (1x8GB) DDR4 2666MHz");
		configuracao.setBluethoot("Bluetooth 4.2");
		configuracao.setSegurança("Slot Kensington Lock");
		configuracao.setConectividade("Ethernet 100/1000 - Wireless 1x1 AC");
		configuracao.setGrafico("NVIDIA® GeForce® GTX 1050 3GB");
		configuracao.setBateria("3 células - 45Wh");
		configuracao.setBivolt(Boolean.TRUE);
		configuracao.setUnidadeOtica(Boolean.TRUE);
		configuracao.setCor("Preta");
		configuracao.setSom("Alto-falantes (2x 1.5W) com certificação Dolby Audio");
		configuracao.setOS("Windows 10 Professional");
		configuracao.setProcessamento("Core i5");
		configuracao.setArmazenamento("1TB SSD");
		configuracao.setMemoria("8GB DDR3");
		configuracao.setBivolt(Boolean.TRUE);
		return configuracao;
	}
	
	public Mercadoria buscarMercadoria() throws Exception {
		mercadoriaPersistence = new MercadoriaPersistence();
		return mercadoriaPersistence.findBy(Long.parseLong("1"));
	}
	
	public Estoque buscarEstoque() throws Exception {
		estoquePersistence = new EstoquePersistence();
		return estoquePersistence.findBy(Long.parseLong("2"));
	}

	
	public Produto buscarProduto() throws Exception {
		produtoPersistence = new ProdutoPersistence();
		return produtoPersistence.findBy(Long.parseLong("1"));
	}

	
	public Patrimonio buscarPatrimonio() throws Exception {
		patrimonioPersistence = new PatrimonioPersistence();
		return patrimonioPersistence.findBy(Long.parseLong("6"));
	}
	
	public Departamento buscarDepartamento() throws Exception {
		departamentoPersistence = new DepartamentoPersistence();
		return departamentoPersistence.findBy(Long.parseLong("5"));
	}

	
	
	
	
	
	
	
	
	
	@Test
	//@Ignore
	public void vincularPatrimonioMercadoriaA() throws Exception {
		
		mercadoria = new Mercadoria();
		patrimonio = new Patrimonio();
		
		patrimonioPersistence = new PatrimonioPersistence();
		patrimonio = patrimonioPersistence.findBy(Long.parseLong("4"));
		
		mercadoriaPersistence = new MercadoriaPersistence();
		mercadoria = mercadoriaPersistence.findBy(Long.parseLong("1"));
		
		patrimonio.setMercadoria(mercadoria);
		mercadoria.setPatrimonio(patrimonio);
		
		mercadoriaPersistence.merge(mercadoria);
		patrimonioPersistence.merge(patrimonio);
	}
	
	@Test
	//@Ignore
	public void vincularPatrimonioMercadoriaB() throws Exception {
		
		mercadoria = new Mercadoria();
		patrimonio = new Patrimonio();
		
		patrimonioPersistence = new PatrimonioPersistence();
		patrimonio = patrimonioPersistence.findBy(Long.parseLong("5"));
		
		mercadoriaPersistence = new MercadoriaPersistence();
		mercadoria = mercadoriaPersistence.findBy(Long.parseLong("2"));
		
		patrimonio.setMercadoria(mercadoria);
		mercadoria.setPatrimonio(patrimonio);
		
		mercadoriaPersistence.merge(mercadoria);
		patrimonioPersistence.merge(patrimonio);
	}
	
	@Test
	//@Ignore
	public void vincularPatrimonioMercadoriaC() throws Exception {
		
		mercadoria = new Mercadoria();
		patrimonio = new Patrimonio();
		
		patrimonioPersistence = new PatrimonioPersistence();
		patrimonio = patrimonioPersistence.findBy(Long.parseLong("6"));
		
		mercadoriaPersistence = new MercadoriaPersistence();
		mercadoria = mercadoriaPersistence.findBy(Long.parseLong("3"));
		
		patrimonio.setMercadoria(mercadoria);
		mercadoria.setPatrimonio(patrimonio);
		
		mercadoriaPersistence.merge(mercadoria);
		patrimonioPersistence.merge(patrimonio);
	}
	

}
