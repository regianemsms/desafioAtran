package com.altran.desafio.CarrinhoDeComprasApi.model;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Document(collection = "item")
@Getter @Setter
@EqualsAndHashCode
public class Item {
	
	@Id
	private String id;

	@NotNull
	@NotEmpty(message = "Nome é obrigatório")
	private String nome;
	

	@NotNull
	@NotEmpty(message = "Valor é obrigatório")
	private Double valor;

}
