package com.altran.desafio.CarrinhoDeComprasApi.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.altran.desafio.CarrinhoDeComprasApi.model.Item;

public interface ItemRepository extends MongoRepository<Item, String>{
	
	Optional<List<Item>> findByNome(String nome);
	Optional<List<Item>> findByNomeIgnoreCaseContaining(String nome);

}
