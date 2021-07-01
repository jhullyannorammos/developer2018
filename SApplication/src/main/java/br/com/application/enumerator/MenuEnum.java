package br.com.application.enumerator;

public enum MenuEnum {
   
    HOME, 
    USUARIO, 
    PRODUTO, 
    VISUALIZAR, 
    LOGOUT;
	
	public static MenuEnum getMenuEnum(String menu) {
		for(MenuEnum f: MenuEnum.values()) {
			if(f.toString().equals(menu.toUpperCase())) {
				return f;
			}
		}
		return null;
	}
     
}
