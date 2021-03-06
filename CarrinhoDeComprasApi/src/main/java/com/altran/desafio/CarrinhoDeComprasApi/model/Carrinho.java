package com.altran.desafio.CarrinhoDeComprasApi.model;


import java.util.List;

import org.springframework.data.mongodb.core.mapping.Document;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Getter @Setter
@Document(collection = "carrinho")
public class Carrinho {
	
	  private List<Produto> produtos;

	

}
