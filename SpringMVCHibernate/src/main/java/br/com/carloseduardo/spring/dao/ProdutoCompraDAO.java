package br.com.carloseduardo.spring.dao;

import java.util.List;

import br.com.carloseduardo.spring.model.Marca;
import br.com.carloseduardo.spring.model.ProdutoCompra;

public interface ProdutoCompraDAO {

	public void addProdutoCompra(ProdutoCompra pc, int produto_id, int compra_id, int usuario_id);
	public void updateProdutoCompra(ProdutoCompra pc, int produto_id, int compra_id, int usuario_id);
	public void consumirProdutoCompra();
	public List<ProdutoCompra> listProdutosCompras();
	public Marca getProdutoCompraById(int id);
	public void removeProdutoCompra(int id);
	
}
