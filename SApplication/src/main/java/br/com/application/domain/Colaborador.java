package br.com.application.domain;

import java.util.Calendar;
import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import br.com.application.domain.embeddable.Telefone;
import br.com.application.domain.embeddable.Endereco;
import br.com.application.infrastructure.DomainGeneric;


@SuppressWarnings("serial")
@Table(name="colaboradores")

@Entity
public class Colaborador extends DomainGeneric {

    @Column(name = "email", 
            length = 30, 
            unique = true, 
            nullable = false)
    private String email;
	
    @Column(name="nomecompleto", nullable = false)
	private String NomeCompleto;
	
    @Column(name = "cpf", 
            length = 14, 
            unique = true, 
            nullable = false)
    private String cpf;
    
    @Column(name = "cnh", 
            length = 11, 
            unique = true, 
            nullable = true)
    private String cnh;
    
    @Column(name = "rg", 
            length = 14, 
            unique = true, 
            nullable = true)
    private String rg;
    
    @Temporal(TemporalType.DATE)
    @Column(nullable = false)
    private Calendar dataNascimento;
	
	@Column(name = "matricula", 
			unique = true, 
			nullable = true)
	private String matricula;
	
	@Column(name = "cargo")
	private String cargo;
	
	@Column(name = "remuneracao")
	private double remuneracao;
	
	@Embedded
	private Endereco endereco;
	
	@Embedded
	private Telefone telefone;

	@ManyToOne(fetch=FetchType.EAGER)
	@JoinColumn(name = "departamento_id", nullable = true)
	private Departamento departamento;
	
	@OneToOne()
	private Usuario usuario;
	
	public Colaborador() {
		
	}
	
	public String getCargo() {
		return cargo;
	}
	
	public String getCnh() {
		return cnh;
	}
	
	public String getCpf() {
		return cpf;
	}
	
	public Calendar getDataNascimento() {
		return dataNascimento;
	}
	
	public Departamento getDepartamento() {
		return departamento;
	}
	
	public String getEmail() {
		return email;
	}
	
	public Endereco getEndereco() {
		return endereco;
	}
	
	public String getMatricula() {
		return matricula;
	}
	
	public String getNomeCompleto() {
		return NomeCompleto;
	}
	
	public double getRemuneracao() {
		return remuneracao;
	}
	
	public String getRg() {
		return rg;
	}
	
	public Telefone getTelefone() {
		return telefone;
	}
	
	public Usuario getUsuario() {
		return usuario;
	}
	
	public void setCargo(String cargo) {
		this.cargo = cargo;
	}
	
	public void setCnh(String cnh) {
		this.cnh = cnh;
	}
	
	public void setCpf(String cpf) {
		this.cpf = cpf;
	}
	
	public void setDataNascimento(Calendar dataNascimento) {
		this.dataNascimento = dataNascimento;
	}
	
	public void setDepartamento(Departamento departamento) {
		this.departamento = departamento;
	}
	
	public void setEmail(String email) {
		this.email = email;
	}
	
	public void setEndereco(Endereco endereco) {
		this.endereco = endereco;
	}
	
	public void setMatricula(String matricula) {
		this.matricula = matricula;
	}
	
	public void setNomeCompleto(String nomeCompleto) {
		NomeCompleto = nomeCompleto;
	}
	
	public void setRemuneracao(double remuneracao) {
		this.remuneracao = remuneracao;
	}
	
	public void setRg(String rg) {
		this.rg = rg;
	}
	
	public void setTelefone(Telefone telefone) {
		this.telefone = telefone;
	}
	
	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}
}
