package br.com.application.enumerator;

public enum UsuarioEnum {
	
	ADMINISTRADOR(1),
	COLLABORATOR(2),
	SUPPORTE(2),
	EXTERNAL(4);
	
	UsuarioEnum(long valor) {
		UsuarioEnum.getUsuarioEnum(valor);
	}

	public static long getUsuarioEnum(long opcao) {
		long valor = opcao;
		return valor;
	}  

	public static UsuarioEnum getUsuarioEnum(String usuario) {
		for(UsuarioEnum u : UsuarioEnum.values()) {
			if(u.toString().equals(usuario.toUpperCase())) {
				return u;
			}
		}
		return null;
	}

}
