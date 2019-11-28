package com.altran.desafio.CarrinhoDeComprasApi.utils;

import java.util.Locale;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Configuration;

/**
 * 
 * @author Regiane Mesquita
 *
 */
@Configuration
public class MessageUtil {

	@Autowired
	private MessageSource messageSource;

	public String getMessage(String msg, String... values) {
		return messageSource.getMessage(msg, values, Locale.getDefault());
	}
}
