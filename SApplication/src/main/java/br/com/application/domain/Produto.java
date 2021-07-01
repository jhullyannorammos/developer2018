package br.com.application.domain;

import br.com.application.infrastructure.DomainGeneric;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@SuppressWarnings("serial")
@Table(name="produtos")
@Entity
public class Produto extends DomainGeneric{
	
	@OneToOne()
    @JoinColumn(name = "modelo_id", unique=true)
    private Modelo modelo;
	
	@Column(name="valor", nullable = false)
    private double valor;
    
    @Column(name="produto")
    private String produto;

    public Produto() {
		
	}
    
    public Produto(String produto, Modelo modelo, double valor) {
		this.produto = produto;
    	this.modelo = modelo;
    	this.valor = valor;
	}

	public Modelo getModelo() {
		return modelo;
	}

	public void setModelo(Modelo modelo) {
		this.modelo = modelo;
	}

	public double getValor() {
		return valor;
	}

	public void setValor(double valor) {
		this.valor = valor;
	}

	public String getProduto() {
		return produto;
	}

	public void setProduto(String produto) {
		this.produto = produto;
	}
    
    
    
}
