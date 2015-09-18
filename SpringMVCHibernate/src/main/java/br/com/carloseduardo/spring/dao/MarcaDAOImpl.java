package br.com.carloseduardo.spring.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import br.com.carloseduardo.spring.model.Marca;
import br.com.carloseduardo.spring.model.Marca;
import br.com.carloseduardo.spring.model.Tipo;

@Repository
public class MarcaDAOImpl implements MarcaDAO {
	
	private static final Logger logger = LoggerFactory.getLogger(MarcaDAOImpl.class);

	private SessionFactory sessionFactory;
	
	public void setSessionFactory(SessionFactory sf){
		this.sessionFactory = sf;
	}

	@Override
	public void addMarca(Marca p) {
		// TODO Auto-generated method stub
		Session session = this.sessionFactory.getCurrentSession();
		session.persist(p);
		logger.info("Marca inserido="+p);
	}

	@Override
	public void updateMarca(Marca m) {
		// TODO Auto-generated method stub
		Session session = this.sessionFactory.getCurrentSession();
		session.update(m);
		logger.info("Marca atualizada="+m);
	}

	@Override
	public List<Marca> listMarcas() {
		// TODO Auto-generated method stub
		Session session = this.sessionFactory.getCurrentSession();
		List<Marca> MarcasList = session.createQuery("from Marca").list();
		for(Marca m : MarcasList){
			logger.info("Marcas::"+m);
		}
		return MarcasList;
	}

	@Override
	public Marca getMarcaById(int id) {
		Session session = this.sessionFactory.getCurrentSession();		
		Marca m = (Marca) session.load(Marca.class, new Integer(id));
		logger.info("Marca recuperada="+m);
		return m;
	}

	@Override
	public void removeMarca(int id) {
		Session session = this.sessionFactory.getCurrentSession();
		Marca m= (Marca) session.load(Marca.class, new Integer(id));
		if(null != m){
			session.delete(m);
		}
		logger.info("Marca deletada="+m);
	}

	

}
