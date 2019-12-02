package com.altran.desafio.CarrinhoDeComprasApi.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

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

import com.altran.desafio.CarrinhoDeComprasApi.model.Carrinho;
import com.altran.desafio.CarrinhoDeComprasApi.model.Item;
import com.altran.desafio.CarrinhoDeComprasApi.model.Usuario;
import com.altran.desafio.CarrinhoDeComprasApi.services.UsuarioService;


/**
 * @author Regiane Mesquita
 * 
 * */

@RestController
@RequestMapping("usuario")
@PropertySource("classpath:messages.properties")
@CrossOrigin(origins = "http://localhost:4200")
public class UsuarioController {
	
	@Autowired
	private UsuarioService service;	
	
	
	@PostMapping 
	public ResponseEntity<Usuario> criar(@RequestBody Usuario usuario) {
		return  ResponseEntity.status(HttpStatus.CREATED).body(this.service.save(usuario));
	}
	@GetMapping
	public List<Usuario> listar() {
		 List<Usuario> lista = this.service.findAll();
		return lista;
	}

	@DeleteMapping(path = "/{id}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void delete(@PathVariable final String id) {
		this.service.delete(id);
	}
	
	@GetMapping(path = "/{id}")
	public Usuario findById(@PathVariable final String id) {
		return this.service.findById(id);
	}

	private Usuario testarInclusaoCompleta() {
		Usuario u = new Usuario();
		u.setNome("Teste inclusão completa");
		u.setEmail("teste@gmail.com");
		
		Map<Integer, Item> itens = new HashMap<>();
		itens.put(1, new Item(null, "Carrinho",3.20));
		itens.put(2, new Item(null, "Boneca",5.20));
		itens.put(3, new Item(null, "Pipa",5.20));

		u.setCarrinho(new Carrinho(itens));
		
		return u;
	}
		
}
