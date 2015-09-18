package br.com.carloseduardo.spring.service;

import java.util.List;

import br.com.carloseduardo.spring.model.Marca;

public interface MarcaService {

	public void addMarca(Marca p);
	public void updateMarca(Marca p);
	public List<Marca> listMarcas();
	public Marca getMarcaById(int id);
	public void removeMarca(int id);
	
}
