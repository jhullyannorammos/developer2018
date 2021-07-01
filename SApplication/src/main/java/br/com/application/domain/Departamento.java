package br.com.application.domain;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import br.com.application.infrastructure.DomainGeneric;

@SuppressWarnings("serial")
@Entity
@Table(name = "departamentos")
public class Departamento extends DomainGeneric {

	@Column(name = "departamento")
	private String departamento;

	@Column(name = "sigla", unique = true)
	private String sigla;

	@Column(name = "hierarquia")
	private String hierarquia;
	
	@Column(name = "localidade")
	private String localidade;

	@OneToMany(mappedBy = "departamento", fetch = FetchType.EAGER)
	private List<Colaborador> colaboradores;

	public Departamento() {

	}

	public String getDepartamento() {
		return departamento;
	}

	public void setDepartamento(String departamento) {
		this.departamento = departamento;
	}

	public String getSigla() {
		return sigla;
	}

	public void setSigla(String sigla) {
		this.sigla = sigla;
	}

	public String getHierarquia() {
		return hierarquia;
	}

	public void setHierarquia(String hierarquia) {
		this.hierarquia = hierarquia;
	}

	public String getLocalidade() {
		return localidade;
	}

	public void setLocalidade(String localidade) {
		this.localidade = localidade;
	}

	public List<Colaborador> getColaboradores() {
		return colaboradores;
	}

	public void setColaboradores(List<Colaborador> colaboradores) {
		this.colaboradores = colaboradores;
	}

	

}
