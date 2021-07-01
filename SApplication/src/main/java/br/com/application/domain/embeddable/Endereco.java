package br.com.application.domain.embeddable;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@SuppressWarnings("serial")
@Embeddable
public class Endereco implements Serializable {
	
	@Column(name="codigo_postal")
    private String cep;
    
    @Column(name="tipo_endereco")
    private String tipo;
    
    @Column(name="rua")
    private String rua; 
    
    @Column(name="logradouro")
    private String logradouro; 
    
    @Column(name="bloco")
    private String bloco;
    
    @Column(name="lote")
    private String lote;
    
    @Column(name="quadra")
    private String quadra;
    
    @Column(name="numero", nullable = true)
    private String numero; 
    
    @Column(name="complemento")
    private String complemento; 
    
    @Column(name="uf")
    private String uf;
    
    @Column(name="cidade")
    private String cidade;
    
    public Endereco(String cep, String tipo, String rua, String logradouro, String bloco, String lote, String quadra, String numero, String complemento, String uf, String cidade) {
		
    	this.complemento = complemento;
    	this.logradouro = logradouro;
    	this.cidade = cidade;
    	this.numero = numero;
    	this.quadra = quadra;
    	this.bloco = bloco;
    	this.lote = lote;
    	this.tipo = tipo;
    	this.cep = cep;
    	this.rua = rua;
    	this.uf = uf;
	}
    
    public Endereco() {
		
	}
    
    public String getCep() {
		return cep;
	}

	public void setCep(String cep) {
		this.cep = cep;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public String getRua() {
		return rua;
	}

	public void setRua(String rua) {
		this.rua = rua;
	}

	public String getLogradouro() {
		return logradouro;
	}

	public void setLogradouro(String logradouro) {
		this.logradouro = logradouro;
	}

	public String getNumero() {
		return numero;
	}

	public void setNumero(String numero) {
		this.numero = numero;
	}

	public String getComplemento() {
		return complemento;
	}

	public void setComplemento(String complemento) {
		this.complemento = complemento;
	}

	public String getUf() {
		return uf;
	}

	public void setUf(String uf) {
		this.uf = uf;
	}

	public String getCidade() {
		return cidade;
	}

	public void setCidade(String cidade) {
		this.cidade = cidade;
	}
    
    public String getBloco() {
		return bloco;
	}
    
    public String getLote() {
		return lote;
	}
    
    public String getQuadra() {
		return quadra;
	}
    
    public void setBloco(String bloco) {
		this.bloco = bloco;
	}  
    
    public void setLote(String lote) {
		this.lote = lote;
	}
    
    public void setQuadra(String quadra) {
		this.quadra = quadra;
	}

}
