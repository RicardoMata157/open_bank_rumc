package com.mx.openbank.i2.entity;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;
import jakarta.persistence.*;

@Entity
@Table(name = "pro_operation", schema = "fcm")
@Access(AccessType.FIELD)
public class Operacion implements Serializable {
    private static final long serialVersionUID = 1L;

    // PK
    @Id
    @Column(name = "id", nullable = false, updatable = false)
    private String idOperacion;

    // columnas simples
    @Column(name = "amount")                 private String amount;
    @Column(name = "beneficiary_bank")       private String beneficiaryBank;
    @Column(name = "beneficiary_customer_id")private String beneficiaryCustomerId;
    @Column(name = "debit_credit_flag")      private String debitCreditFlag;
    @Column(name = "external_address2")      private String externalAddress2;
    @Column(name = "external_bic")           private String externalBic;
    @Column(name = "external_name")          private String externalName;
    @Column(name = "operation_date")         private String operationDate;
    @Column(name = "remitter_bank")          private String remitterBank;
    @Column(name = "source_app_ref")         private String sourceAppRef;
    @Column(name = "dispositivo")            private String dispositivo;
    @Column(name = "manager")                private String manager;
    @Column(name = "operation_code")         private String operationCode;
    @Column(name = "ordering_customer_id")   private String orderingCustomerId;
    @Column(name = "rfc")                    private String rfc;
    @Column(name = "tipocomerico")           private String tipocomerico;
    @Column(name = "tipo_operacion")         private String tipoOperacion;

    // ¡OJO! Esto es columna normal; por_transaction apoya su FK en esta PK (id)
    @Column(name = "transaction_ref", nullable = false)
    private String transactionRef;

    // FK: account_id -> pro_account.id
    @ManyToOne(fetch = FetchType.EAGER, optional = false)
    @JoinColumn(name = "account_id", referencedColumnName = "id", nullable = false)
    private Cuenta cuenta;

    // FK: cust_id -> tah2cif_record.cif_record_id
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "cust_id", referencedColumnName = "cif_record_id", nullable = false)
    private Persona persona;

    // Inverso 1:1 (dueño está en PorTransaction)
    @OneToMany(mappedBy = "operacion", fetch = FetchType.LAZY)
    private  Set<PorTransaction> porTransaction = new HashSet<PorTransaction>();

    // Inverso 1:N desde pro_account_dyn_field.id (FK a pro_operation.id)
//    @OneToMany(mappedBy = "operacion", fetch = FetchType.LAZY)
//    private Set<ProAccountDynField> accountDynFields = new HashSet<>();

    // getters/setters
    // ... genera los que uses (id, transactionRef, cuenta, persona, etc.)
    public String getId() { return idOperacion; }
    public void setId(String id) { this.idOperacion = id; }
    public String getTransactionRef() { return transactionRef; }
    public void setTransactionRef(String transactionRef) { this.transactionRef = transactionRef; }
    public Cuenta getCuenta() { return cuenta; }
    public void setCuenta(Cuenta cuenta) { this.cuenta = cuenta; }
    public Persona getPersona() { return persona; }
    public void setPersona(Persona persona) { this.persona = persona; }
}
