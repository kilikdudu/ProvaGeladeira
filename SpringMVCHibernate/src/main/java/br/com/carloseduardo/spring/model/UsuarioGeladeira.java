package br.com.carloseduardo.spring.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="UsuarioGeladeira")
public class UsuarioGeladeira implements Serializable {


	/**
	 * 
	 */
	private static final long serialVersionUID = 3451034818418053093L;

	@Id
	@ManyToOne
	@JoinColumn(name="Usuario_id")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Usuario usuario;

	@Id
	@ManyToOne
	@JoinColumn(name="Geladeira_nome")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Geladeira geladeira;
	
	@Override
	public String toString(){
		return "geladeira: "+geladeira.getNome() + ", usuario: " + usuario.getId();
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public Geladeira getGeladeira() {
		return geladeira;
	}

	public void setGeladeira(Geladeira geladeira) {
		this.geladeira = geladeira;
	}

	public UsuarioGeladeira(Usuario usuario, Geladeira geladeira) {
		super();
		this.usuario = usuario;
		this.geladeira = geladeira;
	}
	
	

	
}
