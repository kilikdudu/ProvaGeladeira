package br.com.carloseduardo.spring.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.com.carloseduardo.spring.dao.MarcaDAO;
import br.com.carloseduardo.spring.model.Marca;

@Service
public class MarcaServiceImpl implements MarcaService {
	
	private MarcaDAO marcaDAO;

	public void setMarcaDAO(MarcaDAO marcaDAO) {
		this.marcaDAO = marcaDAO;
	}

	@Override
	@Transactional
	public void addMarca(Marca m) {
		this.marcaDAO.addMarca(m);
	}

	@Override
	@Transactional
	public void updateMarca(Marca m) {
		this.marcaDAO.updateMarca(m);
	}

	@Override
	@Transactional
	public List<Marca> listMarcas() {
		// TODO Auto-generated method stub
		return this.marcaDAO.listMarcas();
	}

	@Override
	@Transactional
	public Marca getMarcaById(int id) {
		// TODO Auto-generated method stub
		return this.marcaDAO.getMarcaById(id);
	}

	@Override
	@Transactional
	public void removeMarca(int id) {
		// TODO Auto-generated method stub
		this.marcaDAO.removeMarca(id);
	}
	

}
