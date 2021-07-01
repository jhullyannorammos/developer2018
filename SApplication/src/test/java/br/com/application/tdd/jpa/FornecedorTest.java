package br.com.application.tdd.jpa;
import org.junit.Ignore;
import org.junit.Test;

import br.com.application.domain.embeddable.Endereco;
import br.com.application.domain.embeddable.Telefone;
import br.com.application.domain.Fornecedor;
import br.com.application.enumerator.FornecedorEnum;
import br.com.application.enumerator.MarcasEnum;
import br.com.application.persistence.jpa.FornecedorPersistence;

public class FornecedorTest {
	
	FornecedorPersistence fornecedorPersistence;
	Fornecedor fornecedor;
	
	@Test
	//@Ignore
	public void inserirFabricante() throws Exception {
		
		
		Endereco endereco1 = new Endereco();
		endereco1.setCep("71.219-900");
		endereco1.setRua("Trecho 1");
		endereco1.setComplemento("Guará");
		endereco1.setLogradouro("SMAS");
		endereco1.setNumero("");
		endereco1.setBloco("");
		endereco1.setLote("");
		endereco1.setCidade("Brasília ");
		endereco1.setUf("DF");
		
		Telefone telefone1 = new Telefone();
		telefone1.setTelefone("1001-2547");
		telefone1.setTipo("Comercial");
		telefone1.setDDD("61");
		
		fornecedorPersistence = new FornecedorPersistence();
		fornecedor = new Fornecedor();
		fornecedor.setFornecedor(MarcasEnum.MICROSOFT.toString());
		fornecedor.setAbrangencia(FornecedorEnum.INTERNACIONAL);
		fornecedor.setEndereco(endereco1);
		fornecedor.setTelefone(telefone1);
		fornecedorPersistence.save(fornecedor);
		/* ------------------------------------------------------------------------------------- */
		Endereco endereco2 = new Endereco();
		endereco2.setCep("58-651.301");
		endereco2.setComplemento("Proximo ao megacenter");
		endereco2.setLogradouro("Asa Central");
		endereco2.setNumero("330");
		endereco2.setBloco("B20");
		endereco2.setLote("S23");
		endereco2.setCidade("Brasilia");
		endereco2.setUf("DF");
		
		Telefone telefone2 = new Telefone();
		telefone2.setTelefone("958658214");
		telefone2.setTipo("Comercial");
		telefone2.setDDD("63");
		
		fornecedorPersistence = new FornecedorPersistence();
		fornecedor = new Fornecedor();
		fornecedor.setFornecedor(MarcasEnum.LENOVO.toString());
		fornecedor.setAbrangencia(FornecedorEnum.INTERNACIONAL);
		fornecedor.setEndereco(endereco2);
		fornecedor.setTelefone(telefone2);
		fornecedorPersistence.save(fornecedor);
		/* --------------------------------------------------------------------------------------- */
		Endereco endereco3 = new Endereco();
		endereco3.setCep("76-651.301");
		endereco3.setComplemento("Proximo a Voucher");
		endereco3.setLogradouro("DST Sigma");
		endereco3.setNumero("254");
		endereco3.setBloco("C120");
		endereco3.setLote("K203");
		endereco3.setCidade("Goiania");
		endereco3.setUf("GO");
		
		Telefone telefone3 = new Telefone();
		telefone3.setTelefone("958591147");
		telefone3.setTipo("Comercial");
		telefone3.setDDD("16");
		
		fornecedorPersistence = new FornecedorPersistence();
		fornecedor = new Fornecedor();
		fornecedor.setFornecedor(MarcasEnum.DELL.toString());
		fornecedor.setAbrangencia(FornecedorEnum.INTERNACIONAL);
		fornecedor.setEndereco(endereco3);
		fornecedor.setTelefone(telefone3);
		fornecedorPersistence.save(fornecedor);
		/* -------------------------------------------------------------------------------------------*/
		Endereco endereco4 = new Endereco();
		endereco4.setCep("01.155-040");
		endereco4.setRua("Alameda Olga");
		endereco4.setComplemento("Centro");
		endereco4.setLogradouro("Barra Funda");
		endereco4.setNumero("388");
		endereco4.setBloco("");
		endereco4.setLote("");
		endereco4.setCidade("Sao Paulo");
		endereco4.setUf("SP");
		
		Telefone telefone4 = new Telefone();
		telefone4.setTelefone("3003-0398");
		telefone4.setTipo("Comercial");
		telefone4.setDDD("11");
		
		fornecedorPersistence = new FornecedorPersistence();
		fornecedor = new Fornecedor();
		fornecedor.setFornecedor(MarcasEnum.ASUS.toString());
		fornecedor.setAbrangencia(FornecedorEnum.INTERNACIONAL);
		fornecedor.setEndereco(endereco4);
		fornecedor.setTelefone(telefone4);
		fornecedorPersistence.save(fornecedor);
		/* -------------------------------------------------------------------------------------------*/
		Endereco endereco5 = new Endereco();
		endereco5.setCep("74070-010");
		endereco5.setRua("Av. Independência");
		endereco5.setComplemento("Proximo ao Centro");
		endereco5.setLogradouro("St. Aeroporto");
		endereco5.setNumero("5844");
		endereco5.setBloco("");
		endereco5.setLote("");
		endereco5.setCidade("Goiânia ");
		endereco5.setUf("GO");
		
		Telefone telefone5 = new Telefone();
		telefone5.setTelefone("3221-8200");
		telefone5.setTipo("Comercial");
		telefone5.setDDD("62");
		
		fornecedorPersistence = new FornecedorPersistence();
		fornecedor = new Fornecedor();
		fornecedor.setFornecedor(MarcasEnum.SONY.toString());
		fornecedor.setAbrangencia(FornecedorEnum.INTERNACIONAL);
		fornecedor.setEndereco(endereco5);
		fornecedor.setTelefone(telefone5);
		fornecedorPersistence.save(fornecedor);
		 
	}

}
