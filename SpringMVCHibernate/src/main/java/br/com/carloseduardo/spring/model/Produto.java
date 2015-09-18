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

import br.com.carloseduardo.spring.service.TipoServiceImpl;

/**
 * Entity bean with JPA annotations
 * Hibernate provides JPA implementation
 * @author pankaj
 *
 */
@Entity
@Table(name="Produto")
public class Produto implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 2039969709568569628L;

	@Id
	@Column(name="id")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	
	private String nome;
	
	@ManyToOne
	@JoinColumn(name="Tipo_id")
	private Tipo tipo;
	
	@ManyToOne
	@JoinColumn(name="Marca_id")
	private Marca marca;
		
	private int valor;
	
	public Produto(){}
	
	public Produto(int id, String nome, Tipo tipo, Marca marca, int valor) {
		super();
		this.id = id;
		this.nome = nome;
		this.tipo = tipo;
		this.marca = marca;
		this.valor = valor;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Tipo getTipo() {
		return tipo;
	}

	public void setTipo(Tipo tipo) {
		this.tipo = tipo;
	}
	
	public Marca getMarca() {
		return marca;
	}

	public void setMarca(Marca marca) {
		this.marca = marca;
	}

	public int getValor() {
		return valor;
	}

	public void setValor(int valor) {
		this.valor = valor;
	}
	
	@Override
	public String toString(){
		return "id="+id+", descricao="+nome+", tipo={\n"+tipo.toString()+"\n}, marca={\n"+marca.toString()+"\n}, valor="+valor;
	}
}
