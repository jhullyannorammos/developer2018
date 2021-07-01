package br.com.application.tdd.jpa;

import org.junit.Test;

import br.com.application.domain.Usuario;
import br.com.application.domain.embeddable.Endereco;
import br.com.application.domain.embeddable.Telefone;
import br.com.application.persistence.jpa.ColaboradorPersistence;
import br.com.application.persistence.jpa.DepartamentoPersistence;
import br.com.application.persistence.jpa.UsuarioPersistence;
import br.com.application.domain.Departamento;
import br.com.application.domain.Colaborador;
import br.com.application.util.DateUtil;

public class ColaboradorTest {
	
	DepartamentoPersistence departamentoPersistence;
	Departamento departamento;
	
	ColaboradorPersistence colaboradorPersistence;
	Colaborador colaborador;

	Telefone telefone;
	Endereco endereco;
	
	UsuarioPersistence usuarioPersistence;
	Usuario usuario1, usuario2, usuario3;
	
	
	@Test
	public void inserirJimmyNeutron() throws Exception {
		
		departamentoPersistence = new DepartamentoPersistence();
	    departamento = departamentoPersistence.findBy(Long.parseLong("3"));
		
		Endereco endereco1 = new Endereco();
		endereco1.setCep("37.479-900");
		endereco1.setRua("Avenida 01010010");
		endereco1.setComplemento("Clube dos nerds");
		endereco1.setLogradouro("8RQ4");
		endereco1.setNumero("2356");
		endereco1.setBloco("R7T8");
		endereco1.setLote("K8P5");
		endereco1.setCidade("EUA");
		endereco1.setUf("New York");
		
		Telefone telefone1 = new Telefone();
		telefone1.setTelefone("8812-4447");
		telefone1.setTipo("Residencial");
		telefone1.setDDD("89");
		
		colaboradorPersistence = new ColaboradorPersistence();
		colaborador = new Colaborador();
		colaborador.setEmail("jneutron@nerdao.com");
		colaborador.setDataNascimento(DateUtil.converterStringToCalendar("13/09/2001"));
		colaborador.setNomeCompleto("Jimmy Neutron");
		colaborador.setCpf("61925671111");
		colaborador.setCnh("72234499999");
		colaborador.setRg("5878978888");
		colaborador.setDepartamento(departamento);
		colaborador.setRemuneracao(5000.0);
		colaborador.setCargo("Analista de segurança da informação");
		colaborador.setMatricula("t228478");
		colaborador.setTelefone(telefone1);
		colaborador.setEndereco(endereco1);
		colaborador.setDepartamento(departamento);
		colaboradorPersistence.save(colaborador);
		
		
		departamento.getColaboradores().add(colaborador);
		departamentoPersistence.merge(departamento);

	}
	
	@Test
	public void inserirVidel() throws Exception {
		
		departamentoPersistence = new DepartamentoPersistence();
	    departamento = departamentoPersistence.findBy(Long.parseLong("4"));
		
		Endereco endereco1 = new Endereco();
		endereco1.setCep("77.479-900");
		endereco1.setRua("Avenida 666");
		endereco1.setComplemento("Mansao do mister satan");
		endereco1.setLogradouro("7QRE");
		endereco1.setNumero("999");
		endereco1.setBloco("H6H5");
		endereco1.setLote("K8R35");
		endereco1.setCidade("Japan");
		endereco1.setUf("Tokio");
		
		Telefone telefone1 = new Telefone();
		telefone1.setTelefone("5812-6747");
		telefone1.setTipo("Residencial");
		telefone1.setDDD("12");
		
		colaboradorPersistence = new ColaboradorPersistence();
		colaborador = new Colaborador();
		colaborador.setEmail("videl@dbz.com");
		colaborador.setDataNascimento(DateUtil.converterStringToCalendar("26/11/2001"));
		colaborador.setNomeCompleto("Videl");
		colaborador.setCpf("61925673037");
		colaborador.setCnh("72234441647");
		colaborador.setRg("5878996520");
		colaborador.setDepartamento(departamento);
		colaborador.setRemuneracao(5000.0);
		colaborador.setCargo("Agente de Recursos Humanos");
		colaborador.setMatricula("t788478");
		colaborador.setTelefone(telefone1);
		colaborador.setEndereco(endereco1);
		colaborador.setDepartamento(departamento);
		colaboradorPersistence.save(colaborador);
		
		
		departamento.getColaboradores().add(colaborador);
		departamentoPersistence.merge(departamento);

	}
	
