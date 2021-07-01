package br.com.application.tdd.jpa;

import org.junit.Test;

import br.com.application.domain.Patrimonio;
import br.com.application.domain.SoftwareLicense;
import br.com.application.persistence.jpa.PatrimonioPersistence;
import br.com.application.persistence.jpa.SoftwareLicensePersistence;

public class PatrimonioTest {
	
	SoftwareLicensePersistence softwareLicensePersistence;
	SoftwareLicense softwareLicense;
	
	PatrimonioPersistence patrimonioPersistence;
	Patrimonio patrimonio;

	@Test
	public void novoA() throws Exception {
		
		softwareLicensePersistence = new SoftwareLicensePersistence();
		softwareLicense = new SoftwareLicense();
		
		patrimonioPersistence = new PatrimonioPersistence();
		patrimonio = new Patrimonio();
		
		softwareLicense = softwareLicensePersistence.findBy(Long.parseLong("9"));
		
		patrimonio.setSucateado(Boolean.FALSE);
		patrimonio.setPatrimonio("24046-0101");
		patrimonio.setSoftwareLicense(softwareLicense);
		
		softwareLicense.setPatrimonio(patrimonio);
		patrimonioPersistence.save(patrimonio);
		softwareLicensePersistence.merge(softwareLicense);
		
	}
	
	@Test
	public void novoB() throws Exception {
		
		softwareLicensePersistence = new SoftwareLicensePersistence();
		softwareLicense = new SoftwareLicense();
		
		patrimonioPersistence = new PatrimonioPersistence();
		patrimonio = new Patrimonio();
		
		softwareLicense = softwareLicensePersistence.findBy(Long.parseLong("2"));
		
		patrimonio.setSucateado(Boolean.FALSE);
		patrimonio.setPatrimonio("24046-1111");
		patrimonio.setSoftwareLicense(softwareLicense);
		
		softwareLicense.setPatrimonio(patrimonio);
		patrimonioPersistence.save(patrimonio);
		softwareLicensePersistence.merge(softwareLicense);
		
	}
	
	@Test
	public void novoC() throws Exception {
		
		softwareLicensePersistence = new SoftwareLicensePersistence();
		softwareLicense = new SoftwareLicense();
		
		patrimonioPersistence = new PatrimonioPersistence();
		patrimonio = new Patrimonio();
		
		softwareLicense = softwareLicensePersistence.findBy(Long.parseLong("3"));
		
		patrimonio.setSucateado(Boolean.FALSE);
		patrimonio.setPatrimonio("24046-2222");
		patrimonio.setSoftwareLicense(softwareLicense);
		
		softwareLicense.setPatrimonio(patrimonio);
		patrimonioPersistence.save(patrimonio);
		softwareLicensePersistence.merge(softwareLicense);
		
	}
	
	@Test
	public void novoD() throws Exception {
		
		softwareLicensePersistence = new SoftwareLicensePersistence();
		softwareLicense = new SoftwareLicense();
		
		patrimonioPersistence = new PatrimonioPersistence();
		patrimonio = new Patrimonio();
		
		softwareLicense = softwareLicensePersistence.findBy(Long.parseLong("4"));
		
		patrimonio.setSucateado(Boolean.FALSE);
		patrimonio.setPatrimonio("24046-3333");
		patrimonio.setSoftwareLicense(softwareLicense);
		
		softwareLicense.setPatrimonio(patrimonio);
		patrimonioPersistence.save(patrimonio);
		softwareLicensePersistence.merge(softwareLicense);
		
	}
	
	@Test
	public void novoE() throws Exception {
		
		softwareLicensePersistence = new SoftwareLicensePersistence();
		softwareLicense = new SoftwareLicense();
		
		patrimonioPersistence = new PatrimonioPersistence();
		patrimonio = new Patrimonio();
		
		softwareLicense = softwareLicensePersistence.findBy(Long.parseLong("5"));
		
		patrimonio.setSucateado(Boolean.FALSE);
		patrimonio.setPatrimonio("24046-4444");
		patrimonio.setSoftwareLicense(softwareLicense);
		
		softwareLicense.setPatrimonio(patrimonio);
		patrimonioPersistence.save(patrimonio);
		softwareLicensePersistence.merge(softwareLicense);
		
	}
	
	@Test
	public void novoF() throws Exception {
		
		softwareLicensePersistence = new SoftwareLicensePersistence();
		softwareLicense = new SoftwareLicense();
		
		patrimonioPersistence = new PatrimonioPersistence();
		patrimonio = new Patrimonio();
		
		softwareLicense = softwareLicensePersistence.findBy(Long.parseLong("6"));
		
		patrimonio.setSucateado(Boolean.FALSE);
		patrimonio.setPatrimonio("24046-5555");
		patrimonio.setSoftwareLicense(softwareLicense);
		
		softwareLicense.setPatrimonio(patrimonio);
		patrimonioPersistence.save(patrimonio);
		softwareLicensePersistence.merge(softwareLicense);
		
	}
	
	@Test
	public void novoG() throws Exception {
		
		softwareLicensePersistence = new SoftwareLicensePersistence();
		softwareLicense = new SoftwareLicense();
		
		patrimonioPersistence = new PatrimonioPersistence();
		patrimonio = new Patrimonio();
		
		softwareLicense = softwareLicensePersistence.findBy(Long.parseLong("7"));
		
		patrimonio.setSucateado(Boolean.FALSE);
		patrimonio.setPatrimonio("24046-9090");
		patrimonio.setSoftwareLicense(softwareLicense);
		
		softwareLicense.setPatrimonio(patrimonio);
		patrimonioPersistence.save(patrimonio);
		softwareLicensePersistence.merge(softwareLicense);
		
	}
	
	@Test
	public void novoH() throws Exception {
		
		softwareLicensePersistence = new SoftwareLicensePersistence();
		softwareLicense = new SoftwareLicense();
		
		patrimonioPersistence = new PatrimonioPersistence();
		patrimonio = new Patrimonio();
		
		softwareLicense = softwareLicensePersistence.findBy(Long.parseLong("8"));
		
		patrimonio.setSucateado(Boolean.FALSE);
		patrimonio.setPatrimonio("24046-6666");
		patrimonio.setSoftwareLicense(softwareLicense);
		
		softwareLicense.setPatrimonio(patrimonio);
		patrimonioPersistence.save(patrimonio);
		softwareLicensePersistence.merge(softwareLicense);
		
	}
	
}
