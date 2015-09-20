package br.com.carloseduardo.spring.model;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

@Entity
@Table(name="Geladeira")
@XmlRootElement
public class Geladeira implements Serializable {


	/**
	 * 
	 */
	private static final long serialVersionUID = 3451034818418053093L;

	@Id
	@Column(name="id")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;

	@ManyToOne
	@JoinColumn(name="Usuario_id")
	private Usuario usuario;
	
	private String descricao;
	
	@OneToMany(mappedBy = "geladeira", targetEntity = ProdutoCompra.class, fetch = FetchType.EAGER)
	private List<ProdutoCompra> produtoscompras;
	
	public List<ProdutoCompra> getProdutoscompras() {
		return produtoscompras;
	}
	
	@XmlElement
	public void setProdutoscompras(List<ProdutoCompra> produtoscompras) {
		this.produtoscompras = produtoscompras;
	}

	public Geladeira(){}
	
	public Geladeira(int id, Usuario usuario, String descricao) {
		super();
		this.id = id;
		this.usuario = usuario;
		this.descricao = descricao;
	}

	public int getId() {
		return id;
	}
	
	@XmlElement
	public void setId(int id) {
		this.id = id;
	}

	public Usuario getUsuario() {
		return usuario;
	}
	
	@XmlTransient
	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public String getDescricao() {
		return descricao;
	}
	
	@XmlElement
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	
	@Override
	public String toString(){
		return "nome: " + descricao + ", id: " + id + "usuario: " + usuario.toString();
	}
}
