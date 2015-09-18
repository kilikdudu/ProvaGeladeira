package br.com.carloseduardo.spring.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.com.carloseduardo.spring.dao.ProdutoDAO;
import br.com.carloseduardo.spring.dao.TipoDAO;
import br.com.carloseduardo.spring.model.Produto;
import br.com.carloseduardo.spring.model.Tipo;

@Service
public class TipoServiceImpl implements TipoService {
	
	private TipoDAO tipoDAO;

	public void setTipoDAO(TipoDAO tipoDAO) {
		this.tipoDAO = tipoDAO;
	}

	@Override
	@Transactional
	public List<Tipo> listTipo() {
		return this.tipoDAO.listTipo();
	}

}
