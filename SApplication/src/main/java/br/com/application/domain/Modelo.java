package br.com.application.domain;

import br.com.application.domain.embeddable.Caracteristicas;
import br.com.application.infrastructure.DomainGeneric;

import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@SuppressWarnings("serial")
@Entity
@Table(name="modelos")
public class Modelo extends DomainGeneric{
    
	@ManyToOne()
	@JoinColumn(name = "fornecedor_id", nullable = false)
    private Fornecedor fornecedor; 
    
    @Column(name="modelo", unique = true)
    private String modelo;
    
    @Column(name="lancamento")
    private String lancamento; 
    
    @Embedded
    private Caracteristicas caracteristicas; 

    public Modelo(Fornecedor fornecedor, String modelo, String lancamento, Caracteristicas caracteristicas) {
    	this.caracteristicas = caracteristicas;
    	this.fornecedor = fornecedor;
    	this.lancamento = lancamento;
    	this.modelo = modelo;
    }
    
    public Modelo() {
    	
    }

	public Fornecedor getFornecedor() {
		return fornecedor;
	}

	public void setFornecedor(Fornecedor fornecedor) {
		this.fornecedor = fornecedor;
	}

	public String getModelo() {
		return modelo;
	}

	public void setModelo(String modelo) {
		this.modelo = modelo;
	}

	public String getLancamento() {
		return lancamento;
	}

	public void setLancamento(String lancamento) {
		this.lancamento = lancamento;
	}

	public Caracteristicas getCaracteristicas() {
		return caracteristicas;
	}

	public void setCaracteristicas(Caracteristicas caracteristicas) {
		this.caracteristicas = caracteristicas;
	}
    
    


}
