package br.com.carloseduardo.spring.dao;

import java.util.List;

import br.com.carloseduardo.spring.model.Compra;

public interface CompraDAO {

	public void addCompra(Compra c);
	public List<Compra> listCompras();
	public Compra getCompraById(int id);
	public void removeCompra(int id);
	
}
