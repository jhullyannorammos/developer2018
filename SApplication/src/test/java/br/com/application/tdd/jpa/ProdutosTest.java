package br.com.application.tdd.jpa;

import java.util.Date;

import org.junit.Ignore;
import org.junit.Test;

import br.com.application.domain.Departamento;
import br.com.application.domain.Colaborador;
import br.com.application.domain.Estoque;
import br.com.application.domain.Fornecedor;
import br.com.application.domain.Mercadoria;
import br.com.application.domain.Modelo;
import br.com.application.domain.Produto;
import br.com.application.domain.Movimentacao;
import br.com.application.enumerator.MarcasEnum;
import br.com.application.enumerator.MovimentacaoEnum;
import br.com.application.persistence.jpa.ColaboradorPersistence;
import br.com.application.persistence.jpa.DepartamentoPersistence;
import br.com.application.persistence.jpa.EstoquePersistence;
import br.com.application.persistence.jpa.FornecedorPersistence;
import br.com.application.persistence.jpa.MercadoriaPersistence;
import br.com.application.persistence.jpa.ModeloPersistence;
import br.com.application.persistence.jpa.MovimentacaoPersistence;
import br.com.application.persistence.jpa.ProdutoPersistence;
import br.com.application.util.DateUtil;


public class ProdutosTest {
	
	MovimentacaoPersistence transferenciaPersistence;
	EstoquePersistence estoquePersistence;
	ModeloPersistence modeloPersistence;
	FornecedorPersistence fornecedorPersistence;
	ProdutoPersistence produtoPersistence;
	MercadoriaPersistence itemPersistence;
	ModeloPersistence modelopersistence;
	DepartamentoPersistence departamentoPersistence;
	ColaboradorPersistence funcionarioPersistence;
	
	Fornecedor fornecedor;
	Departamento departamento;
	Movimentacao transferencia;
	Colaborador funcionario;
	Modelo modelo;
	Estoque estoque;
	Produto produtoA;
	Produto produtoB;
	Mercadoria item;
	
	Long idtransferencia;
	Long idfabricante;
	Long idmodelo;
	Long idestoque;
	Long idpatrimony;
	Long idproduto;
	Long iditem;

	@Test
	public void addMicrosoft() throws Exception {
		
		modeloPersistence = new ModeloPersistence();
		modelo = new Modelo();
		
		modelo = modeloPersistence.findBy(Long.parseLong("5"));
		produtoPersistence = new ProdutoPersistence();
		produtoA = new Produto();
		produtoA.setModelo(modelo);
		produtoA.setProduto("GAME");
		produtoA.setValor(Double.parseDouble("1999.0"));
		produtoPersistence.save(produtoA);
		
        //EstoqueTest.criarEstoque(modelo);
        
		modelo = modeloPersistence.findBy(Long.parseLong("6"));
		produtoPersistence = new ProdutoPersistence();
		produtoB = new Produto();
		produtoB.setModelo(modelo);
		produtoB.setProduto("GAME");
		produtoB.setValor(Double.parseDouble("2999.0"));
		produtoPersistence.save(produtoB);
		
		//EstoqueTest.criarEstoque(modelo);
	}
	
	
	
	@Test
	public void addLenovo() throws Exception {
		
		modeloPersistence = new ModeloPersistence();
		modelo = new Modelo();
		
		modelo = modeloPersistence.findBy(Long.parseLong("3"));
		produtoPersistence = new ProdutoPersistence();
		produtoA = new Produto();
		produtoA.setModelo(modelo);
		produtoA.setProduto("NOTEBOOK");
		produtoA.setValor(Double.parseDouble("4999.0"));
		produtoPersistence.save(produtoA);
		
		//EstoqueTest.criarEstoque(modelo);
		
		modelo = modeloPersistence.findBy(Long.parseLong("4"));
		produtoPersistence = new ProdutoPersistence();
		produtoB = new Produto();
		produtoB.setModelo(modelo);
		produtoB.setProduto("NOTEBOOK");
		produtoB.setValor(Double.parseDouble("3999.0"));
		produtoPersistence.save(produtoB);
		
		//EstoqueTest.criarEstoque(modelo);
	}
	
	@Test
	public void addDELL() throws Exception {
		
		modeloPersistence = new ModeloPersistence();
		modelo = new Modelo();
		
		modelo = modeloPersistence.findBy(Long.parseLong("2"));
		produtoPersistence = new ProdutoPersistence();
		produtoA = new Produto();
		produtoA.setModelo(modelo);
		produtoA.setProduto("COMPUTADOR");
		produtoA.setValor(Double.parseDouble("4999.0"));
		produtoPersistence.save(produtoA);
		
		//EstoqueTest.criarEstoque(modelo);
		
		modelo = modeloPersistence.findBy(Long.parseLong("1"));
		produtoPersistence = new ProdutoPersistence();
		produtoB = new Produto();
		produtoB.setModelo(modelo);
		produtoB.setProduto("COMPUTADOR");
		produtoB.setValor(Double.parseDouble("2999.0"));
		produtoPersistence.save(produtoB);
		
		//EstoqueTest.criarEstoque(modelo);
	}
	
	
}