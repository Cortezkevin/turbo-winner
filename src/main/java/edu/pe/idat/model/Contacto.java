package edu.pe.idat.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="contacto")
public class Contacto {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer idConsulta;
	
	@Column(name="nombre")
	private String nombre;
	
	@Column(name="email")
	private String email;
	
	@Column(name="asunto")
	private String asunto;
	
	@Column(name="telefono")
	private String telefono;
	
	@Column(name="mensaje")
	private String mensaje;

	public Integer getIdConsulta() {
		return idConsulta;
	}

	public String getNombre() {
		return nombre;
	}

	public String getEmail() {
		return email;
	}

	public String getAsunto() {
		return asunto;
	}

	public String getTelefono() {
		return telefono;
	}

	public String getMensaje() {
		return mensaje;
	}

	public void setIdConsulta(Integer idConsulta) {
		this.idConsulta = idConsulta;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public void setAsunto(String asunto) {
		this.asunto = asunto;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

	public void setMensaje(String mensaje) {
		this.mensaje = mensaje;
	}

	public Contacto(Integer idConsulta, String nombre, String email, String asunto, String telefono, String mensaje) {
		super();
		this.idConsulta = idConsulta;
		this.nombre = nombre;
		this.email = email;
		this.asunto = asunto;
		this.telefono = telefono;
		this.mensaje = mensaje;
	}

	public Contacto() {
		super();
		// TODO Auto-generated constructor stub
	}

	
	
	
	
}
