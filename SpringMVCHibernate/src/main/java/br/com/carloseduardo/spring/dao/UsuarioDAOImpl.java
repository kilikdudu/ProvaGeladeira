package br.com.carloseduardo.spring.dao;



import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import br.com.carloseduardo.spring.model.Usuario;

@Repository
public class UsuarioDAOImpl implements UsuarioDAO {
	
	private static final Logger logger = LoggerFactory.getLogger(UsuarioDAOImpl.class);

	private SessionFactory sessionFactory;
	
	public void setSessionFactory(SessionFactory sf){
		this.sessionFactory = sf;
	}

	@Override
	public Usuario getUsuarioById(int id) {
		Session session = this.sessionFactory.getCurrentSession();		
		Usuario u = (Usuario) session.load(Usuario.class, new Integer(id));
		return u;
	}

}
