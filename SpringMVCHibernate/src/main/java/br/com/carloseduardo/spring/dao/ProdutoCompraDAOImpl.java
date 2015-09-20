package br.com.carloseduardo.spring.dao;

import java.io.Serializable;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import br.com.carloseduardo.spring.model.Mercado;
import br.com.carloseduardo.spring.model.ProdutoCompra;

@Repository
public class ProdutoCompraDAOImpl implements ProdutoCompraDAO {
	
private static final Logger logger = LoggerFactory.getLogger(ProdutoDAOImpl.class);
	
	private CompraDAO compraDAO;
	@Autowired(required=true)
	@Qualifier(value="compraDAO")
	public void setCompraDAO(CompraDAO co){
		this.compraDAO = co;
	}
	
	private ProdutoDAO produtoDAO;
	@Autowired(required=true)
	@Qualifier(value="produtoDAO")
	public void setProdutoDAO(ProdutoDAO pro){
		this.produtoDAO = pro;
	}
	
	private GeladeiraDAO geladeiraDAO;
	@Autowired(required=true)
	@Qualifier(value="geladeiraDAO")
	public void setGeladeiraDAO(GeladeiraDAO ge){
		this.geladeiraDAO = ge;
	}
	
	private SessionFactory sessionFactory;
	
	public void setSessionFactory(SessionFactory sf){
		this.sessionFactory = sf;
	}

	@Override
	public void addProdutoCompra(ProdutoCompra pc, int produto_id, int compra_id, int geladeira_id) {
		// TODO Auto-generated method stub
		Session session = this.sessionFactory.getCurrentSession();
		pc.setProduto(produtoDAO.getProdutoById(produto_id));
		pc.setCompra(compraDAO.getCompraById(compra_id));
		pc.setGeladeira(geladeiraDAO.getGeladeiraById(geladeira_id));
		pc.setConsumido(false);
		session.persist(pc);
		logger.info("ProdutoCompra inserido="+pc);
	}

	@Override
	public List<ProdutoCompra> listProdutosCompras(int geladeira_id) {
		Session session = this.sessionFactory.getCurrentSession();
		Query query =session.createQuery("from ProdutoCompra where Geladeira_id = :geladeira_id");
		query.setParameter("geladeira_id",geladeira_id);
		List<ProdutoCompra> produtosgeladeirasList = query.list();
		for(ProdutoCompra pc : produtosgeladeirasList){
			logger.info("Produto compra::"+pc);
		}
		return produtosgeladeirasList;
	}
	
	@Override
	public List<ProdutoCompra> listProdutosCompras(int geladeira_id, int compra_id) {
		Session session = this.sessionFactory.getCurrentSession();
		Query query =session.createQuery("from ProdutoCompra where Geladeira_id = :geladeira_id and Compra_id = :compra_id");
		query.setParameter("geladeira_id",geladeira_id);
		query.setParameter("compra_id",compra_id);
		List<ProdutoCompra> produtosgeladeirasList = query.list();
		for(ProdutoCompra pc : produtosgeladeirasList){
			logger.info("Produto compra::"+pc);
		}
		return produtosgeladeirasList;
	}

	@Override
	public void removeProdutoCompra(int id) {
		// TODO Auto-generated method stub
		Session session = this.sessionFactory.getCurrentSession();
		ProdutoCompra pc = (ProdutoCompra) session.load(ProdutoCompra.class, new Integer(id));
		if(null != pc){
			session.delete(pc);
		}
		logger.info("Produto Compra deletado="+pc);
	}

	@Override
	public void consumirProdutoCompra(int id) {
		// TODO Auto-generated method stub
		Session session = this.sessionFactory.getCurrentSession();
		ProdutoCompra pc = (ProdutoCompra) session.load(ProdutoCompra.class, new Integer(id));
		if(null != pc){
			pc.setConsumido(true);
			session.update(pc);
		}
	}

}
