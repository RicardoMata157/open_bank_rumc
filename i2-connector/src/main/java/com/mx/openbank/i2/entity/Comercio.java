package com.mx.openbank.i2.entity;

import java.io.Serializable;

import org.springframework.data.annotation.Transient;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "pro_operation", schema = "FCM" )//
public class Comercio implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;


	@Id
	private String id;
	
	
	@Column(name = "manager")
	private String NombreComercioEntrada;
	
	@Transient
	private String tipoComerico;
	
	@Transient
	private String rfc;


	public String getId() {
		return id;
	}


	public void setId(String id) {
		this.id = id;
	}


	public String getNombreComercioEntrada() {
		return NombreComercioEntrada;
	}


	public void setNombreComercioEntrada(String nombreComercioEntrada) {
		NombreComercioEntrada = nombreComercioEntrada;
	}
	
	
	
	
	

}
