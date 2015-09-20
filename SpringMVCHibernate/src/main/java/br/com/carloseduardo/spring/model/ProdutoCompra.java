package br.com.carloseduardo.spring.model;


import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 * Entity bean with JPA annotations
 * Hibernate provides JPA implementation
 * @author pankaj
 *
 */
@Entity
@Table(name="ProdutoCompra")
@XmlRootElement
public class ProdutoCompra implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1194328974591698504L;
	
	@Id
	@Column(name="id")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	@ManyToOne
	@JoinColumn(name="Produto_id")
	private Produto produto;
	
	@ManyToOne
	@JoinColumn(name="Compra_id")
	private Compra compra;
	
	@ManyToOne
	@JoinColumn(name="Geladeira_id")
	private Geladeira geladeira;
	
	
	private Date datavalidade;
	
	private Boolean consumido;
	
	
	public ProdutoCompra(){}
	
	public ProdutoCompra(Produto produto, Compra compra, Geladeira geladeira, Date datavalidade, Boolean consumido) {
		super();
		this.produto = produto;
		this.compra = compra;
		this.geladeira = geladeira;
		this.datavalidade = datavalidade;
		this.consumido = consumido;
	}

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
	
	public Geladeira getGeladeira() {
		return geladeira;
	}

	@XmlTransient
	public void setGeladeira(Geladeira geladeira) {
		this.geladeira = geladeira;
	}

	public Date getDatavalidade() {
		return datavalidade;
	}

	public void setDatavalidade(Date datavalidade) {
		this.datavalidade = datavalidade;
	}

	public Boolean getConsumido() {
		return consumido;
	}

	public void setConsumido(Boolean consumido) {
		this.consumido = consumido;
	}

	@Override
	public String toString(){
		return "produto={\n"+produto.toString()+"\n}, compra={\n"+compra.toString()+"\n}, geladeira={\n"+geladeira.toString()+"\n}";
	}
}
