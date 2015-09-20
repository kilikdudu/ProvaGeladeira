package br.com.carloseduardo.spring.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.com.carloseduardo.spring.dao.ProdutoCompraDAO;
import br.com.carloseduardo.spring.model.ProdutoCompra;

@Service
public class ProdutoCompraServiceImpl implements ProdutoCompraService {
	
	private ProdutoCompraDAO produtocompraDAO;

	public void setProdutocompraDAO(ProdutoCompraDAO produtocompraDAO) {
		this.produtocompraDAO = produtocompraDAO;
	}

	@Override
	@Transactional
	public void addProdutoCompra(ProdutoCompra pc, int produto_id, int compra_id, int geladeira_id) {
		// TODO Auto-generated method stub
		this.produtocompraDAO.addProdutoCompra(pc, produto_id, compra_id, geladeira_id);
	}

	@Override
	@Transactional
	public void consumirProdutoCompra(int id) {
		// TODO Auto-generated method stub
		this.produtocompraDAO.consumirProdutoCompra(id);
	}

	@Override
	@Transactional
	public List<ProdutoCompra> listProdutosCompras(int geladeira_id) {
		// TODO Auto-generated method stub
		return this.produtocompraDAO.listProdutosCompras(geladeira_id);
	}

	@Override
	@Transactional
	public void removeProdutoCompra(int id) {
		// TODO Auto-generated method stub
		this.produtocompraDAO.removeProdutoCompra(id);
	}

	@Override
	@Transactional
	public List<ProdutoCompra> listProdutosCompras(int geladeira_id, int compra_id) {
		// TODO Auto-generated method stub
		return this.produtocompraDAO.listProdutosCompras(geladeira_id, compra_id);
	}

}
