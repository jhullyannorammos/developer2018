package br.com.application.tdd.jpa;

import org.junit.Test;

import br.com.application.domain.embeddable.Caracteristicas;
import br.com.application.domain.Estoque;
import br.com.application.domain.Fornecedor;
import br.com.application.domain.Modelo;
import br.com.application.enumerator.EstoqueEnum;
import br.com.application.persistence.jpa.EstoquePersistence;
import br.com.application.persistence.jpa.FornecedorPersistence;
import br.com.application.persistence.jpa.ModeloPersistence;
import br.com.application.util.DateUtil;

public class ModeloTest {
	
	FornecedorPersistence fornecedorPersistence;
	Fornecedor fornecedor1, fornecedor2, fornecedor3, fornecedor4, fornecedor5;
	
	ModeloPersistence modeloPersistence;
	Modelo modelo1, modelo2;
	
	EstoquePersistence estoquePersistence;
	Estoque estoque;
	
	@Test
	public void inserirMicrosoft() throws Exception {
		
		fornecedorPersistence = new FornecedorPersistence();
		modeloPersistence = new ModeloPersistence();
		
		Caracteristicas caracteristicas = new Caracteristicas();
		caracteristicas.setDimensao("27,5X6,5X15,1");
		caracteristicas.setCor("Prata");
		caracteristicas.setPeso("1,92kg");
		/* ------------------------------------------------------------------------------- */
		fornecedor1 = fornecedorPersistence.findBy(Long.parseLong("1"));
		modelo1 = new Modelo();
		modelo1.setModelo("Console Xbox Series");
		modelo1.setLancamento("2020");
		modelo1.setFornecedor(fornecedor1);
		modelo1.setCaracteristicas(caracteristicas);
		fornecedor1.getModelos().add(modelo1);
        modeloPersistence.save(modelo1);
        fornecedorPersistence.merge(fornecedor1);
        /* ------------------------------------------------------------------------------- */
        fornecedor2 = fornecedorPersistence.findBy(Long.parseLong("1"));
		modelo2 = new Modelo();
		modelo2.setModelo("Console Xbox One S");
		modelo2.setLancamento("2016");
		modelo2.setFornecedor(fornecedor2);
		modelo2.setCaracteristicas(caracteristicas);
		fornecedor2.getModelos().add(modelo2);
        modeloPersistence.save(modelo2);
        fornecedorPersistence.merge(fornecedor2);
        /* ------------------------------------------------------------------------------- */
        
        estoquePersistence = new EstoquePersistence();
        estoque = new Estoque();
        estoque.setEstoque(EstoqueEnum.INFORMÁTICA);
		estoque.setModelo(modelo1.getModelo());
		estoque.setQuantidade(0);
		estoquePersistence.save(estoque);
		
		estoquePersistence = new EstoquePersistence();
        estoque = new Estoque();
        estoque.setEstoque(EstoqueEnum.INFORMÁTICA);
        estoque.setModelo(modelo2.getModelo());
		estoque.setQuantidade(0);
		estoquePersistence.save(estoque);
		
	}
	
	@Test
	public void inserirDELL() throws Exception {
		
		fornecedorPersistence = new FornecedorPersistence();
		modeloPersistence = new ModeloPersistence();
		
		Caracteristicas caracteristicas = new Caracteristicas();
		caracteristicas.setDimensao("22x36x25cm");
		caracteristicas.setCor("Preto");
		caracteristicas.setPeso("6.1kg");
		/* ------------------------------------------------------------------------------- */
		fornecedor1 = fornecedorPersistence.findBy(Long.parseLong("3"));
		modelo1 = new Modelo();
		modelo1.setModelo("OPTIPLEX 790");
		modelo1.setLancamento("2016");
		modelo1.setFornecedor(fornecedor1);
		modelo1.setCaracteristicas(caracteristicas);
		fornecedor1.getModelos().add(modelo1);
        modeloPersistence.save(modelo1);
        fornecedorPersistence.merge(fornecedor1);
        /* ------------------------------------------------------------------------------- */
        fornecedor2 = fornecedorPersistence.findBy(Long.parseLong("3"));
		modelo2 = new Modelo();
		modelo2.setModelo("OPTIPLEX 3020");
		modelo2.setLancamento("2017");
		modelo2.setFornecedor(fornecedor2);
		modelo2.setCaracteristicas(caracteristicas);
		fornecedor2.getModelos().add(modelo2);
        modeloPersistence.save(modelo2);
        fornecedorPersistence.merge(fornecedor2);
        /* ------------------------------------------------------------------------------- */
        estoquePersistence = new EstoquePersistence();
        estoque = new Estoque();
        estoque.setEstoque(EstoqueEnum.INFORMÁTICA);
		estoque.setModelo(modelo1.getModelo());
		estoque.setQuantidade(0);
		estoquePersistence.save(estoque);
		
		estoquePersistence = new EstoquePersistence();
        estoque = new Estoque();
        estoque.setEstoque(EstoqueEnum.INFORMÁTICA);
        estoque.setModelo(modelo2.getModelo());
		estoque.setQuantidade(0);
		estoquePersistence.save(estoque);
	}
	
	
	
	
	@Test
	public void inserirLenovo() throws Exception {
		
		fornecedorPersistence = new FornecedorPersistence();
		modeloPersistence = new ModeloPersistence();
		
		Caracteristicas caracteristicas = new Caracteristicas();
		caracteristicas.setDimensao("19x36x25cm");
		caracteristicas.setCor("Preto");
		caracteristicas.setPeso("4,3kg");
		/* ------------------------------------------------------------------------------- */
		fornecedor1 = fornecedorPersistence.findBy(Long.parseLong("2"));
		modelo1 = new Modelo();
		modelo1.setModelo("Ideapad S140");
		modelo1.setLancamento("2018");
		modelo1.setFornecedor(fornecedor1);
		modelo1.setCaracteristicas(caracteristicas);
		fornecedor1.getModelos().add(modelo1);
        modeloPersistence.save(modelo1);
        fornecedorPersistence.merge(fornecedor1);
        /* ------------------------------------------------------------------------------- */
        fornecedor2 = fornecedorPersistence.findBy(Long.parseLong("2"));
		modelo2 = new Modelo();
		modelo2.setModelo("ideapad L340");
		modelo2.setLancamento("2020");
		modelo2.setFornecedor(fornecedor2);
		modelo2.setCaracteristicas(caracteristicas);
		fornecedor2.getModelos().add(modelo2);
        modeloPersistence.save(modelo2);
        fornecedorPersistence.merge(fornecedor2);
        /* ------------------------------------------------------------------------------- */
        estoquePersistence = new EstoquePersistence();
        estoque = new Estoque();
        estoque.setEstoque(EstoqueEnum.INFORMÁTICA);
		estoque.setModelo(modelo1.getModelo());
		estoque.setQuantidade(0);
		estoquePersistence.save(estoque);
		
		estoquePersistence = new EstoquePersistence();
        estoque = new Estoque();
        estoque.setEstoque(EstoqueEnum.INFORMÁTICA);
        estoque.setModelo(modelo2.getModelo());
		estoque.setQuantidade(0);
		estoquePersistence.save(estoque);
	}

}
