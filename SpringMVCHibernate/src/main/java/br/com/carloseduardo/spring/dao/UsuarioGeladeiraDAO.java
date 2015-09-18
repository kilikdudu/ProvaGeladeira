package br.com.carloseduardo.spring.dao;

import java.util.List;

import br.com.carloseduardo.spring.model.Geladeira;
import br.com.carloseduardo.spring.model.Produto;
import br.com.carloseduardo.spring.model.UsuarioGeladeira;

public interface UsuarioGeladeiraDAO {

	public void addGeladeiraUsuario(int geladeira_id, int usuario_id);
	public void updateGeladeiraUsuario(Produto p, int Tipo_id, int Marca_id);
	public List<Geladeira> listGeladeiras();
	public UsuarioGeladeira getUsuarioGeladeiraById(int geladeira_id, int usuario_id);
	public void removeUsuarioGeladeira(int geladeira_id, int usuario_id);
}
