package com.altran.desafio.CarrinhoDeComprasApi.services.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.altran.desafio.CarrinhoDeComprasApi.exception.ItemInexistenteException;
import com.altran.desafio.CarrinhoDeComprasApi.model.Item;
import com.altran.desafio.CarrinhoDeComprasApi.repository.ItemRepository;
import com.altran.desafio.CarrinhoDeComprasApi.services.ItemService;
import com.altran.desafio.CarrinhoDeComprasApi.utils.MessageUtil;

import lombok.Synchronized;

/**
 * 
 * @author Regiane Mesquita
 *
 */
@Service
public class ItemServiceImpl implements ItemService{

	
	@Autowired
	ItemRepository repository;
	
	@Autowired
	private MessageUtil message;
	
	@Override
	public List<Item> findAll() {
		return repository.findAll();
	}

	@Override
	public Item findById(String id) {
		return exists(repository.findById(id));
	}

	private Item exists(Optional<Item> item) {
		return item.orElseThrow(
				() -> new ItemInexistenteException(message.getMessage("mensagem.erro.item.inexistente")));
	}
	
	@Override
	public @Synchronized Item save(Item item) {
		return repository.save(item);
	}
	

	@Override
	public @Synchronized void delete(String id) {
		if (this.findById(id) != null) {
			this.repository.deleteById(id);
		}
		
	}

	@Override
	public Optional<List<Item>> findByName(String nome) {
		return repository.findByNomeIgnoreCaseContaining(nome);
	}

}
