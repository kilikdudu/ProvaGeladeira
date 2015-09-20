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

import br.com.carloseduardo.spring.model.Compra;
import br.com.carloseduardo.spring.model.Marca;
import br.com.carloseduardo.spring.model.ProdutoCompra;
import br.com.carloseduardo.spring.model.Tipo;

@Repository
public class CompraDAOImpl implements CompraDAO {
	
	private static final Logger logger = LoggerFactory.getLogger(CompraDAOImpl.class);

	private SessionFactory sessionFactory;
	
	public void setSessionFactory(SessionFactory sf){
		this.sessionFactory = sf;
	}
	
	private MercadoDAO mercadoDAO;
	@Autowired(required=true)
	@Qualifier(value="mercadoDAO")
	public void setMercadoDAO(MercadoDAO mercadoDAO){
		this.mercadoDAO = mercadoDAO;
	}
	
	private UsuarioDAO usuarioDAO;
	@Autowired(required=true)
	@Qualifier(value="usuarioDAO")
	public void setUsuarioDAO(UsuarioDAO usuarioDAO){
		this.usuarioDAO = usuarioDAO;
	}
	
	@Override
	public void addCompra(Compra c, int mercado_id, int usuario_id) {
		Session session = this.sessionFactory.getCurrentSession();
		System.out.println("Compra: " + c.toString());
		c.setMercado(mercadoDAO.getMercadoById(mercado_id));
		c.setUsuario(usuarioDAO.getUsuarioById(usuario_id));
		session.persist(c);
		logger.info("Compra inserida="+c);
	}

	@Override
	public List<Compra> listCompras(int usuario_id) {
		Session session = this.sessionFactory.getCurrentSession();
		Query query =session.createQuery("from Compra where Usuario_id = :usuario_id");
		query.setParameter("usuario_id",usuario_id);
		List<Compra> ComprasList = query.list();
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

	@Override
	public void updateCompra(Compra c, int mercado_id, int usuario_id) {
		// TODO Auto-generated method stub
		Session session = this.sessionFactory.getCurrentSession();
		c.setMercado(mercadoDAO.getMercadoById(mercado_id));
		c.setUsuario(usuarioDAO.getUsuarioById(usuario_id));
		session.update(c);
	}

	

}
