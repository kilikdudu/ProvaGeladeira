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
	public void addCompra(Compra c) {
		// TODO Auto-generated method stub
		this.compraDAO.addCompra(c);
	}

	@Override
	@Transactional
	public List<Compra> listCompras() {
		// TODO Auto-generated method stub
		return this.compraDAO.listCompras();
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

	
	

}
