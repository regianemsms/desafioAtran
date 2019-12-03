package com.altran.desafio.CarrinhoDeComprasApi.exception;

/**
 * 
 * @author Regiane Mesquita
 *
 */
public class UsuarioJaExistenteException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	public UsuarioJaExistenteException(String msg) {
		super(msg);
	}

}
