package br.com.application.domain.embeddable;

import java.io.Serializable;

import javax.persistence.Embeddable;

@SuppressWarnings("serial")
@Embeddable
public class Caracteristicas implements Serializable {

	private String dimensao;
	private String peso;
	private String cor;
	
	public Caracteristicas(String dimensao, String peso, String cor) {
		this.dimensao = dimensao;
		this.peso = peso;
		this.cor = cor;
	}
	
	public Caracteristicas() {
		
	}
	
	public String getCor() {
		return cor;
	}  
	
	public String getDimensao() {
		return dimensao;
	}
	
	public String getPeso() {
		return peso;
	}
	
	public void setCor(String cor) {
		this.cor = cor;
	}
	
	public void setDimensao(String dimensao) {
		this.dimensao = dimensao;
	}
	
	public void setPeso(String peso) {
		this.peso = peso;
	}
	
}
