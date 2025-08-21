package com.mx.openbank.i2.entity;

import java.io.Serializable;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "tah2cif_record", schema = "FCM")
public class Onboarding implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @Column(name = "cif_record_id")
    private String id;


    @Column(name = "onboarding_date")
    private String fechaHora;

    @Column(name = "text_value")
    private String coordenadas;

 
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

    public String getCoordenadas() {
        return coordenadas;
    }

    public void setCoordenadas(String coordenadas) {
        this.coordenadas = coordenadas;
    }
}
