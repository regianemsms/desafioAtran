package com.altran.desafio.CarrinhoDeComprasApi.exception;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 
 * @author Regiane Mesquita
 *
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ErrorDetails {
    private int status;
    private String detail;
    private String developerMessage;
}
