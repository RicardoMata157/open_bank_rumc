package com.mx.openbank.i2.entity;

import java.io.Serializable;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "ing_cif_field", schema = "fcm")
public class IngCifField implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "id_cif_record")
	private String id;

	private String text_value;

	@ManyToOne
	@JoinColumn(referencedColumnName = "cif_record_id")
	private Persona tah2cifRecord;

}
