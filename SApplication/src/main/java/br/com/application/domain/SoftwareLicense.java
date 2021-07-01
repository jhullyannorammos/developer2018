package br.com.application.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import br.com.application.enumerator.SoftwareEnum;
import br.com.application.infrastructure.DomainGeneric;


@SuppressWarnings("serial")

@Entity
@Table(name = "licenses")
public class SoftwareLicense extends DomainGeneric {

	@OneToOne()
	@JoinColumn(name = "patrimonio_id", nullable = true, unique = true)
	private Patrimonio patrimonio;

	@Column(name = "number_key", unique = true, length = 30)
	private String key;

	@Enumerated(EnumType.STRING)
	private SoftwareEnum sistema;

	public SoftwareLicense() {

	}

	public Patrimonio getPatrimonio() {
		return patrimonio;
	}

	public void setPatrimonio(Patrimonio patrimonio) {
		this.patrimonio = patrimonio;
	}

	public String getKey() {
		return key;
	}

	public void setKey(String key) {
		this.key = key;
	}

	public SoftwareEnum getSistema() {
		return sistema;
	}

	public void setSistema(SoftwareEnum sistema) {
		this.sistema = sistema;
	}
	
	

}
