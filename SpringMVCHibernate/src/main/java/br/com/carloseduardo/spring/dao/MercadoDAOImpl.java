package br.com.carloseduardo.spring.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import br.com.carloseduardo.spring.model.Mercado;

@Repository
public class MercadoDAOImpl implements MercadoDAO {
	
	private static final Logger logger = LoggerFactory.getLogger(MarcaDAOImpl.class);
	
	private SessionFactory sessionFactory;
	
	public void setSessionFactory(SessionFactory sf){
		this.sessionFactory = sf;
	}

	@Override
	public void addMercado(Mercado m) {
		// TODO Auto-generated method stub
		Session session = this.sessionFactory.getCurrentSession();
		session.persist(m);
	}

	@Override
	public void updateMercado(Mercado m) {
		// TODO Auto-generated method stub
		Session session = this.sessionFactory.getCurrentSession();
		session.update(m);
	}

	@Override
	public List<Mercado> listMercados() {
		// TODO Auto-generated method stub
		Session session = this.sessionFactory.getCurrentSession();
		List<Mercado> MercadosList = session.createQuery("from Mercado").list();
		return MercadosList;
	}

	@Override
	public Mercado getMercadoById(int id) {
		Session session = this.sessionFactory.getCurrentSession();		
		Mercado m = (Mercado) session.load(Mercado.class, new Integer(id));
		logger.info("Mercado recuperado="+m);
		return m;
	}

	@Override
	public void removeMercado(int id) {
		Session session = this.sessionFactory.getCurrentSession();
		Mercado m= (Mercado) session.load(Mercado.class, new Integer(id));
		if(null != m){
			session.delete(m);
		}
	}

	

}
