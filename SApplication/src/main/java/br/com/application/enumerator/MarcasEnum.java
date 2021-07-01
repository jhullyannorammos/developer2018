package br.com.application.enumerator;

public enum MarcasEnum {

	MICROSOFT(1), 
	GIGABYTE(1),
	CADENCE(2),
	SAMSUNG(3),
	TOSHIBA(4),
	PHILCO(5),
	LENOVO(6),
	RAZER(7),
	APPLE(7),
	ASUS(8),
	ACER(8),
	DELL(9), 
	SONY(10),
	AOC(11),
	JBL(12),
	MSI(12),
	HP(13), 
	LG(14);
	
	public static MarcasEnum getMarcasEnum(String marcas) {
		for(MarcasEnum f: MarcasEnum.values()) {
			if(f.toString().equals(marcas.toUpperCase())) {
				return f;
			}
		}
		return null;
	}
	
	private final int valor;
    MarcasEnum(int valorOpcao){
        valor = valorOpcao;
    }
    
    public int getValor(){
        return valor;
    }
    
}
