package br.com.application.domain.embeddable;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@SuppressWarnings("serial")
@Embeddable
public class Telefone implements Serializable {
	
	@Column(name="telefone", length = 9)
    private String telefone;
    
    @Column(name="ddd", length = 2)
    private String DDD;
    
    @Column(name="tipo_fone")    
    private String tipo;
    
    public Telefone(String DDD, String telefone, String tipo) {
		this.telefone = telefone;
		this.tipo = tipo;
    	this.DDD = DDD;
	}
    
    public Telefone() {
		
	}

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	public String getDDD() {
		return DDD;
	}

	public void setDDD(String dDD) {
		DDD = dDD;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}
    
    

}
