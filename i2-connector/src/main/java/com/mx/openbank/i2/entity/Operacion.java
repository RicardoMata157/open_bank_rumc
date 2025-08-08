package com.mx.openbank.i2.entity;

import java.io.Serializable;
import java.util.Date;

import org.springframework.data.annotation.Transient;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.SecondaryTable;
import jakarta.persistence.Table;

@Table(name = "pro_operation", schema = "FCM") //
@SecondaryTable(name = "por_transaction", schema = "T24_snapshot")
@Entity
public class Operacion implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "id")
	private String id;

	@Column(name = "OPERATION_DATE")
	private Date fechaHora;

	@Column(name = "TRANSACTION_REF")
	private String idTransaccion;

	@Column(name = "customerspecifiedreference", table = "por_transaction")
	private String claveRastreo;

	@Column(name = "operation_code")
	private String codigoOperacionEntrada;

	@Column(name = "")
	private String codigoOperacionSalida; // se debe sacar con una condicion con esta operation_code

	@Column(name = "AMOUNT")
	private Double monto;

	@Transient
	private String dispositivo;

	@Column(name = "SOURCE_APP_REF")
	private String narrative;

	@Column(name = "ORDERING_CUSTOMER_ID")
	private String orderingCustomerId;

	@Column(name = "BENEFICIARY_CUSTOMER_ID")
	private String beneficiaryCostumerId;

	@Column(name = "EXTERNAL_ADDRESS2")
	private String coordenadas;

	@ManyToOne(fetch = FetchType.LAZY, optional = false)
	@JoinColumn(name = "account_id", referencedColumnName = "id", nullable = false)
	private Cuenta cuenta;

	@ManyToOne(fetch = FetchType.LAZY, optional = false)
	@JoinColumn(name = "cust_id", // FK en pro_operation
			referencedColumnName = "cif_record_id", // PK en tah2cif_record
			nullable = false)
	private Persona cliente;

	@ManyToOne(fetch = FetchType.LAZY, optional = false)
	@JoinColumn(name = "recid", referencedColumnName = "recid", nullable = false)
	private PorTransaction transaccion;

}
