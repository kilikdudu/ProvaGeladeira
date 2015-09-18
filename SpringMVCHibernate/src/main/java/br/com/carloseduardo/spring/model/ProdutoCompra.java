package br.com.carloseduardo.spring.model;


import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 * Entity bean with JPA annotations
 * Hibernate provides JPA implementation
 * @author pankaj
 *
 */
@Entity
@Table(name="ProdutoCompra")
public class ProdutoCompra implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1194328974591698504L;

	@Id
	@ManyToOne
	@JoinColumn(name="Produto_id")
	private Produto produto;
	
	public Produto getProduto() {
		return produto;
	}

	public void setProduto(Produto produto) {
		this.produto = produto;
	}

	public Compra getCompra() {
		return compra;
	}

	public void setCompra(Compra compra) {
		this.compra = compra;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	@Id
	@ManyToOne
	@JoinColumn(name="Compra_id")
	private Compra compra;
	
	@ManyToOne
	@JoinColumn(name="Usuario_id")
	private Usuario usuario;
	
	@Override
	public String toString(){
		return "produto={\n"+produto.toString()+"\n}, compra={\n"+compra.toString()+"\n}, usuario={\n"+usuario.toString()+"\n}";
	}
}
