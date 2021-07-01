package br.com.application.enumerator;

public enum EstoqueEnum {

	ELETRONICOS,
	CONFECÇAO,
	CALÇADOS,
	BEBIDAS,
	CEREAIS,
	MOVEIS,
	INFORMÁTICA,
	MUSICAIS,
	FARMACIA,
	FRIOS;
	
	public static EstoqueEnum getEstoqueEnum(String estoque) {
		for(EstoqueEnum e: EstoqueEnum.values()) {
			if(e.toString().equals(estoque.toUpperCase())) {
				return e;
			}
		}
		return null;
	}
	
}