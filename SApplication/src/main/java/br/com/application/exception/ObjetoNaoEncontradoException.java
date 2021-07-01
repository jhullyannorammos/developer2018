package br.com.application.exception;

@SuppressWarnings("serial")
public class ObjetoNaoEncontradoException extends RuntimeException {

	public ObjetoNaoEncontradoException(String message) {
		super(message);
	}
	
	public ObjetoNaoEncontradoException(String message, Throwable thrwble) {
		super(message, thrwble);
	}
}
