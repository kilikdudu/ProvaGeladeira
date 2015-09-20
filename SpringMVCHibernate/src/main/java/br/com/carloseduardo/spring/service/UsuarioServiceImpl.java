package br.com.carloseduardo.spring.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.com.carloseduardo.spring.dao.ProdutoDAO;
import br.com.carloseduardo.spring.dao.TipoDAO;
import br.com.carloseduardo.spring.dao.UsuarioDAO;
import br.com.carloseduardo.spring.model.Produto;
import br.com.carloseduardo.spring.model.Tipo;
import br.com.carloseduardo.spring.model.Usuario;

@Service
public class UsuarioServiceImpl implements UsuarioService {
	
	private UsuarioDAO usuarioDAO;

	public void setUsuarioDAO(UsuarioDAO usuarioDAO) {
		this.usuarioDAO = usuarioDAO;
	}

	@Override
	@Transactional
	public Usuario getUsuarioById(int id) {
		return this.usuarioDAO.getUsuarioById(id);
	}

	@Override
	@Transactional
	public int loginUsuario(String login, String senha) {
		// TODO Auto-generated method stub
		return this.usuarioDAO.loginUsuario(login, senha);
	}

}
