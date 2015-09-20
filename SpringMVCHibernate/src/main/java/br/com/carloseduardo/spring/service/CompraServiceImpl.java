package br.com.carloseduardo.spring.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.com.carloseduardo.spring.dao.CompraDAO;
import br.com.carloseduardo.spring.model.Compra;

@Service
public class CompraServiceImpl implements CompraService {
	
	private CompraDAO compraDAO;

	public void setCompraDAO(CompraDAO compraDAO) {
		this.compraDAO = compraDAO;
	}

	@Override
	@Transactional
	public void addCompra(Compra c, int mercado_id, int usuario_id) {
		// TODO Auto-generated method stub
		this.compraDAO.addCompra(c, mercado_id, usuario_id);
	}

	@Override
	@Transactional
	public List<Compra> listCompras(int usuario_id) {
		// TODO Auto-generated method stub
		return this.compraDAO.listCompras(usuario_id);
	}

	@Override
	@Transactional
	public Compra getCompraById(int id) {
		// TODO Auto-generated method stub
		return this.compraDAO.getCompraById(id);
	}

	@Override
	@Transactional
	public void removeCompra(int id) {
		// TODO Auto-generated method stub
		this.compraDAO.removeCompra(id);
	}

	@Override
	public void updateCompra(Compra c, int mercado_id, int usuario_id) {
		// TODO Auto-generated method stub
		this.compraDAO.updateCompra(c, mercado_id, usuario_id);
	}

	
	

}