	@Test
	public void inserirSasuke() throws Exception {
		
		departamentoPersistence = new DepartamentoPersistence();
	    departamento = departamentoPersistence.findBy(Long.parseLong("5"));
		
		Endereco endereco1 = new Endereco();
		endereco1.setCep("71.479-900");
		endereco1.setRua("Avenida Uchiha");
		endereco1.setComplemento("Uchiha Clan");
		endereco1.setLogradouro("SQRE");
		endereco1.setNumero("1584");
		endereco1.setBloco("P7H5");
		endereco1.setLote("B12");
		endereco1.setCidade("China");
		endereco1.setUf("Honk Kong");
		
		Telefone telefone1 = new Telefone();
		telefone1.setTelefone("5847-2547");
		telefone1.setTipo("Comercial");
		telefone1.setDDD("89");
		
		colaboradorPersistence = new ColaboradorPersistence();
		colaborador = new Colaborador();
		colaborador.setEmail("sasuke@uchiha.com");
		colaborador.setDataNascimento(DateUtil.converterStringToCalendar("11/02/2010"));
		colaborador.setNomeCompleto("Sasuke Uchiha");
		colaborador.setCpf("61920113037");
		colaborador.setCnh("72255441647");
		colaborador.setRg("5874596520");
		colaborador.setDepartamento(departamento);
		colaborador.setRemuneracao(9000.0);
		colaborador.setCargo("Desenvolvedor");
		colaborador.setMatricula("t148478");
		colaborador.setTelefone(telefone1);
		colaborador.setEndereco(endereco1);
		colaborador.setDepartamento(departamento);
		colaboradorPersistence.save(colaborador);
		
		
		departamento.getColaboradores().add(colaborador);
		departamentoPersistence.merge(departamento);

	}
	
	
	@Test
	public void inserirGohan() throws Exception {
		
		departamentoPersistence = new DepartamentoPersistence();
	    departamento = departamentoPersistence.findBy(Long.parseLong("6"));
		
		Endereco endereco1 = new Endereco();
		endereco1.setCep("85.219-900");
		endereco1.setRua("Mountain of the dragon");
		endereco1.setComplemento("Caminho da serpente");
		endereco1.setLogradouro("S7SS");
		endereco1.setNumero("369");
		endereco1.setBloco("S8JK");
		endereco1.setLote("JP10");
		endereco1.setCidade("China");
		endereco1.setUf("Honk Kong");
		
		Telefone telefone1 = new Telefone();
		telefone1.setTelefone("5741-2547");
		telefone1.setTipo("Comercial");
		telefone1.setDDD("12");
		
		colaboradorPersistence = new ColaboradorPersistence();
		colaborador = new Colaborador();
		colaborador.setEmail("Gohan@sayajin.com");
		colaborador.setDataNascimento(DateUtil.converterStringToCalendar("12/11/1951"));
		colaborador.setNomeCompleto("Gohan super sayaman");
		colaborador.setCpf("20000000020");
		colaborador.setCnh("70000000040");
		colaborador.setRg("1000000001");
		colaborador.setDepartamento(departamento);
		colaborador.setRemuneracao(2000.0);
		colaborador.setMatricula("KTh2263");
		colaborador.setCargo("Investigador de dados");
		colaborador.setTelefone(telefone1);
		colaborador.setEndereco(endereco1);
		colaborador.setDepartamento(departamento);
		colaboradorPersistence.save(colaborador);
		
		
		departamento.getColaboradores().add(colaborador);
		departamentoPersistence.merge(departamento);

	}
	
	
	@Test
	public void inserirTrunks() throws Exception {
		
		departamentoPersistence = new DepartamentoPersistence();
	    departamento = departamentoPersistence.findBy(Long.parseLong("7"));
		
		Endereco endereco1 = new Endereco();
		endereco1.setCep("99.912-257");
		endereco1.setRua("S667");
		endereco1.setComplemento("Capsule corporation");
		endereco1.setLogradouro("K45");
		endereco1.setNumero("154");
		endereco1.setBloco("18JK");
		endereco1.setLote("S32");
		endereco1.setCidade("New York");
		endereco1.setUf("EUA");
		
		Telefone telefone1 = new Telefone();
		telefone1.setTelefone("1020-2547");
		telefone1.setTipo("Comercial");
		telefone1.setDDD("11");
		
		colaboradorPersistence = new ColaboradorPersistence();
		colaborador = new Colaborador();
		colaborador.setEmail("trunks@sayajin.com");
		colaborador.setDataNascimento(DateUtil.converterStringToCalendar("08/08/1954"));
		colaborador.setNomeCompleto("Trunks sayajin of the future");
		colaborador.setCpf("21000000020");
		colaborador.setCnh("71000000040");
		colaborador.setRg("1100000001");
		colaborador.setDepartamento(departamento);
		colaborador.setRemuneracao(2000.0);
		colaborador.setMatricula("M21H");
		colaborador.setCargo("Software Engineer");
		colaborador.setTelefone(telefone1);
		colaborador.setEndereco(endereco1);
		colaborador.setDepartamento(departamento);
		colaboradorPersistence.save(colaborador);
		
		departamento.getColaboradores().add(colaborador);
		departamentoPersistence.merge(departamento);

	}
	
