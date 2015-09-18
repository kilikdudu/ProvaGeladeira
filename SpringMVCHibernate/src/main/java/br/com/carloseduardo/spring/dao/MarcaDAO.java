package br.com.carloseduardo.spring.dao;

import java.util.List;

import br.com.carloseduardo.spring.model.Marca;

public interface MarcaDAO {

	public void addMarca(Marca m);
	public void updateMarca(Marca m);
	public List<Marca> listMarcas();
	public Marca getMarcaById(int id);
	public void removeMarca(int id);
	
}
