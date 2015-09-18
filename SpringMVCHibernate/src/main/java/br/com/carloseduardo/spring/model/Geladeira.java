package br.com.carloseduardo.spring.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="Geladeira")
public class Geladeira implements Serializable {


	/**
	 * 
	 */
	private static final long serialVersionUID = 3451034818418053093L;

	@Id
	@Column(name="nome")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private String nome;

	
	@Override
	public String toString(){
		return "nome"+nome;
	}


	public String getNome() {
		return nome;
	}


	public void setNome(String nome) {
		this.nome = nome;
	}


	
}