	@Test
	public void inserirAndroid17() throws Exception {
		
		departamentoPersistence = new DepartamentoPersistence();
	    departamento = departamentoPersistence.findBy(Long.parseLong("8"));
		
		Endereco endereco1 = new Endereco();
		endereco1.setCep("11.568-257");
		endereco1.setRua("R37");
		endereco1.setComplemento("RR corporation");
		endereco1.setLogradouro("N12");
		endereco1.setNumero("174");
		endereco1.setBloco("A-36");
		endereco1.setLote("S-R2");
		endereco1.setCidade("New York");
		endereco1.setUf("EUA");
		
		Telefone telefone1 = new Telefone();
		telefone1.setTelefone("5588-4411");
		telefone1.setTipo("Comercial");
		telefone1.setDDD("56");
		
		colaboradorPersistence = new ColaboradorPersistence();
		colaborador = new Colaborador();
		colaborador.setEmail("android17@redribow.com");
		colaborador.setDataNascimento(DateUtil.converterStringToCalendar("12/12/1955"));
		colaborador.setNomeCompleto("Android 1700");
		colaborador.setCpf("18792217021");
		colaborador.setCnh("17445691641");
		colaborador.setRg("1236645120");
		colaborador.setDepartamento(departamento);
		colaborador.setRemuneracao(2000.0);
		colaborador.setMatricula("M11H");
		colaborador.setCargo("Software Engineer");
		colaborador.setTelefone(telefone1);
		colaborador.setEndereco(endereco1);
		colaborador.setDepartamento(departamento);
		colaboradorPersistence.save(colaborador);
		
		departamento.getColaboradores().add(colaborador);
		departamentoPersistence.merge(departamento);

	}
	
	
	@Test
	public void inserirAndroid18() throws Exception {
		
		departamentoPersistence = new DepartamentoPersistence();
	    departamento = departamentoPersistence.findBy(Long.parseLong("8"));
		
		Endereco endereco1 = new Endereco();
		endereco1.setCep("11.568-257");
		endereco1.setRua("R37");
		endereco1.setComplemento("RR corporation");
		endereco1.setLogradouro("N12");
		endereco1.setNumero("174");
		endereco1.setBloco("A-36");
		endereco1.setLote("S-R2");
		endereco1.setCidade("New York");
		endereco1.setUf("EUA");
		
		Telefone telefone1 = new Telefone();
		telefone1.setTelefone("5589-4417");
		telefone1.setTipo("Comercial");
		telefone1.setDDD("56");
		
		colaboradorPersistence = new ColaboradorPersistence();
		colaborador = new Colaborador();
		colaborador.setEmail("android18@redribow.com");
		colaborador.setDataNascimento(DateUtil.converterStringToCalendar("12/12/1999"));
		colaborador.setNomeCompleto("Android 1800");
		colaborador.setCpf("22792217999");
		colaborador.setCnh("99454691999");
		colaborador.setRg("1266451999");
		colaborador.setDepartamento(departamento);
		colaborador.setRemuneracao(2000.0);
		colaborador.setMatricula("M11H");
		colaborador.setCargo("Machine Engineer");
		colaborador.setTelefone(telefone1);
		colaborador.setEndereco(endereco1);
		colaborador.setDepartamento(departamento);
		colaboradorPersistence.save(colaborador);
		
		departamento.getColaboradores().add(colaborador);
		departamentoPersistence.merge(departamento);

	}
	
