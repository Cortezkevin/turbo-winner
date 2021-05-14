package edu.pe.idat.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ForeignKey;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "proforma")
public class Proforma {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer idProforma;

	@Column(name = "cliente")
	private String cliente;

	@Column(name = "direccion")
	private String direccion;

	@Column(name = "nombreProyecto")
	private String nombreProyecto;
	
	@Column(name = "monto")
	private Double Monto;
	
	@Column(name = "importe")
	private Double importe;

	public Double getMonto() {
		return Monto;
	}

	public void setMonto(Double monto) {
		Monto = monto;
	}

	public Integer getIdProforma() {
		return idProforma;
	}

	public String getCliente() {
		return cliente;
	}

	public String getDireccion() {
		return direccion;
	}

	public String getNombreProyecto() {
		return nombreProyecto;
	}

	public Double getImporte() {
		return importe;
	}

	public void setIdProforma(Integer idProforma) {
		this.idProforma = idProforma;
	}

	public void setCliente(String cliente) {
		this.cliente = cliente;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	public void setNombreProyecto(String nombreProyecto) {
		this.nombreProyecto = nombreProyecto;
	}

	public void setImporte(Double importe) {
		this.importe = importe;
	}



	public Proforma(Integer idProforma, String cliente, String direccion, String nombreProyecto, Double monto,
			Double importe) {
		super();
		this.idProforma = idProforma;
		this.cliente = cliente;
		this.direccion = direccion;
		this.nombreProyecto = nombreProyecto;
		Monto = monto;
		this.importe = importe;
	}

	public Proforma() {
		super();
		// TODO Auto-generated constructor stub
	}

}
