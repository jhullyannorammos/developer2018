package br.com.application.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import br.com.application.infrastructure.DomainGeneric;

@SuppressWarnings("serial")
@Table(name="cidades")

@Entity
public class Cidade extends DomainGeneric {
	
	@Column(length = 20, nullable = false, unique = true)
	private String cidade;
	
	@Column(length = 20)
	private String federacao;
	
	@Column(length = 2)
	private String sigla;
	
	@Column(length = 20)
	private boolean capital;
	
	public Cidade() {
		
	}
	
	public String getCidade() {
		return cidade;
	}
	
	public String getFederacao() {
		return federacao;
	}
	
	public String getSigla() {
		return sigla;
	}
	
	public boolean isCapital() {
		return capital;
	}
	
	public void setCidade(String cidade) {
		this.cidade = cidade;
	}
	
	public void setFederacao(String federacao) {
		this.federacao = federacao;
	}
	
	public void setCapital(boolean capital) {
		this.capital = capital;
	}
	
	public void setSigla(String sigla) {
		this.sigla = sigla;
	}

}
