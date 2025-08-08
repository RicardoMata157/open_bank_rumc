package com.mx.openbank.i2.entity;

import java.io.Serializable;
import java.util.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "tah2cif_record", schema = "FCM") //
public class Onboarding implements Serializable {
	
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "cif_record_id")
	private String id;
	
	@Column(name = "onboarding_date")
	private Date fechaHora;
	
	
	@Column(name = "text_value")
	private String coordenadas;

}
