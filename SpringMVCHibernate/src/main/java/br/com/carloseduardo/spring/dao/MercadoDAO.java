package br.com.carloseduardo.spring.dao;

import java.util.List;


import br.com.carloseduardo.spring.model.Mercado;

public interface MercadoDAO {

	public void addMercado(Mercado m);
	public void updateMercado(Mercado m);
	public List<Mercado> listMercados();
	public Mercado getMercadoById(int id);
	public void removeMercado(int id);
	
}
