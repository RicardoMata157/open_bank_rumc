package com.mx.openbank.i2.entity;

import java.io.Serializable;
import jakarta.persistence.*;

@Entity
@Table(name = "ing_cif_field", schema = "fcm")
@Access(AccessType.FIELD)
public class IngCifField implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @Column(name = "id_cif_record")
    private String id;

    @Column(name = "text_value")
    private String textValue;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "tah2cifrecord_cif_record_id", referencedColumnName = "cif_record_id")
    private Persona persona;

    // getters/setters ...
}
