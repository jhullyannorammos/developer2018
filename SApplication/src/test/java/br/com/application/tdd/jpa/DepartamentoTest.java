package br.com.application.tdd.jpa;

import java.text.ParseException;

import org.hibernate.HibernateException;
import org.junit.Ignore;
import org.junit.Test;

import br.com.application.domain.Departamento;
import br.com.application.persistence.jpa.DepartamentoPersistence;

public class DepartamentoTest {
	
	DepartamentoPersistence departamentoPersistence;

    @Test
    //@Ignore
    public void novo() throws HibernateException, Exception, ParseException {

        Departamento departamento1 = new Departamento();
        Departamento departamento2 = new Departamento();
        Departamento departamento3 = new Departamento();
        Departamento departamento4 = new Departamento();
        Departamento departamento5 = new Departamento();
        Departamento departamento6 = new Departamento();
        Departamento departamento7 = new Departamento();
        Departamento departamento8 = new Departamento();
        Departamento departamento9 = new Departamento();
        Departamento departamento0 = new Departamento();
        Departamento departamento10 = new Departamento();
        Departamento departamento20 = new Departamento();
        
        departamentoPersistence = new DepartamentoPersistence();
        departamento1.setDepartamento("Governança e planejamento de Tecnologia da informação");
        departamento1.setHierarquia("Gerencia");
        departamento1.setSigla("G-EEI");
        departamento1.setLocalidade("Goiania-GO");
        departamentoPersistence.save(departamento1);
        
        departamentoPersistence = new DepartamentoPersistence();
        departamento2.setDepartamento("Tecnologia da informação");
        departamento2.setHierarquia("Supervisão");
        departamento2.setSigla("S-STI");
        departamento2.setLocalidade("Anapolis-GO");
        departamentoPersistence.save(departamento2);
        
        departamentoPersistence = new DepartamentoPersistence();
        departamento3.setDepartamento("Segurança da informação");
        departamento3.setHierarquia("Gerência");
        departamento3.setSigla("G-SGI");
        departamento3.setLocalidade("Goiania-GO");
        departamentoPersistence.save(departamento3);
        
        departamentoPersistence = new DepartamentoPersistence();
        departamento4.setDepartamento("Segurança da informação");
        departamento4.setHierarquia("Supervisão");
        departamento4.setSigla("S-SGI");
        departamento4.setLocalidade("Goiania-GO");
        departamentoPersistence.save(departamento4);
        
        departamentoPersistence = new DepartamentoPersistence();
        departamento5.setDepartamento("Desenvolvimento de sistemas de informação");
        departamento5.setHierarquia("Supervisão");
        departamento5.setSigla("S-DSI");
        departamento5.setLocalidade("São Paulo-SP");
        departamentoPersistence.save(departamento5);
        
        departamentoPersistence = new DepartamentoPersistence();
        departamento6.setDepartamento("Manutenção de sistemas de informação");
        departamento6.setHierarquia("Supervisão");
        departamento6.setSigla("S-MSI");
        departamento6.setLocalidade("São Paulo-SP");
        departamentoPersistence.save(departamento6);
        
        departamentoPersistence = new DepartamentoPersistence();
        departamento7.setDepartamento("Infraestrutura de redes e telecomunicações");
        departamento7.setHierarquia("Supervisão");
        departamento7.setSigla("S-IRT");
        departamento7.setLocalidade("São Paulo-SP");
        departamentoPersistence.save(departamento7);
        
        departamentoPersistence = new DepartamentoPersistence();
        departamento8.setDepartamento("Assistencia técnica especializada");
        departamento8.setHierarquia("Supervisão");
        departamento8.setSigla("S-ATE");
        departamento8.setLocalidade("Brasília-DF");
        departamentoPersistence.save(departamento8);
        
        departamentoPersistence = new DepartamentoPersistence();
        departamento9.setDepartamento("Estoque de Equipamentos de Informática");
        departamento9.setHierarquia("Supervisão");
        departamento9.setSigla("S-EEI");
        departamento9.setLocalidade("Goiania-GO");
        departamentoPersistence.save(departamento9);
        
        departamentoPersistence = new DepartamentoPersistence();
        departamento0.setDepartamento("Marketing");
        departamento0.setHierarquia("Coordenação");
        departamento0.setSigla("C-MKT");
        departamento0.setLocalidade("Anapolis-GO");
        departamentoPersistence.save(departamento0);
        
        departamentoPersistence = new DepartamentoPersistence();
        departamento10.setDepartamento("Atendimento de vendas");
        departamento10.setHierarquia("Coordenação");
        departamento10.setSigla("C-AVD");
        departamento10.setLocalidade("Goiania-GO");
        departamentoPersistence.save(departamento10);
        
        departamentoPersistence = new DepartamentoPersistence();
        departamento20.setDepartamento("Marketing");
        departamento20.setHierarquia("Superintendencia");
        departamento20.setSigla("S-MKT");
        departamento20.setLocalidade("Brasilia-GO");
        departamentoPersistence.save(departamento20);
        
        /*
        long codigo  = 14;
        departamentoPersistence = new DepartamentoPersistence();
		departamentoPersistence.delete(codigo);
        listarById();
        */
        
        
        //listar();
        
    }
    
    /*
    public void listar() throws HibernateException, Exception, ParseException {
		departamentoPersistence = new DepartamentoPersistence();
		System.out.println("=========================================================");
		for(Departamento departamento : departamentoPersistence.findAll()) {
			System.out.println(departamento.getDepartamento());
			System.out.println(departamento.getHierarquia());
			System.out.println(departamento.getSigla());
			System.out.println(departamento.getLocalidade());
			System.out.println("_____________________________________________________");
		}
	}
    
    public void listarById() throws HibernateException, Exception, ParseException {
		departamentoPersistence = new DepartamentoPersistence();
		Departamento departamento = departamentoPersistence.findBy(Long.parseLong("14"));
		departamento.setLocalidade("São Paulo - SP");
		System.out.println(departamento.getDepartamento());
		System.out.println(departamento.getHierarquia());
		System.out.println(departamento.getSigla());
		System.out.println(departamento.getLocalidade());
		
		departamentoPersistence = new DepartamentoPersistence();
		departamentoPersistence.update(departamento);
	}
    */
}
