package br.com.application.domain.embeddable;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@SuppressWarnings("serial")
@Embeddable
public class Departamento implements Serializable {
	
	@Column(name = "departamento")
	private String departamento;

	@Column(name = "sigla", unique = true)
	private String sigla;

	@Column(name = "hierarquia")
	private String hierarquia;
	
	@Column(name = "localidade", unique = true)
	private String localidade;
	
	public Departamento(String hierarquia, String sigla, String departamento, String localidade) {
		this.departamento = departamento;
		this.hierarquia = hierarquia;
		this.localidade = localidade;
		this.sigla = sigla;
	}
	
    public Departamento() {
		
	}
    
    public String getLocalidade() {
		return localidade;
	}
    
    public void setLocalidade(String localidade) {
		this.localidade = localidade;
	}
    
    public String getDepartamento() {
		return departamento;
	}
    
    public String getHierarquia() {
		return hierarquia;
	}
    
    public String getSigla() {
		return sigla;
	}
    
    public void setDepartamento(String departamento) {
		this.departamento = departamento;
	}  
    
    public void setHierarquia(String hierarquia) {
		this.hierarquia = hierarquia;
	}
    
    public void setSigla(String sigla) {
		this.sigla = sigla;
	}
    

}
