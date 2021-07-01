package br.com.application.enumerator;

public enum FornecedorEnum {

	NACIONAL, 
    INTERNACIONAL;  
	
	public static FornecedorEnum getFornecedorEnum(String fornecedor) {
		for(FornecedorEnum f: FornecedorEnum.values()) {
			if(f.toString().equals(fornecedor.toUpperCase())) {
				return f;
			}
		}
		return null;
	}

	
}
