package com.altran.desafio.CarrinhoDeComprasApi.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.PropertySource;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.altran.desafio.CarrinhoDeComprasApi.model.Item;
import com.altran.desafio.CarrinhoDeComprasApi.services.ItemService;

/**
 * @author Regiane Mesquita
 * 
 * */

@RestController
@RequestMapping("item")
@PropertySource("classpath:messages.properties")
@CrossOrigin(origins = "http://localhost:4200")
public class ItemController {

	@Autowired
	private ItemService service;	
	
	
	@PostMapping 
	public ResponseEntity<Item> criar(@RequestBody Item item) {
		return  ResponseEntity.status(HttpStatus.CREATED).body(this.service.save(item));
	}
	@GetMapping
	public List<Item> listar() {
		return this.service.findAll();
	}

	@DeleteMapping(path = "/{id}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void delete(@PathVariable final String id) {
		this.service.delete(id);
	}
	
	@GetMapping(path = "/{id}")
	public Item findById(@PathVariable final String id) {
		return this.service.findById(id);
	}
}
