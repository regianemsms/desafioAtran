package com.altran.desafio.CarrinhoDeComprasApi.services;

import java.util.List;
import java.util.Optional;

import com.altran.desafio.CarrinhoDeComprasApi.model.Usuario;

public interface UsuarioService {

	List<Usuario> findAll() ;

	Usuario findById(String id) ;
    
	Usuario save(Usuario modal) ;
    
	void delete(String id);
    
	Optional<List<Usuario>> findByName(String name);
	
	void deleteProduto(String id, String idUsuario);
}
