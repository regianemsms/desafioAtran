package com.altran.desafio.CarrinhoDeComprasApi.services.impl;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import com.altran.desafio.CarrinhoDeComprasApi.exception.UsuarioInexistenteException;
import com.altran.desafio.CarrinhoDeComprasApi.model.Produto;
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
		if(!StringUtils.isEmpty(usuario.getId())){
			usuario = verificarCarrinho(usuario);
		}
		return  repository.save(usuario);
	}
	

	private Usuario verificarCarrinho(Usuario usuario) {
		Usuario userDb = this.findById(usuario.getId());
		Produto prodTela = usuario.getCarrinho().getProdutos().get(0);
		if(userDb.getCarrinho() != null && userDb.getCarrinho().getProdutos() != null) {
			boolean isNotEqual = true;
			for(Produto prod : userDb.getCarrinho().getProdutos()) {
				if(prod.getItem().getId().equals(prodTela.getItem().getId())) {
					prod.setQuantidade(prod.getQuantidade()+ prodTela.getQuantidade());
					isNotEqual = false;
					break;
				}
			}
			if(isNotEqual) {
				userDb.getCarrinho().getProdutos().add(prodTela);
			}
		}else {
			userDb.getCarrinho().setProdutos(new ArrayList(Arrays.asList(prodTela)));
		}
		return userDb;
	}
	
	@Override
	public void delete(String id) {
		if (this.findById(id) != null) {
			this.repository.deleteById(id);
		}
		
	}

	@Override
	public Optional<List<Usuario>> findByName(String nome) {
		return repository.findByNomeIgnoreCaseContaining(nome);
	}

}
