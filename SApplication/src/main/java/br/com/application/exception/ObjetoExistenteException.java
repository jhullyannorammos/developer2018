package br.com.application.exception;

@SuppressWarnings("serial")
public class ObjetoExistenteException extends RuntimeException {

	public ObjetoExistenteException(String message) {
		super(message);
	}
	
	public ObjetoExistenteException(String message, Throwable thrwble) {
		super(message, thrwble);
	}
	
	
}
