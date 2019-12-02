package com.altran.desafio.CarrinhoDeComprasApi.services;

import java.util.List;
import java.util.Optional;

import com.altran.desafio.CarrinhoDeComprasApi.model.Item;

public interface ItemService {

	List<Item> findAll() ;

	Item findById(String id) ;
    
	Item save(Item modal) ;
    
	void delete(String id);
    
	Optional<List<Item>> findByName(String name);

}
