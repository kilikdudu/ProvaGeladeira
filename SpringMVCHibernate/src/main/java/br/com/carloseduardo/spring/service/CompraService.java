package br.com.carloseduardo.spring.service;

import java.util.List;

import br.com.carloseduardo.spring.model.Compra;

public interface CompraService {

	public void addCompra(Compra c, int mercado_id, int usuario_id);
	public void updateCompra(Compra c, int mercado_id, int usuario_id);
	public List<Compra> listCompras(int usuario_id);
	public Compra getCompraById(int id);
	public void removeCompra(int id);
	
}
