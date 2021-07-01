package br.com.application.tdd.jpa;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.junit.Ignore;
import org.junit.Test;
import br.com.application.domain.Colaborador;
import br.com.application.domain.Departamento;
import br.com.application.domain.Estoque;
import br.com.application.domain.Fornecedor;
import br.com.application.domain.Mercadoria;
import br.com.application.domain.Modelo;
import br.com.application.domain.Produto;
import br.com.application.domain.Movimentacao;
import br.com.application.enumerator.MovimentacaoEnum;
import br.com.application.persistence.jpa.ColaboradorPersistence;
import br.com.application.persistence.jpa.DepartamentoPersistence;
import br.com.application.persistence.jpa.EstoquePersistence;
import br.com.application.persistence.jpa.FornecedorPersistence;
import br.com.application.persistence.jpa.MercadoriaPersistence;
import br.com.application.persistence.jpa.ModeloPersistence;
import br.com.application.persistence.jpa.MovimentacaoPersistence;
import br.com.application.persistence.jpa.ProdutoPersistence;

public class MovimentacaoTest {
	
	MovimentacaoPersistence movimentacaoPersistence;
	EstoquePersistence estoquePersistence;
	ModeloPersistence modeloPersistence;
	FornecedorPersistence fabricantePersistence;
	ProdutoPersistence produtoPersistence;
	MercadoriaPersistence mercadoriaPersistence;
	ModeloPersistence modelopersistence;
	DepartamentoPersistence departamentoPersistence;
	ColaboradorPersistence funcionarioPersistence;
	
	Departamento departamento;
	Movimentacao movimentacao;
	Colaborador funcionario;
	Fornecedor fabricante;
	Modelo modelo;
	Estoque estoque;
	Produto produto;
	List<Mercadoria> mercadorias;
	Mercadoria mercadoria1;
	Mercadoria mercadoria2;
	

	
	Long idmovimentacao;
	Long idfabricante;
	Long idmodelo;
	Long idestoque;
	Long idpatrimony;
	Long idproduto;
	Long idmercadoria;
	
	public Colaborador buscarEmpregado() throws Exception {
		
		ColaboradorPersistence colaboradorPersistence = new ColaboradorPersistence();
		return colaboradorPersistence.findBy(Long.parseLong("1"));
		//Empregado empregado = new Empregado();
		//empregado.setNomeCompleto(colaborador.getNomeCompleto());
		//empregado.setMatricula("E1234");
		//empregado.setCargo(colaborador.getCargo());
		//empregado.setCpf(colaborador.getCpf());
		//return empregado;
	}
	
	public Produto buscarProduto() throws Exception {
		produtoPersistence = new ProdutoPersistence();
		produto = produtoPersistence.findBy(Long.parseLong("1"));
		return produtoPersistence.findBy(Long.parseLong("1"));
	}
	
	
	@Test
	//@Ignore
	public void Entrada() throws Exception {

		mercadoriaPersistence = new MercadoriaPersistence();
		mercadorias = new ArrayList<>();
		
		movimentacaoPersistence = new MovimentacaoPersistence();
		movimentacao = new Movimentacao();
		
		mercadoria1 = new Mercadoria();
		mercadoria1 = mercadoriaPersistence.findBy(Long.parseLong("1"));
		mercadoria1.setEstocada(Boolean.TRUE);
		
		mercadorias.add(mercadoria1);
		
		mercadoria2 = new Mercadoria();
		mercadoria2 = mercadoriaPersistence.findBy(Long.parseLong("2"));
		mercadoria2.setEstocada(Boolean.TRUE);
		
		mercadorias.add(mercadoria2);
		
		movimentacao.setMovimentacao(MovimentacaoEnum.ENTRADA);
		movimentacao.setPeriodo(new Date());

		//movimentacao.setDepartamento(DepartamentoEmbeddedTDD.DepartamentoEmbeddable());
		movimentacao.setColaborador(buscarEmpregado());
		movimentacao.setMercadorias(mercadorias);
		
		movimentacaoPersistence.save(movimentacao);
		mercadoriaPersistence.merge(mercadoria1);
		mercadoriaPersistence.merge(mercadoria2);
		
		EstoqueTest.adicionarEstoque(mercadoria1);
		EstoqueTest.adicionarEstoque(mercadoria2);
	}
	
	
	
	@Test
	@Ignore
	public void Saida() throws Exception {

		mercadoriaPersistence = new MercadoriaPersistence();
		mercadorias = new ArrayList<>();
		
		movimentacaoPersistence = new MovimentacaoPersistence();
		movimentacao = new Movimentacao();
		
		mercadoria1 = new Mercadoria();
		mercadoria1 = mercadoriaPersistence.findBy(Long.parseLong("1"));
		mercadoria1.setEstocada(Boolean.FALSE);
		
		mercadorias.add(mercadoria1);
		
		mercadoria2 = new Mercadoria();
		mercadoria2 = mercadoriaPersistence.findBy(Long.parseLong("2"));
		mercadoria2.setEstocada(Boolean.FALSE);
		
		mercadorias.add(mercadoria2);
		
		movimentacao.setMovimentacao(MovimentacaoEnum.SAIDA);
		movimentacao.setPeriodo(new Date());

		//movimentacao.setDepartamento(DepartamentoEmbeddedTDD.DepartamentoEmbeddable());
		movimentacao.setColaborador(buscarEmpregado());
		movimentacao.setMercadorias(mercadorias);
		
		movimentacaoPersistence.save(movimentacao);
		mercadoriaPersistence.merge(mercadoria1);
		mercadoriaPersistence.merge(mercadoria2);
		
		EstoqueTest.removeEstoque(mercadoria1); 
		EstoqueTest.removeEstoque(mercadoria2);
	}

	@Test
	//@Ignore
	public void listar() throws Exception {
		MovimentacaoPersistence movimentacaoPersistence = new MovimentacaoPersistence();
		for(Movimentacao m : movimentacaoPersistence.findAll()) {
			
			System.out.println("_________________________________");
			System.out.println(m.getMovimentacao());
			System.out.println(m.getPeriodo());
			//System.out.println(m.getColaborador().getDepartamento().getDepartamento());
			//System.out.println(m.getColaborador().getDepartamento().getSigla());
			//System.out.println(m.getColaborador().getNomeCompleto());
			//System.out.println(m.getColaborador().getCargo());
			System.out.println(m.getMercadorias().size());
			
		}
	}
	
}
