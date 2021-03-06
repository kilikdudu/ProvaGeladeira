package br.com.carloseduardo.spring.dao;



import java.util.List;

import br.com.carloseduardo.spring.model.Geladeira;

public interface GeladeiraDAO {
	
	public void addGeladeira(Geladeira g, int usuario_id);
	public Geladeira getGeladeiraById(int id);
	public void updateGeladeira(Geladeira g, int usuario_id);
	public List<Geladeira> listGeladeiras(int usuario_id);
	public void removeGeladeira(int id);
}
