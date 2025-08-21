package com.mx.openbank.i2.entity;

import java.io.Serializable;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "por_transaction",schema = "T24_snapshot")
public class PorTransaction implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Id
	private String recid;
	
	@Column(name = "customerspecifiedreference")
	private String customerspecifiedreference;

}
