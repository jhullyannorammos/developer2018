package br.com.application.domain;

import br.com.application.enumerator.UsuarioEnum;
import br.com.application.enumerator.UsuarioStatus;
import br.com.application.infrastructure.DomainGeneric;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Table;
@SuppressWarnings("serial")
@Entity
@Table(name="usuarios")
public class Usuario extends DomainGeneric{
       
    @Column(name="username")
    private String username;
   
    @Column(name = "logon", 
            length = 30, 
            unique = true, 
            nullable = false)
    private String email;
    
    @Column(name="password")
    private String password;
    
    @Enumerated(EnumType.STRING) 
    private UsuarioEnum perfil;
    
    @Enumerated(EnumType.STRING) 
    private UsuarioStatus status;

    public Usuario() {
        super(); 
    }

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public UsuarioEnum getPerfil() {
		return perfil;
	}

	public void setPerfil(UsuarioEnum perfil) {
		this.perfil = perfil;
	}

	public UsuarioStatus getStatus() {
		return status;
	}

	public void setStatus(UsuarioStatus status) {
		this.status = status;
	}

    
}
