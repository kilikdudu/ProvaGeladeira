package br.com.carloseduardo.spring.service;

import java.util.List;

import br.com.carloseduardo.spring.model.Marca;
import br.com.carloseduardo.spring.model.Mercado;

public interface MercadoService {

	public void addMercado(Mercado m);
	public void updateMercado(Mercado m);
	public List<Mercado> listMercados();
	public Mercado getMercadoById(int id);
	public void removeMercado(int id);
	
}
