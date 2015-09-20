package br.com.carloseduardo.spring.service;

import java.util.List;

import br.com.carloseduardo.spring.model.ProdutoCompra;

public interface ProdutoCompraService {

	public void addProdutoCompra(ProdutoCompra pc, int produto_id, int compra_id, int geladeira_id);
	public void consumirProdutoCompra(int id);
	public List<ProdutoCompra> listProdutosCompras(int geladeira_id);
	public List<ProdutoCompra> listProdutosCompras(int geladeira_id, int compra_id);
	public void removeProdutoCompra(int id);
	
}
