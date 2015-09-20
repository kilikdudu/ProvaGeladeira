package br.com.carloseduardo.spring.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.com.carloseduardo.spring.dao.GeladeiraDAO;
import br.com.carloseduardo.spring.model.Geladeira;

@Service
public class GeladeiraServiceImpl implements GeladeiraService {

	GeladeiraDAO geladeiraDAO;
	public void setGeladeiraDAO(GeladeiraDAO geladeiraDAO){
		this.geladeiraDAO = geladeiraDAO;
	}
	
	@Override
	@Transactional
	public void addGeladeira(Geladeira g, int usuario_id) {
		this.geladeiraDAO.addGeladeira(g, usuario_id);
	}

	@Override
	@Transactional
	public Geladeira getGeladeiraById(int id) {
		return this.geladeiraDAO.getGeladeiraById(id);
	}

	@Override
	@Transactional
	public void updateGeladeira(Geladeira g, int usuario_id) {
		this.geladeiraDAO.updateGeladeira(g, usuario_id);
	}

	@Override
	@Transactional
	public List<Geladeira> listGeladeiras(int usuario_id) {
		return this.geladeiraDAO.listGeladeiras(usuario_id);
	}

	@Override
	@Transactional
	public void removeGeladeira(int id) {
		this.geladeiraDAO.removeGeladeira(id);
	}
}
