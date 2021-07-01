package br.com.application.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import br.com.application.infrastructure.DomainGeneric;

@SuppressWarnings("serial")
@Entity
@Table(name = "patrimonios")
public class Patrimonio extends DomainGeneric {

	@Column(name = "patrimonio", unique = true)
	private String patrimonio;
	
	@OneToOne()
	@JoinColumn(name = "mercadoria_id", unique = true)
    private Mercadoria mercadoria;
	
	@OneToOne()
	@JoinColumn(name = "sl_id", unique = true)
    private SoftwareLicense softwareLicense;
	
	@Column()
    private boolean sucateado = false;
	
	public Patrimonio() {
		
	}

	public String getPatrimonio() {
		return patrimonio;
	}

	public void setPatrimonio(String patrimonio) {
		this.patrimonio = patrimonio;
	}

	public Mercadoria getMercadoria() {
		return mercadoria;
	}

	public void setMercadoria(Mercadoria mercadoria) {
		this.mercadoria = mercadoria;
	}

	public SoftwareLicense getSoftwareLicense() {
		return softwareLicense;
	}

	public void setSoftwareLicense(SoftwareLicense softwareLicense) {
		this.softwareLicense = softwareLicense;
	}

	public boolean isSucateado() {
		return sucateado;
	}

	public void setSucateado(boolean sucateado) {
		this.sucateado = sucateado;
	}
	
	
}
