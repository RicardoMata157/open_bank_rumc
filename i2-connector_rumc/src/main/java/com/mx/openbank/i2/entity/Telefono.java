package com.mx.openbank.i2.entity;

import java.io.Serializable;

import org.springframework.data.annotation.Transient;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "tah2cif_record" , schema = "FCM") // 
public class Telefono implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;


	@Id
	@Column(name = "cif_record_id")
	private String id;
	
	@Transient
	private String idDomicilio4n;
	
	
	@Column(name = "telno_fix")
	private String numeroTelefonico;


	public String getId() {
		return id;
	}


	public void setId(String id) {
		this.id = id;
	}


	public String getNumeroTelefonico() {
		return numeroTelefonico;
	}


	public void setNumeroTelefonico(String numeroTelefonico) {
		this.numeroTelefonico = numeroTelefonico;
	}


	public String getIdDomicilio4n() {
		return idDomicilio4n;
	}


	public void setIdDomicilio4n(String idDomicilio4n) {
		this.idDomicilio4n = idDomicilio4n;
	}
	
	
	
	
	

}
