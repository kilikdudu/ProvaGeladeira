package br.com.carloseduardo.spring.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import br.com.carloseduardo.spring.model.Marca;
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
	
	private UsuarioDAO usuarioDAO;
	@Autowired(required=true)
	@Qualifier(value="usuarioDAO")
	public void setUsuarioDAO(UsuarioDAO usu){
		this.usuarioDAO = usu;
	}
	
	private SessionFactory sessionFactory;
	
	public void setSessionFactory(SessionFactory sf){
		this.sessionFactory = sf;
	}

	@Override
	public void addProdutoCompra(ProdutoCompra pc, int produto_id, int compra_id, int usuario_id) {
		// TODO Auto-generated method stub
		Session session = this.sessionFactory.getCurrentSession();
		pc.setProduto(produtoDAO.getProdutoById(produto_id));
		pc.setCompra(compraDAO.getCompraById(compra_id));
		pc.setUsuario(usuarioDAO.getUsuarioById(usuario_id));
		session.persist(pc);
		logger.info("ProdutoCompra inserido="+pc);
	}

	@Override
	public void updateProdutoCompra(ProdutoCompra pc, int produto_id, int compra_id, int usuario_id) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<ProdutoCompra> listProdutosCompras() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Marca getProdutoCompraById(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void removeProdutoCompra(int id) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void consumirProdutoCompra() {
		// TODO Auto-generated method stub
		
	}
	
	

}
