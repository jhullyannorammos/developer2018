package br.com.application.domain.embeddable;

import java.io.Serializable;
import java.util.Calendar;

import javax.persistence.Embeddable;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@SuppressWarnings("serial")
@Embeddable
public class Configuracao implements Serializable {

	private boolean bivolt = Boolean.FALSE;
	private boolean unidadeOtica = Boolean.FALSE;
	private String conectividade = "sem conectividade";
	private String armazenamento = "sem armazenamento";
	private String processamento = "sem processamento";
	private Calendar Garantia;
	private String segurança = "sem segurança";
	private String bluethoot = "sem bluethoot";
	private String memoria = "sem memoria";
	private String grafico = "sem grafico";
	private String bateria = "sem bateria";
	private String camera = "sem camera";
	private String tela = "sem tela";
	private String cor = "sem cor";
	private String som = "sem som";
	private String OS = "sem OS";
	
	public Configuracao() {
		
	}
	
	public String getCor() {
		return cor;
	}
	
	public void setCor(String cor) {
		this.cor = cor;
	}
	
	public void setGarantia(Calendar garantia) {
		Garantia = garantia;
	}
	
    @Temporal(TemporalType.DATE)
	public Calendar getGarantia() {
		return Garantia;
	}
	
	public boolean isUnidadeOtica() {
		return unidadeOtica;
	}
	
	public void setUnidadeOtica(boolean unidadeOtica) {
		this.unidadeOtica = unidadeOtica;
	}
	
	public String getSegurança() {
		return segurança;
	}
	
	public String getSom() {
		return som;
	}
	
	public void setSom(String som) {
		this.som = som;
	}
	
	public void setSegurança(String segurança) {
		this.segurança = segurança;
	}
	
	public String getBateria() {
		return bateria;
	}
	
	public void setBateria(String bateria) {
		this.bateria = bateria;
	}
	
	public String getBluethoot() {
		return bluethoot;
	}
	
	public void setBluethoot(String bluethoot) {
		this.bluethoot = bluethoot;
	}
	
	public String getCamera() {
		return camera;
	}
	
	public void setCamera(String camera) {
		this.camera = camera;
	}
	
	public String getConectividade() {
		return conectividade;
	}
	
	public void setConectividade(String conectividade) {
		this.conectividade = conectividade;
	}
	
	public String getGrafico() {
		return grafico;
	}
	
	public void setGrafico(String grafico) {
		this.grafico = grafico;
	}
	
	public String getOS() {
		return OS;
	}
	
	public void setOS(String oS) {
		OS = oS;
	}
	
	public boolean isBivolt() {
		return bivolt;
	}
	
	public String getArmazenamento() {
		return armazenamento;
	}
	
	public String getMemoria() {
		return memoria;
	}
	
	
	public String getProcessamento() {
		return processamento;
	}
	
	public void setProcessamento(String processamento) {
		this.processamento = processamento;
	}
	
	public void setArmazenamento(String armazenamento) {
		this.armazenamento = armazenamento;
	}
	
	public void setBivolt(boolean bivolt) {
		this.bivolt = bivolt;
	}
	
	public void setMemoria(String memoria) {
		this.memoria = memoria;
	}
	
	public void setTela(String tela) {
		this.tela = tela;
	}
	
	public String getTela() {
		return tela;
	}
	
}
