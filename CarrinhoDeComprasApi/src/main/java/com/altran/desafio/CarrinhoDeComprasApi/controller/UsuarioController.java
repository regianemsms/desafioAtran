package com.altran.desafio.CarrinhoDeComprasApi.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.PropertySource;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
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
	public ResponseEntity<Usuario> criar(@RequestBody Usuario usuario) {
		System.out.println(usuario);
		
		return  ResponseEntity.status(HttpStatus.CREATED).body(this.service.save(usuario));
	}
	@GetMapping
	public List<Usuario> listar() {
		return this.service.findAll();
	}
	
	
	
}
