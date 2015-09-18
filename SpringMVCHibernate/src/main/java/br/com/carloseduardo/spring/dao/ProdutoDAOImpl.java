package br.com.carloseduardo.spring.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import br.com.carloseduardo.spring.model.Produto;
import br.com.carloseduardo.spring.service.MarcaService;

@Repository
public class ProdutoDAOImpl implements ProdutoDAO {
	
	private static final Logger logger = LoggerFactory.getLogger(ProdutoDAOImpl.class);
	
	private MarcaDAO marcaDAO;
	@Autowired(required=true)
	@Qualifier(value="marcaDAO")
	public void setMarcaDAO(MarcaDAO ma){
		this.marcaDAO = ma;
	}
	
	private TipoDAO tipoDAO;
	@Autowired(required=true)
	@Qualifier(value="tipoDAO")
	public void setTipoDAO(TipoDAO ti){
		this.tipoDAO = ti;
	}
	
	private SessionFactory sessionFactory;
	
	public void setSessionFactory(SessionFactory sf){
		this.sessionFactory = sf;
	}

	@Override
	public void addProduto(Produto p, int Tipo_id, int Marca_id) {
		// TODO Auto-generated method stub
		Session session = this.sessionFactory.getCurrentSession();
		p.setMarca(marcaDAO.getMarcaById(Marca_id));
		p.setTipo(tipoDAO.getTipoById(Tipo_id));
		session.persist(p);
		logger.info("Produto inserido="+p);
	}

	@Override
	public void updateProduto(Produto p, int Tipo_id, int Marca_id) {
		// TODO Auto-generated method stub
		Session session = this.sessionFactory.getCurrentSession();
		p.setMarca(marcaDAO.getMarcaById(Marca_id));
		p.setTipo(tipoDAO.getTipoById(Tipo_id));
		session.update(p);
		logger.info("Produto atualizado="+p);
	}

	@Override
	public List<Produto> listProdutos() {
		Session session = this.sessionFactory.getCurrentSession();
		List<Produto> produtosList = session.createQuery("from Produto").list();
		for(Produto p : produtosList){
			logger.info("Produtos::"+p);
		}
		return produtosList;
	}

	@Override
	public Produto getProdutoById(int id) {
		Session session = this.sessionFactory.getCurrentSession();		
		Produto p = (Produto) session.load(Produto.class, new Integer(id));
		logger.info("Produto recuperado="+p);
		return p;
	}

	@Override
	public void removeProduto(int id) {
		Session session = this.sessionFactory.getCurrentSession();
		Produto p = (Produto) session.load(Produto.class, new Integer(id));
		if(null != p){
			session.delete(p);
		}
		logger.info("Produto deletado="+p);
		
	}

}
