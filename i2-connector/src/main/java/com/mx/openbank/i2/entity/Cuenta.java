package com.mx.openbank.i2.entity;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;
import jakarta.persistence.*;

@Entity
@Table(name = "pro_account", schema = "fcm")
public class Cuenta implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @Column(name = "id", nullable = false)
    private String idCuenta;

    @Column(name = "account_code") private String accountCode;
    @Column(name = "account_id")   private String accountId;
    @Column(name = "account_type") private String accountType;
    
    
    

    // Inversos
    @OneToMany(mappedBy = "cuenta", fetch = FetchType.LAZY)
    private Set<Operacion> operaciones = new HashSet<>();

    @OneToMany(mappedBy = "cuenta", fetch = FetchType.LAZY)
    private Set<ProAccountDynField> dynamicFields = new HashSet<>();

	public String getIdCuenta() {
		return idCuenta;
	}

	public void setIdCuenta(String idCuenta) {
		this.idCuenta = idCuenta;
	}

	public String getAccountCode() {
		return accountCode;
	}

	public void setAccountCode(String accountCode) {
		this.accountCode = accountCode;
	}

	public String getAccountId() {
		return accountId;
	}

	public void setAccountId(String accountId) {
		this.accountId = accountId;
	}

	public String getAccountType() {
		return accountType;
	}

	public void setAccountType(String accountType) {
		this.accountType = accountType;
	}

	public Set<Operacion> getOperaciones() {
		return operaciones;
	}

	public void setOperaciones(Set<Operacion> operaciones) {
		this.operaciones = operaciones;
	}

	public Set<ProAccountDynField> getDynamicFields() {
		return dynamicFields;
	}

	public void setDynamicFields(Set<ProAccountDynField> dynamicFields) {
		this.dynamicFields = dynamicFields;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

    // getters/setters
    
    
    
    
    
    
    
    
  
}
