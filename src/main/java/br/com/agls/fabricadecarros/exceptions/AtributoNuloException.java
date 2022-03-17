package br.com.agls.fabricadecarros.exceptions;

public class AtributoNuloException extends RuntimeException{

	private static final long serialVersionUID = 1L;
	
	public AtributoNuloException(String mensagem) {
		super(mensagem);
	}
}
