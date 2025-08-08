package com.mx.openbank.i2.entity;



import java.io.Serializable;

import org.springframework.data.annotation.Transient;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.SecondaryTable;
import jakarta.persistence.Table;

@Entity
@Table(name = "pro_operation", schema = "FCM" ) //
@SecondaryTable(name = "pro_account_dyn_field",schema = "FCM")
public class Tarjeta implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	private String id;


    @Column(table = "pro_account_dyn_field"  , name = "text_value")
	private String numeroTarjata; // este campo indican que se debe hacer un query  para obtener este campo 
	
	@Column(name = "DEBIT_CREDIT_FLAG")
	private String tipoTarjeta;
	
}
