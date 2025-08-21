package com.mx.openbank.i2.entity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.persistence.Transient;

@Entity
@Table(name = "tah2cif_record", schema = "FCM") //
public class Persona implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "cif_record_id")
	private String cifRecordId;

	@Column(name = "cust_id")
	private String idCliente;

	@Column(name = "first_name")
	private String nombre;

	@Column(name = "name")
	private String apellidos;

	@Column(name = "pep")
	private String tipo_persona;

	@Column(name = "indicador_empleado")
	private String indicadorEmpleado; // el campo no esta mapeado

	@Column(name = "PASSPORT_NR")
	private String curp;
	@Column(name = "NAT_ID")
	private String ine;
	@Column(name = "SSN_ID")
	private String rfc;
	@Column(name = "classification")
	private String categoriaPersona;
	@Column(name = "birth_country")
	private String paisNacimiento;

	@Column(name = "BIRTH_DATE")
	private String fechaNacimiento;
	
	@Column(name = "risk_level")
	private String riesgoCliente;
	
	
	
	
	@OneToMany(mappedBy = "cliente", fetch = FetchType.LAZY)
	private List<Operacion> operaciones = new ArrayList<>();
	
	
	
	@OneToMany(mappedBy = "tah2cifRecord", fetch = FetchType.LAZY)
    private List<IngCifField> campos;




	public String getCifRecordId() {
		return cifRecordId;
	}




	public void setCifRecordId(String cifRecordId) {
		this.cifRecordId = cifRecordId;
	}




	public String getIdCliente() {
		return idCliente;
	}




	public void setIdCliente(String idCliente) {
		this.idCliente = idCliente;
	}




	public String getNombre() {
		return nombre;
	}




	public void setNombre(String nombre) {
		this.nombre = nombre;
	}




	public String getApellidos() {
		return apellidos;
	}




	public void setApellidos(String apellidos) {
		this.apellidos = apellidos;
	}




	public String getTipo_persona() {
		return tipo_persona;
	}




	public void setTipo_persona(String tipo_persona) {
		this.tipo_persona = tipo_persona;
	}




	public String getIndicadorEmpleado() {
		return indicadorEmpleado;
	}




	public void setIndicadorEmpleado(String indicadorEmpleado) {
		this.indicadorEmpleado = indicadorEmpleado;
	}




	public String getCurp() {
		return curp;
	}




	public void setCurp(String curp) {
		this.curp = curp;
	}




	public String getIne() {
		return ine;
	}




	public void setIne(String ine) {
		this.ine = ine;
	}




	public String getRfc() {
		return rfc;
	}




	public void setRfc(String rfc) {
		this.rfc = rfc;
	}




	public String getCategoriaPersona() {
		return categoriaPersona;
	}




	public void setCategoriaPersona(String categoriaPersona) {
		this.categoriaPersona = categoriaPersona;
	}




	public String getPaisNacimiento() {
		return paisNacimiento;
	}




	public void setPaisNacimiento(String paisNacimiento) {
		this.paisNacimiento = paisNacimiento;
	}




	public String getFechaNacimiento() {
		return fechaNacimiento;
	}




	public void setFechaNacimiento(String fechaNacimiento) {
		this.fechaNacimiento = fechaNacimiento;
	}




	public String getRiesgoCliente() {
		return riesgoCliente;
	}




	public void setRiesgoCliente(String riesgoCliente) {
		this.riesgoCliente = riesgoCliente;
	}




	public List<Operacion> getOperaciones() {
		return operaciones;
	}




	public void setOperaciones(List<Operacion> operaciones) {
		this.operaciones = operaciones;
	}




	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
	
	
	
	
	
	
	
	
	
	
	

}