	@Test
	public void inserirSakura() throws Exception {
		
		departamentoPersistence = new DepartamentoPersistence();
	    departamento = departamentoPersistence.findBy(Long.parseLong("9"));
		
		Endereco endereco1 = new Endereco();
		endereco1.setCep("99.888-911");
		endereco1.setRua("Mountain Green");
		endereco1.setComplemento("lugar nenhum");
		endereco1.setLogradouro("Vila da folha");
		endereco1.setNumero("934");
		endereco1.setBloco("C43");
		endereco1.setLote("J22");
		endereco1.setCidade("Japan");
		endereco1.setUf("Tokio");
		
		Telefone telefone1 = new Telefone();
		telefone1.setTelefone("4589-2547");
		telefone1.setTipo("Comercial");
		telefone1.setDDD("69");
		
		colaboradorPersistence = new ColaboradorPersistence();
		colaborador = new Colaborador();
		colaborador.setEmail("sakura@konohan.com");
		colaborador.setDataNascimento(DateUtil.converterStringToCalendar("11/11/1999"));
		colaborador.setNomeCompleto("Sakura");
		colaborador.setCpf("72099917022");
		colaborador.setCnh("77855441666");
		colaborador.setRg("5836196333");
		colaborador.setDepartamento(departamento);
		colaborador.setRemuneracao(2000.0);
		colaborador.setMatricula("H1234");
		colaborador.setCargo("Enfermeira");
		colaborador.setTelefone(telefone1);
		colaborador.setEndereco(endereco1);
		colaborador.setDepartamento(departamento);
		colaboradorPersistence.save(colaborador);
		
		departamento.getColaboradores().add(colaborador);
		departamentoPersistence.merge(departamento);

	}
	
	
	@Test
	public void inserirPicolo() throws Exception {
		
		departamentoPersistence = new DepartamentoPersistence();
	    departamento = departamentoPersistence.findBy(Long.parseLong("10"));
		
		Endereco endereco1 = new Endereco();
		endereco1.setCep("71.001-900");
		endereco1.setRua("Mountain Black");
		endereco1.setComplemento("Terras negras");
		endereco1.setLogradouro("SQSS");
		endereco1.setNumero("1234");
		endereco1.setBloco("SC43");
		endereco1.setLote("JH12");
		endereco1.setCidade("Japan");
		endereco1.setUf("Tokio");
		
		Telefone telefone1 = new Telefone();
		telefone1.setTelefone("1009-2549");
		telefone1.setTipo("Comercial");
		telefone1.setDDD("90");
		
		colaboradorPersistence = new ColaboradorPersistence();
		colaborador = new Colaborador();
		colaborador.setEmail("picollo@Namek.com");
		colaborador.setDataNascimento(DateUtil.converterStringToCalendar("11/05/1898"));
		colaborador.setNomeCompleto("Piccolo Daymaoh of Namek");
		colaborador.setCpf("00195917022");
		colaborador.setCnh("00355441647");
		colaborador.setRg("0056196520");
		colaborador.setDepartamento(departamento);
		colaborador.setRemuneracao(2000.0);
		colaborador.setMatricula("K4815");
		colaborador.setCargo("Entregador");
		colaborador.setTelefone(telefone1);
		colaborador.setEndereco(endereco1);
		colaborador.setDepartamento(departamento);
		colaboradorPersistence.save(colaborador);
		
		departamento.getColaboradores().add(colaborador);
		departamentoPersistence.merge(departamento);

	}

}
