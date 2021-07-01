package br.com.application.persistence.dao;

import br.com.application.domain.Usuario;

public interface LoginDao {
	Usuario recoveryPassword(String logon, String password);
	Usuario resetPassword(Usuario usuario);
	Usuario getUsuario(String logon, String password);
	Boolean getUsuario(String logon);
}
