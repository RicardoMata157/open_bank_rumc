package com.mx.openbank.i2.entity;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import org.hibernate.annotations.Formula;

import jakarta.persistence.Access;
import jakarta.persistence.AccessType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "tah2cif_record", schema = "fcm")
@Access(AccessType.FIELD)
public class Persona implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @Column(name = "cif_record_id", nullable = false)
    private String id;
    
    @Column(name = "cust_id")    private String customerId;

    @Column(name = "first_name") private String firstName;
    @Column(name = "name")       private String lastNames;
   
    @Column(name = "pep")        private String pep;
    @Column(name = "PASSPORT_NR") private String curp;
    @Column(name = "NAT_ID") private String ine;
    @Column(name = "SSN_ID") private String rfc;
    @Column(name = "classification") private String categotiaPersona ;
    @Column(name = "birth_country") private String paisNacimiento;
    @Column(name = "BIRTH_DATE") private String fechaNacimiento;
    @Column(name = "risk_level") private String riskLevel;
    
    
	@Formula(
		    "CASE " +
		    "  WHEN trim(risk_level) ~ '^[0-9]+$' THEN " +
		    "    CASE " +
		    "      WHEN CAST(trim(risk_level) AS INTEGER) <= 20 THEN 'Muy Bajo' " +
		    "      WHEN CAST(trim(risk_level) AS INTEGER) BETWEEN 21 AND 28 THEN 'Bajo' " +
		    "      WHEN CAST(trim(risk_level) AS INTEGER) BETWEEN 29 AND 75 THEN 'Medio' " +
		    "      WHEN CAST(trim(risk_level) AS INTEGER) BETWEEN 76 AND 206 THEN 'Alto' " +
		    "      WHEN CAST(trim(risk_level) AS INTEGER) BETWEEN 207 AND 377 THEN 'Bajo' " +
		    "      WHEN CAST(trim(risk_level) AS INTEGER) BETWEEN 378 AND 507 THEN 'Medio' " +
		    "      WHEN CAST(trim(risk_level) AS INTEGER) BETWEEN 508 AND 25000 THEN 'Alto' " +
		    "    END " +
		    "  ELSE NULL " +
		    "END"
		)
		private String statusRiesgo;
    
    
    

    // Inversos
    @OneToMany(mappedBy = "persona", fetch = FetchType.EAGER)
    private Set<Operacion> operaciones = new HashSet<>();

    @OneToMany(mappedBy = "persona", fetch = FetchType.LAZY)
    private Set<IngCifField> cifFields = new HashSet<>();

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getCustomerId() {
		return customerId;
	}

	public void setCustomerId(String customerId) {
		this.customerId = customerId;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastNames() {
		return lastNames;
	}

	public void setLastNames(String lastNames) {
		this.lastNames = lastNames;
	}

	public String getPep() {
		return pep;
	}

	public void setPep(String pep) {
		this.pep = pep;
	}

	public String getCurp() {
		return curp;
	}

	public void setCurp(String curp) {
		this.curp = curp;
	}

	public String getIne() {
		return ine;
	}

	public void setIne(String ine) {
		this.ine = ine;
	}

	public String getRfc() {
		return rfc;
	}

	public void setRfc(String rfc) {
		this.rfc = rfc;
	}

	public String getCategotiaPersona() {
		return categotiaPersona;
	}

	public void setCategotiaPersona(String categotiaPersona) {
		this.categotiaPersona = categotiaPersona;
	}

	public String getPaisNacimiento() {
		return paisNacimiento;
	}

	public void setPaisNacimiento(String paisNacimiento) {
		this.paisNacimiento = paisNacimiento;
	}

	public String getFechaNacimiento() {
		return fechaNacimiento;
	}

	public void setFechaNacimiento(String fechaNacimiento) {
		this.fechaNacimiento = fechaNacimiento;
	}

	public String getRiskLevel() {
		return riskLevel;
	}

	public void setRiskLevel(String riskLevel) {
		this.riskLevel = riskLevel;
	}

	public Set<Operacion> getOperaciones() {
		return operaciones;
	}

	public void setOperaciones(Set<Operacion> operaciones) {
		this.operaciones = operaciones;
	}

	public Set<IngCifField> getCifFields() {
		return cifFields;
	}

	public void setCifFields(Set<IngCifField> cifFields) {
		this.cifFields = cifFields;
	}

	public String getStatusRiesgo() {
		return statusRiesgo;
	}

	public void setStatusRiesgo(String statusRiesgo) {
		this.statusRiesgo = statusRiesgo;
	}

	
	
   
}
