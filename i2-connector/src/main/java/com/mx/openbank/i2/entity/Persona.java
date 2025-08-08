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

	@Transient
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
	
	

}
