package com.altran.desafio.CarrinhoDeComprasApi.model;

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
@Document(collection = "produto")
public class Produto {

	private Item item;
	private Integer quantidade;

}
