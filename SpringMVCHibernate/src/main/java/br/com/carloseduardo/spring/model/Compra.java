package br.com.carloseduardo.spring.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Entity bean with JPA annotations
 * Hibernate provides JPA implementation
 * @author pankaj
 *
 */
@Entity
@Table(name="Compra")
public class Compra implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 3925303531100585371L;

	@Id
	@Column(name="id")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	
	private String mercado;
	
	private Date data;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getMercado() {
		return mercado;
	}

	public void setMercado(String mercado) {
		this.mercado = mercado;
	}

	public Date getData() {
		return data;
	}

	public void setData(Date data) {
		this.data = data;
	}

	@Override
	public String toString(){
		return "id="+id+", mercado="+mercado+", data="+data.toString();
	}
}
