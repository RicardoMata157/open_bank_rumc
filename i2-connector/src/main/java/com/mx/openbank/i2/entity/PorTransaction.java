package com.mx.openbank.i2.entity;

import java.io.Serializable;
import jakarta.persistence.*;

@Entity
@Table(name = "por_transaction", schema = "t24_snapshot")
@Access(AccessType.FIELD)
public class PorTransaction implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @Column(name = "recid", nullable = false)
    private String recid;

    @Column(name = "customerspecifiedreference")
    private String customerSpecifiedReference;

    // FK por_transaction.transaction_ref -> pro_operation.id
    @OneToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "transaction_ref", referencedColumnName = "id", nullable = false)
    private Operacion operacion;

    // getters/setters
    public String getRecid() { return recid; }
    public void setRecid(String recid) { this.recid = recid; }
    public String getCustomerSpecifiedReference() { return customerSpecifiedReference; }
    public void setCustomerSpecifiedReference(String v) { this.customerSpecifiedReference = v; }
    public Operacion getOperacion() { return operacion; }
    public void setOperacion(Operacion operacion) { this.operacion = operacion; }
}
