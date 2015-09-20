package br.com.carloseduardo.spring.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.com.carloseduardo.spring.dao.MarcaDAO;
import br.com.carloseduardo.spring.dao.MercadoDAO;
import br.com.carloseduardo.spring.model.Marca;
import br.com.carloseduardo.spring.model.Mercado;

@Service
public class MercadoServiceImpl implements MercadoService {
	
	private MercadoDAO mercadoDAO;

	public void setMercadoDAO(MercadoDAO mercadoDAO) {
		this.mercadoDAO = mercadoDAO;
	}

	@Override
	@Transactional
	public void addMercado(Mercado m) {
		// TODO Auto-generated method stub
		this.mercadoDAO.addMercado(m);
	}

	@Override
	@Transactional
	public void updateMercado(Mercado m) {
		// TODO Auto-generated method stub
		this.mercadoDAO.updateMercado(m);
	}

	@Override
	@Transactional
	public List<Mercado> listMercados() {
		// TODO Auto-generated method stub
		return this.mercadoDAO.listMercados();
	}

	@Override
	@Transactional
	public Mercado getMercadoById(int id) {
		// TODO Auto-generated method stub
		return this.mercadoDAO.getMercadoById(id);
	}

	@Override
	@Transactional
	public void removeMercado(int id) {
		// TODO Auto-generated method stub
		this.mercadoDAO.removeMercado(id);
	}

	
	

}
