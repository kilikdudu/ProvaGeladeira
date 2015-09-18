package br.com.carloseduardo.spring.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import br.com.carloseduardo.spring.model.Geladeira;
import br.com.carloseduardo.spring.model.Produto;
import br.com.carloseduardo.spring.model.Tipo;

@Repository
public class GeladeiraDAOImpl implements GeladeiraDAO {
	
	private static final Logger logger = LoggerFactory.getLogger(GeladeiraDAOImpl.class);

	private SessionFactory sessionFactory;
	
	public void setSessionFactory(SessionFactory sf){
		this.sessionFactory = sf;
	}

	@Override
	public Geladeira getGeladeiraById(int id) {
		Session session = this.sessionFactory.getCurrentSession();		
		Geladeira g = (Geladeira) session.load(Geladeira.class, new Integer(id));
		return g;
	}

}
