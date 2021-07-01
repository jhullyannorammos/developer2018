package br.com.application.tdd.jpa;



import org.junit.Test;

import br.com.application.domain.Cidade;
import br.com.application.persistence.jpa.CidadePersistence;

public class CidadeTest {
	
	CidadePersistence cidadePersistence;
	Cidade cidade;
	
	@Test
	public void listar() throws Exception {
		cidadePersistence = new CidadePersistence();
		for(Cidade c : cidadePersistence.findAll()) {
			System.out.print(c.getCidade());
			System.out.println(c.getSigla());
		}
	}
    
	@Test
	public void inserirGoiania() throws Exception {
		cidadePersistence = new CidadePersistence();
		cidade = new Cidade();
		cidade.setFederacao("Goiás");
		cidade.setCapital(Boolean.FALSE);
		cidade.setCidade("Goiania");
		cidade.setSigla("GO");
		cidadePersistence.save(cidade);
	}
	
	@Test
	public void inserirRioVerde() throws Exception {
		cidadePersistence = new CidadePersistence();
		cidade = new Cidade();
		cidade.setFederacao("Goiás");
		cidade.setCapital(Boolean.FALSE);
		cidade.setCidade("Rio Verde");
		cidade.setSigla("GO");
		cidadePersistence.save(cidade);
	}
	
	@Test
	public void inserirAnapolis() throws Exception {
		cidadePersistence = new CidadePersistence();
		cidade = new Cidade();
		cidade.setFederacao("Goiás");
		cidade.setCapital(Boolean.FALSE);
		cidade.setCidade("Anapolis");
		cidade.setSigla("GO");
		cidadePersistence.save(cidade);
	}
	
	@Test
	public void inserirValparaiso() throws Exception {
		cidadePersistence = new CidadePersistence();
		cidade = new Cidade();
		cidade.setFederacao("Goiás");
		cidade.setCapital(Boolean.FALSE);
		cidade.setCidade("Valparaiso");
		cidade.setSigla("GO");
		cidadePersistence.save(cidade);
	}

}
