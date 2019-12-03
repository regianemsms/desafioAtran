package com.altran.desafio.CarrinhoDeComprasApi.controller;

import java.util.List;

import javax.validation.Valid;

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
	public ResponseEntity<Usuario> criar(@Valid @RequestBody Usuario usuario) {
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
	
	@DeleteMapping(path = "/{idProduto}/{idUsuario}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void deleteProd(@PathVariable final String idProduto, @PathVariable final String idUsuario) {
		this.service.deleteProduto(idProduto, idUsuario);
	}
	
	@GetMapping(path = "/{id}")
	public Usuario findById(@PathVariable final String id) {
		return this.service.findById(id);
	}

		
}
