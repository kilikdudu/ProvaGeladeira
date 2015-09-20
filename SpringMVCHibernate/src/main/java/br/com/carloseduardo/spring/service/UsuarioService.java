package br.com.carloseduardo.spring.service;

import java.util.List;

import br.com.carloseduardo.spring.model.Tipo;
import br.com.carloseduardo.spring.model.Usuario;

public interface UsuarioService {

	public Usuario getUsuarioById(int id);
	public int loginUsuario(String login, String senha);
	
}
