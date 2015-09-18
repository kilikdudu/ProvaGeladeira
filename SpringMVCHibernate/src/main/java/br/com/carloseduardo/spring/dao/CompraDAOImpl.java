package br.com.carloseduardo.spring.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import br.com.carloseduardo.spring.model.Compra;
import br.com.carloseduardo.spring.model.Marca;
import br.com.carloseduardo.spring.model.Marca;
import br.com.carloseduardo.spring.model.Tipo;

@Repository
public class CompraDAOImpl implements CompraDAO {
	
	private static final Logger logger = LoggerFactory.getLogger(CompraDAOImpl.class);

	private SessionFactory sessionFactory;
	
	public void setSessionFactory(SessionFactory sf){
		this.sessionFactory = sf;
	}

	@Override
	public void addCompra(Compra c) {
		Session session = this.sessionFactory.getCurrentSession();
		session.persist(c);
		logger.info("Compra inserida="+c);
	}

	@Override
	public List<Compra> listCompras() {
		Session session = this.sessionFactory.getCurrentSession();
		List<Compra> ComprasList = session.createQuery("from Compra").list();
		for(Compra c : ComprasList){
			logger.info("Compras::"+c);
		}
		return ComprasList;
	}

	@Override
	public Compra getCompraById(int id) {
		Session session = this.sessionFactory.getCurrentSession();		
		Compra c = (Compra) session.load(Compra.class, new Integer(id));
		logger.info("Marca recuperada="+c);
		return c;
	}

	@Override
	public void removeCompra(int id) {
		Session session = this.sessionFactory.getCurrentSession();
		Compra c= (Compra) session.load(Compra.class, new Integer(id));
		if(null != c){
			session.delete(c);
		}
		logger.info("Marca deletada="+c);
	}

	

}
