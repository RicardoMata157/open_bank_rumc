package com.mx.openbank.i2.entity;

import java.io.Serializable;

import org.springframework.data.annotation.Transient;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.SecondaryTable;
import jakarta.persistence.Table;

@Table(name = "pro_operation", schema = "FCM")
@SecondaryTable(name = "por_transaction", schema = "T24_snapshot")
@Entity
public class Operacion implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @Column(name = "id")
    private String id;

    @Column(name = "OPERATION_DATE")
    private String fechaHora;

    @Column(name = "TRANSACTION_REF")
    private String idTransaccion;

    @Column(name = "customerspecifiedreference", table = "por_transaction")
    private String claveRastreo;

    @Column(name = "operation_code")
    private String codigoOperacionEntrada;

    @Column(name = "tipo_operacion")
    private String codigoOperacionSalida;

    // Ahora como String, porque la query devuelve ::text
    @Column(name = "AMOUNT")
    private String monto;

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
    @JoinColumn(
        name = "cust_id",
        referencedColumnName = "cif_record_id",
        nullable = false
    )
    private Persona cliente;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "recid", referencedColumnName = "recid", nullable = false)
    private PorTransaction transaccion;


    // ===== Getters y Setters =====
    
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getFechaHora() {
        return fechaHora;
    }

    public void setFechaHora(String fechaHora) {
        this.fechaHora = fechaHora;
    }

    public String getIdTransaccion() {
        return idTransaccion;
    }

    public void setIdTransaccion(String idTransaccion) {
        this.idTransaccion = idTransaccion;
    }

    public String getClaveRastreo() {
        return claveRastreo;
    }

    public void setClaveRastreo(String claveRastreo) {
        this.claveRastreo = claveRastreo;
    }

    public String getCodigoOperacionEntrada() {
        return codigoOperacionEntrada;
    }

    public void setCodigoOperacionEntrada(String codigoOperacionEntrada) {
        this.codigoOperacionEntrada = codigoOperacionEntrada;
    }

    public String getCodigoOperacionSalida() {
        return codigoOperacionSalida;
    }

    public void setCodigoOperacionSalida(String codigoOperacionSalida) {
        this.codigoOperacionSalida = codigoOperacionSalida;
    }

    public String getMonto() {
        return monto;
    }

    public void setMonto(String monto) {
        this.monto = monto;
    }

    public String getDispositivo() {
        return dispositivo;
    }

    public void setDispositivo(String dispositivo) {
        this.dispositivo = dispositivo;
    }

    public String getNarrative() {
        return narrative;
    }

    public void setNarrative(String narrative) {
        this.narrative = narrative;
    }

    public String getOrderingCustomerId() {
        return orderingCustomerId;
    }

    public void setOrderingCustomerId(String orderingCustomerId) {
        this.orderingCustomerId = orderingCustomerId;
    }

    public String getBeneficiaryCostumerId() {
        return beneficiaryCostumerId;
    }

    public void setBeneficiaryCostumerId(String beneficiaryCostumerId) {
        this.beneficiaryCostumerId = beneficiaryCostumerId;
    }

    public String getCoordenadas() {
        return coordenadas;
    }

    public void setCoordenadas(String coordenadas) {
        this.coordenadas = coordenadas;
    }

    public Cuenta getCuenta() {
        return cuenta;
    }

    public void setCuenta(Cuenta cuenta) {
        this.cuenta = cuenta;
    }

    public Persona getCliente() {
        return cliente;
    }

    public void setCliente(Persona cliente) {
        this.cliente = cliente;
    }

    public PorTransaction getTransaccion() {
        return transaccion;
    }

    public void setTransaccion(PorTransaction transaccion) {
        this.transaccion = transaccion;
    }
}
