package com.altran.desafio.CarrinhoDeComprasApi.services.impl;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import com.altran.desafio.CarrinhoDeComprasApi.exception.UsuarioInexistenteException;
import com.altran.desafio.CarrinhoDeComprasApi.exception.UsuarioJaExistenteException;
import com.altran.desafio.CarrinhoDeComprasApi.model.Produto;
import com.altran.desafio.CarrinhoDeComprasApi.model.Usuario;
import com.altran.desafio.CarrinhoDeComprasApi.repository.UsuarioRepository;
import com.altran.desafio.CarrinhoDeComprasApi.services.UsuarioService;
import com.altran.desafio.CarrinhoDeComprasApi.utils.MessageUtil;

import lombok.Synchronized;


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
	public @Synchronized Usuario save(Usuario usuario) {
		verificaNomeUsuarioExistente(usuario);
		if(!StringUtils.isEmpty(usuario.getId())){
			usuario = verificarCarrinho(usuario);
		}
		return repository.save(usuario); 
	}
	
	private void verificaNomeUsuarioExistente(Usuario usuario) {
		Usuario userDb = repository.findByNome(usuario.getNome());
		boolean existsUser =userDb != null;
		boolean update = existsUser && usuario.getId() != null && !usuario.getId().equals(userDb.getId());
		boolean newy = existsUser && usuario.getId() == null && userDb.getId() != null;
		
		if(update || newy) {
			throw new UsuarioJaExistenteException(message.getMessage("mensagem.erro.usuario.existente"));
		}
		
	}
	

	private Usuario verificarCarrinho(Usuario usuario) {
		
		if(isCarrinhoVazio(usuario)) {
			return usuario;
		}
		
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
			userDb.getCarrinho().setProdutos(new ArrayList<Produto>(Arrays.asList(prodTela)));
		}
		return userDb;
	}
	
	private boolean isCarrinhoVazio(Usuario usuario) {
		return !(usuario.getCarrinho() != null && usuario.getCarrinho().getProdutos() != null && !usuario.getCarrinho().getProdutos().isEmpty()) ;
	}
	
	@Override
	public @Synchronized void delete(String id) {
		if (this.findById(id) != null) {
			this.repository.deleteById(id);
		}
		
	}
	
	@Override
	public @Synchronized void deleteProduto(String idProduto, String idUsuario) {
		Usuario usuarioDb = this.findById(idUsuario);
		for(Produto prod : usuarioDb.getCarrinho().getProdutos()) {
			if(idProduto.equals(prod.getItem().getId())) {
				usuarioDb.getCarrinho().getProdutos().remove(prod);
				break;
			}
		}
		this.repository.save(usuarioDb);
	}

	@Override
	public Optional<List<Usuario>> findByName(String nome) {
		return repository.findByNomeIgnoreCaseContaining(nome);
	}

}
