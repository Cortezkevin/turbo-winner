package edu.pe.idat.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="usuario")
public class Usuario {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer idUsuario;
	
	@Column(name="email")
	private String email;
	
	@Column(name="nombreUsuario")
	private String nombreUsuario;
	
	@Column(name="password")
	private String password;

	public Integer getIdUsuario() {
		return idUsuario;
	}

	public String getEmail() {
		return email;
	}

	public String getNombreUsuario() {
		return nombreUsuario;
	}

	public String getPassword() {
		return password;
	}

	public void setIdUsuario(Integer idUsuario) {
		this.idUsuario = idUsuario;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public void setNombreUsuario(String nombreUsuario) {
		this.nombreUsuario = nombreUsuario;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Usuario(Integer idUsuario, String email, String nombreUsuario, String password) {
		super();
		this.idUsuario = idUsuario;
		this.email = email;
		this.nombreUsuario = nombreUsuario;
		this.password = password;
	}

	public Usuario() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
}
