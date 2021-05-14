package edu.pe.idat.model;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name = "proyecto")
public class Proyecto {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer idProyecto;

	@Column(name="nombre")
	private String nombre;

	@Column(name="empresa")
	private String empresa;

	@Column(name="ubicacion")
	private String ubicacion;
	
	@Column(name="area")
	private Double area;
/*
	@Column(name="monto")
	private Double Monto;
*/
	@Column(name="fechaInicio")
	private String fechaInicio;
	
	@Column(name="descripcion")
	private String descripcion;


	public String getUbicacion() {
		return ubicacion;
	}

	public void setUbicacion(String ubicacion) {
		this.ubicacion = ubicacion;
	}


	public Integer getIdProyecto() {
		return idProyecto;
	}

	public String getNombre() {
		return nombre;
	}

	public String getEmpresa() {
		return empresa;
	}

	public Double getArea() {
		return area;
	}
/*
	public Double getMonto() {
		return Monto;
	}
*/
	public String getFechaInicio() {
		return fechaInicio;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setIdProyecto(Integer idProyecto) {
		this.idProyecto = idProyecto;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public void setEmpresa(String empresa) {
		this.empresa = empresa;
	}

	public void setArea(Double area) {
		this.area = area;
	}
/*
	public void setMonto(Double monto) {
		Monto = monto;
	}
*/
	public void setFechaInicio(String fechaInicio) {
		this.fechaInicio = fechaInicio;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}


	public Proyecto(Integer idProyecto, String nombre, String empresa, String ubicacion, Double area,
			String fechaInicio, String descripcion) {
		super();
		this.idProyecto = idProyecto;
		this.nombre = nombre;
		this.empresa = empresa;
		this.ubicacion = ubicacion;
		this.area = area;
		this.fechaInicio = fechaInicio;
		this.descripcion = descripcion;
	}

	public Proyecto() {
		super();
		// TODO Auto-generated constructor stub
	}

	
}

