package br.com.application.enumerator;

import javax.persistence.Entity;
import javax.persistence.Table;

public enum MovimentacaoEnum {

	    ENTRADA(1), 
	    SAIDA(2);

	    private int id;
	    private MovimentacaoEnum(int id) {
	        this.id = id;
	    }
	    
	    public static MovimentacaoEnum getMovimentacaoEnum(String movimentacaos) {
			for(MovimentacaoEnum m: MovimentacaoEnum.values()) {
				if(m.toString().equals(movimentacaos.toUpperCase())) {
					return m;
				}
			}
			return null;
		}

	    public static MovimentacaoEnum getType(Integer id) {
	        if (id == null) {
	            return null;
	        }
	        for (MovimentacaoEnum tipoMovimentacao : MovimentacaoEnum.values()) {
	            if (id.equals(tipoMovimentacao.getId())) {
	                return tipoMovimentacao;
	            }
	        }
	        throw new IllegalArgumentException("Não existe nenhum valor correspondente para " + id);
	    }
	    
	    public int getId() {
	        return id;
	    }


	}
