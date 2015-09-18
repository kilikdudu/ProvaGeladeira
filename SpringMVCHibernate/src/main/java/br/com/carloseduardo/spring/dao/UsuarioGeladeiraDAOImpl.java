package br.com.carloseduardo.spring.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import br.com.carloseduardo.spring.model.Geladeira;
import br.com.carloseduardo.spring.model.Produto;
import br.com.carloseduardo.spring.model.UsuarioGeladeira;
import br.com.carloseduardo.spring.service.MarcaService;

@Repository
public class UsuarioGeladeiraDAOImpl implements UsuarioGeladeiraDAO {
	
	private static final Logger logger = LoggerFactory.getLogger(UsuarioGeladeiraDAOImpl.class);
	
	private UsuarioDAO usuarioDAO;
	@Autowired(required=true)
	@Qualifier(value="usuarioDAO")
	public void setUsuarioDAO(UsuarioDAO usu){
		this.usuarioDAO = usu;
	}
	
	private GeladeiraDAO geladeiraDAO;
	@Autowired(required=true)
	@Qualifier(value="geladeiraDAO")
	public void setUsuarioDAO(GeladeiraDAO ge){
		this.geladeiraDAO = ge;
	}
	
	private SessionFactory sessionFactory;
	
	public void setSessionFactory(SessionFactory sf){
		this.sessionFactory = sf;
	}

	@Override
	public void addGeladeiraUsuario(int geladeira_id, int usuario_id) {

		Session session = this.sessionFactory.getCurrentSession();
		UsuarioGeladeira ug = new UsuarioGeladeira(usuarioDAO.getUsuarioById(usuario_id), geladeiraDAO.getGeladeiraById(geladeira_id));
		session.persist(ug);
		logger.info("Geladeira inserida="+ug);
	}

	@Override
	public void updateGeladeiraUsuario(Produto p, int Tipo_id, int Marca_id) {
		Session session = this.sessionFactory.getCurrentSession();
		
	}

	@Override
	public List<Geladeira> listGeladeiras() {
		Session session = this.sessionFactory.getCurrentSession();
		List<Produto> produtosList = session.createQuery("from Produto").list();
		for(Produto p : produtosList){
			logger.info("Produtos::"+p);
		}
		return null;
	}

	@Override
	public UsuarioGeladeira getUsuarioGeladeiraById(int geladeira_id, int usuario_id) {
		return null;
	}

	@Override
	public void removeUsuarioGeladeira(int geladeira_id, int usuario_id) {
		
	}

}
