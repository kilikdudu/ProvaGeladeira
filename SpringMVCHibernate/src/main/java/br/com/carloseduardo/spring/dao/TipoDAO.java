package br.com.carloseduardo.spring.dao;

import java.util.List;

import br.com.carloseduardo.spring.model.Tipo;

public interface TipoDAO {

	public List<Tipo> listTipo();
	public Tipo getTipoById(int id);
	
}
