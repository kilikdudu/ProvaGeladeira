package br.com.carloseduardo.spring.dao;



import java.io.Console;
import java.util.List;

import org.hibernate.Query;
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

	@Override
	public int loginUsuario(String login, String senha) {
		// TODO Auto-generated method stub
		Session session = this.sessionFactory.getCurrentSession();
		Query query =session.createQuery("from Usuario where login = :login and senha = password(:senha)");
		System.out.println("Login: " + login + ", Senha: " + senha);
		query.setParameter("login",login);
		query.setParameter("senha",senha);
		List<Usuario> us = (List<Usuario>)query.list();
		if(us.isEmpty()){
			return -1;
		}else
		{
			return us.get(0).getId();
		}
	}

}
