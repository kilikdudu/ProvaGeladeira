package br.com.carloseduardo.spring.service;

import java.util.List;

import br.com.carloseduardo.spring.model.Produto;

public interface ProdutoService {

	public void addProduto(Produto p, int Tipo_id, int Marca_id);
	public void updateProduto(Produto p, int Tipo_id, int Marca_id);
	public List<Produto> listProdutos();
	public Produto getProdutoById(int id);
	public void removeProduto(int id);
	
}
