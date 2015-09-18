package br.com.carloseduardo.spring.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import br.com.carloseduardo.spring.model.Produto;
import br.com.carloseduardo.spring.model.Tipo;

@Repository
public class TipoDAOImpl implements TipoDAO {
	
	private static final Logger logger = LoggerFactory.getLogger(TipoDAOImpl.class);

	private SessionFactory sessionFactory;
	
	public void setSessionFactory(SessionFactory sf){
		this.sessionFactory = sf;
	}

	@Override
	public List<Tipo> listTipo() {
		Session session = this.sessionFactory.getCurrentSession();
		List<Tipo> tipoList = session.createQuery("from Tipo").list();
		for(Tipo p : tipoList){
			logger.info("Tipos::"+p);
		}
		return tipoList;
	}

	@Override
	public Tipo getTipoById(int id) {
		Session session = this.sessionFactory.getCurrentSession();		
		Tipo t = (Tipo) session.load(Tipo.class, new Integer(id));
		return t;
	}

}
