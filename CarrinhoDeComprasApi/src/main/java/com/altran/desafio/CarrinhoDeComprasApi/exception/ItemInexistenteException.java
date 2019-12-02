package com.altran.desafio.CarrinhoDeComprasApi.exception;

/**
 * 
 * @author Regiane Mesquita
 *
 */
public class ItemInexistenteException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	public ItemInexistenteException(String msg) {
		super(msg);
	}

}
