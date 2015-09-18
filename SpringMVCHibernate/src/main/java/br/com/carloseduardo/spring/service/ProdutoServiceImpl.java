package br.com.carloseduardo.spring.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.com.carloseduardo.spring.dao.ProdutoDAO;
import br.com.carloseduardo.spring.model.Produto;

@Service
public class ProdutoServiceImpl implements ProdutoService {
	
	private ProdutoDAO produtoDAO;

	public void setProdutoDAO(ProdutoDAO produtoDAO) {
		this.produtoDAO = produtoDAO;
	}

	@Override
	@Transactional
	public void addProduto(Produto p, int Tipo_id, int Marca_id) {
		this.produtoDAO.addProduto(p, Tipo_id, Marca_id);
	}

	@Override
	@Transactional
	public void updateProduto(Produto p, int Tipo_id, int Marca_id) {
		this.produtoDAO.updateProduto(p, Tipo_id, Marca_id);
	}

	@Override
	@Transactional
	public List<Produto> listProdutos() {
		return this.produtoDAO.listProdutos();
	}

	@Override
	@Transactional
	public Produto getProdutoById(int id) {
		return this.produtoDAO.getProdutoById(id);
	}

	@Override
	@Transactional
	public void removeProduto(int id) {
		this.produtoDAO.removeProduto(id);
	}

}
