package br.com.application.enumerator;

public enum UsuarioStatus {
	
	BLOQUEADO,
	INATIVO,
	ATIVO;
	
	public static UsuarioStatus getUsuarioStatus(String usuario) {
		for(UsuarioStatus u: UsuarioStatus.values()) {
			if(u.toString().equals(usuario.toUpperCase())) {
				return u;
			}
		}
		return null;
	}

}
