package br.com.application.domain;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import br.com.application.enumerator.EstoqueEnum;
import br.com.application.infrastructure.DomainGeneric;

@SuppressWarnings("serial")
@Entity
@Table(name = "estoque")
public class Estoque extends DomainGeneric {
     
	@Enumerated(EnumType.STRING)
    private EstoqueEnum estoque;
	
    @Column(name = "quantidade")
    private long quantidade;
    
    @Column(name = "modelo", unique = true)
    private String modelo;
    
    @OneToMany(mappedBy = "estoque", fetch = FetchType.EAGER)
	private List<Mercadoria> mercadorias;
    
    public Estoque(String modelo, EstoqueEnum estoque, List<Mercadoria> mercadorias, Long quantidade) {
    	this.mercadorias = mercadorias;
    	this.quantidade = quantidade;
    	this.estoque = estoque;
    	this.modelo = modelo;
	}
    
    public Estoque() {
		
	}

	public EstoqueEnum getEstoque() {
		return estoque;
	}

	public void setEstoque(EstoqueEnum estoque) {
		this.estoque = estoque;
	}

	public long getQuantidade() {
		return quantidade;
	}

	public void setQuantidade(long quantidade) {
		this.quantidade = quantidade;
	}

	public String getModelo() {
		return modelo;
	}

	public void setModelo(String modelo) {
		this.modelo = modelo;
	}

	public List<Mercadoria> getMercadorias() {
		return mercadorias;
	}

	public void setMercadorias(List<Mercadoria> mercadorias) {
		this.mercadorias = mercadorias;
	}
    
    
    

}
