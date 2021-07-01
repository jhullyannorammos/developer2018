package br.com.application.domain;

import java.util.List;
import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import br.com.application.domain.embeddable.Endereco;
import br.com.application.domain.embeddable.Telefone;
import br.com.application.enumerator.FornecedorEnum;
import br.com.application.infrastructure.DomainGeneric;

@SuppressWarnings("serial")
@Entity
@Table(name = "fornecedores")
public class Fornecedor extends DomainGeneric {
	
    @Column(name="fornecedor", unique = true)
    private String fornecedor; 
    
    @Enumerated(EnumType.STRING)
    private FornecedorEnum abrangencia;
    
    @Embedded
    private Endereco endereco;
    
    @Embedded
    private Telefone telefone;
    
    @OneToMany(mappedBy = "fornecedor", fetch = FetchType.EAGER)
    private List<Modelo> modelos;
    
    public Fornecedor(String fornecedor, FornecedorEnum abrangencia, Endereco endereco, Telefone telefone) {
    	this.endereco = endereco;
    	this.telefone = telefone;
    	this.fornecedor = fornecedor;
    	this.abrangencia = abrangencia;
	}
    
    public Fornecedor() {
		
	}

	public String getFornecedor() {
		return fornecedor;
	}

	public void setFornecedor(String fornecedor) {
		this.fornecedor = fornecedor;
	}

	public FornecedorEnum getAbrangencia() {
		return abrangencia;
	}

	public void setAbrangencia(FornecedorEnum abrangencia) {
		this.abrangencia = abrangencia;
	}

	public Endereco getEndereco() {
		return endereco;
	}

	public void setEndereco(Endereco endereco) {
		this.endereco = endereco;
	}

	public Telefone getTelefone() {
		return telefone;
	}

	public void setTelefone(Telefone telefone) {
		this.telefone = telefone;
	}

	public List<Modelo> getModelos() {
		return modelos;
	}

	public void setModelos(List<Modelo> modelos) {
		this.modelos = modelos;
	}
    
    

}
