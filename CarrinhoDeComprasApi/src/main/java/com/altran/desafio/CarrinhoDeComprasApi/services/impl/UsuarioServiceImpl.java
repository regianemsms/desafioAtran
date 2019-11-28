package com.altran.desafio.CarrinhoDeComprasApi.services.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.altran.desafio.CarrinhoDeComprasApi.exception.UsuarioInexistenteException;
import com.altran.desafio.CarrinhoDeComprasApi.model.Usuario;
import com.altran.desafio.CarrinhoDeComprasApi.repository.UsuarioRepository;
import com.altran.desafio.CarrinhoDeComprasApi.services.UsuarioService;
import com.altran.desafio.CarrinhoDeComprasApi.utils.MessageUtil;

/**
 * 
 * @author Regiane Mesquita
 *
 */
@Service
public class UsuarioServiceImpl implements UsuarioService{

	
	@Autowired
	UsuarioRepository repository;
	
	@Autowired
	private MessageUtil message;
	
	@Override
	public List<Usuario> findAll() {
		return repository.findAll();
	}

	@Override
	public Usuario findById(String id) {
		return exists(repository.findById(id));
	}

	private Usuario exists(Optional<Usuario> usuario) {
		return usuario.orElseThrow(
				() -> new UsuarioInexistenteException(message.getMessage("mensagem.erro.usuario.inexistente")));
	}
	
	@Override
	public Usuario save(Usuario usuario) {
		return repository.save(usuario);
	}

	@Override
	public void delete(String id) {
		if (this.findById(id) != null) {
			this.repository.deleteById(id);
		}
		
	}

	@Override
	public Optional<List<Usuario>> findByNome(String nome) {
		return repository.findByNomeIgnoreCaseContaining(nome);
	}

}
