package com.mx.openbank.i2.entity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.SecondaryTable;
import jakarta.persistence.Table;

@Entity
@Table(name = "PRO_ACCOUNT", schema = "FCM")
@SecondaryTable(name = "pro_account_dyn_field", schema = "FCM") //
public class Cuenta implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "id")
	private String id;

	@Column(name = "ACCOUNT_CODE")
	private String numeroCuentaInterno;

	@Column(name = "ACCOUNT_ID")
	private String numeroCuenta;

	@Column(name = "ACCOUNT_TYPE")
	private String tipoCuenta;

	@Column(table = "pro_account_dyn_field", name = "text_value")
	private String clabeInterbancaria;
	
	 @OneToMany(mappedBy = "account", fetch = FetchType.LAZY)
	 private List<ProAccountDynField> dynamicFields = new ArrayList<>();
	 
	 @OneToMany(mappedBy = "cuenta", fetch = FetchType.LAZY)
	 private List<Operacion> operaciones = new ArrayList<>();

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getNumeroCuentaInterno() {
		return numeroCuentaInterno;
	}

	public void setNumeroCuentaInterno(String numeroCuentaInterno) {
		this.numeroCuentaInterno = numeroCuentaInterno;
	}

	public String getNumeroCuenta() {
		return numeroCuenta;
	}

	public void setNumeroCuenta(String numeroCuenta) {
		this.numeroCuenta = numeroCuenta;
	}

	public String getTipoCuenta() {
		return tipoCuenta;
	}

	public void setTipoCuenta(String tipoCuenta) {
		this.tipoCuenta = tipoCuenta;
	}

	public String getClabeInterbancaria() {
		return clabeInterbancaria;
	}

	public void setClabeInterbancaria(String clabeInterbancaria) {
		this.clabeInterbancaria = clabeInterbancaria;
	}

}
