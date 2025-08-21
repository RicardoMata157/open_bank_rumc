package com.mx.openbank.i2.entity;

import java.io.Serializable;

import org.springframework.data.annotation.Transient;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "pro_operation" ,schema = "FCM")//
public class CuentaExterna implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	private String account_id;
	
	@Column(name = "REMITTER_BANK")
	private String numeroCuentaEntrada;
	
	@Column(name = "BENEFICIARY_BANK")
	private String numeroCuentaSalida;
	
	@Column(name = "EXTERNAL_NAME")
	private String nombreCompletoCliente;
	
	@Column(name = "EXTERNAL_BIC")
	private String banco;
	
	@Column(name = "ordering_customer_id")
	private String cuentaClabe;

	public String getAccount_id() {
		return account_id;
	}

	public void setAccount_id(String account_id) {
		this.account_id = account_id;
	}

	public String getNumeroCuentaEntrada() {
		return numeroCuentaEntrada;
	}

	public void setNumeroCuentaEntrada(String numeroCuentaEntrada) {
		this.numeroCuentaEntrada = numeroCuentaEntrada;
	}

	public String getNumeroCuentaSalida() {
		return numeroCuentaSalida;
	}

	public void setNumeroCuentaSalida(String numeroCuentaSalida) {
		this.numeroCuentaSalida = numeroCuentaSalida;
	}

	public String getNombreCompletoCliente() {
		return nombreCompletoCliente;
	}

	public void setNombreCompletoCliente(String nombreCompletoCliente) {
		this.nombreCompletoCliente = nombreCompletoCliente;
	}

	public String getBanco() {
		return banco;
	}

	public void setBanco(String banco) {
		this.banco = banco;
	}

	public String getCuentaClabe() {
		return cuentaClabe;
	}

	public void setCuentaClabe(String cuentaClabe) {
		this.cuentaClabe = cuentaClabe;
	}
	
	
	
	
	

}
