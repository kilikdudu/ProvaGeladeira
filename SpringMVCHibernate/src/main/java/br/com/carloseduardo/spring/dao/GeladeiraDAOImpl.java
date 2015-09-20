package br.com.carloseduardo.spring.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import br.com.carloseduardo.spring.model.Geladeira;

@Repository
public class GeladeiraDAOImpl implements GeladeiraDAO {
	
	private static final Logger logger = LoggerFactory.getLogger(GeladeiraDAOImpl.class);

	private SessionFactory sessionFactory;
	
	public void setSessionFactory(SessionFactory sf){
		this.sessionFactory = sf;
	}
	
	private UsuarioDAO usuarioDAO;
	@Autowired(required=true)
	@Qualifier(value="usuarioDAO")
	public void setProdutoDAO(UsuarioDAO usuarioDAO){
		this.usuarioDAO = usuarioDAO;
	}
	
	@Override
	public Geladeira getGeladeiraById(int id) {
		Session session = this.sessionFactory.getCurrentSession();		
		Geladeira g = (Geladeira) session.load(Geladeira.class, new Integer(id));
		System.out.println("Geladeira: " + g.toString());
		return g;
	}

	@Override
	public void addGeladeira(Geladeira g, int usuario_id) {
		Session session = this.sessionFactory.getCurrentSession();
		g.setUsuario(this.usuarioDAO.getUsuarioById(usuario_id));
		session.persist(g);
		logger.info("Geladeira inserida="+g);
	}

	@Override
	public void updateGeladeira(Geladeira g, int usuario_id) {
		Session session = this.sessionFactory.getCurrentSession();
		g.setUsuario(this.usuarioDAO.getUsuarioById(usuario_id));
		session.update(g);
		logger.info("GEladeira atualizada="+g);
	}

	@Override
	public List<Geladeira> listGeladeiras(int usuario_id) {
		Session session = this.sessionFactory.getCurrentSession();
		Query query =session.createQuery("from Geladeira where usuario_id = :usuario_id");
		query.setParameter("usuario_id",usuario_id);
		List<Geladeira> GeladeirasList = query.list();
		for(Geladeira g : GeladeirasList){
			logger.info("Geladeiras::"+g);
		}
		return GeladeirasList;
	}

	@Override
	public void removeGeladeira(int id) {
		Session session = this.sessionFactory.getCurrentSession();
		Geladeira g= (Geladeira) session.load(Geladeira.class, new Integer(id));
		if(null != g){
			session.delete(g);
		}
		logger.info("Geladeira deletada="+g);
	}

	

}
