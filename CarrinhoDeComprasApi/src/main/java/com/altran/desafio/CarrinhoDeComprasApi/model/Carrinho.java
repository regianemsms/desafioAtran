package com.altran.desafio.CarrinhoDeComprasApi.model;


import java.util.Map;

import org.springframework.data.mongodb.core.mapping.Document;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Document(collection = "carrinho")
public class Carrinho {

	private Map<Integer, Item> itens;

	

}
