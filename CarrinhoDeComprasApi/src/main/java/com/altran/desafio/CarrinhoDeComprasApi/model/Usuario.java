package com.altran.desafio.CarrinhoDeComprasApi.model;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.stereotype.Component;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Document(collection = "user")
@Component
public class Usuario {

	@Id
	private String id;

	@NotNull
	@NotEmpty(message = "Nome é obrigatório")
	private String nome;
	

	@NotNull
	@NotEmpty(message = "E-mail é obrigatório")
	private String email;
	
	private Carrinho carrinho;

}
