package com.altran.desafio.CarrinhoDeComprasApi.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.altran.desafio.CarrinhoDeComprasApi.model.Usuario;

public interface UsuarioRepository extends MongoRepository<Usuario, String>{
	
	Usuario findByNome(String nome);
	Optional<List<Usuario>> findByNomeIgnoreCaseContaining(String nome);

}
