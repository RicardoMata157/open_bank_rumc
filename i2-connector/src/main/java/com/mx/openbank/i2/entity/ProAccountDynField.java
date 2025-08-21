package com.mx.openbank.i2.entity;

import java.io.Serializable;
import jakarta.persistence.*;

@Entity
@Table(name = "pro_account_dyn_field", schema = "fcm")
@Access(AccessType.FIELD)
public class ProAccountDynField implements Serializable {
    private static final long serialVersionUID = 1L;

    // PK de esta tabla
    @Id
    @Column(name = "id_account_record", nullable = false)
    private String idAccountRecord;

    @Column(name = "text_value")            private String textValue;
    @Column(name = "id_account_field_def")  private String idAccountFieldDef;

    // FK a pro_operation.id (¡la columna aquí se llama 'id'!)
//    @ManyToOne(fetch = FetchType.LAZY)
//    @JoinColumn(name = "id", referencedColumnName = "id")
//    private Operacion operacion;

    // FK a pro_account.id
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "account_id", referencedColumnName = "id")
    private Cuenta cuenta;

    // getters/setters
    public String getIdAccountRecord() { return idAccountRecord; }
    public void setIdAccountRecord(String idAccountRecord) { this.idAccountRecord = idAccountRecord; }

    public String getTextValue() { return textValue; }
    public void setTextValue(String textValue) { this.textValue = textValue; }

    public String getIdAccountFieldDef() { return idAccountFieldDef; }
    public void setIdAccountFieldDef(String idAccountFieldDef) { this.idAccountFieldDef = idAccountFieldDef; }

//    public Operacion getOperacion() { return operacion; }
//    public void setOperacion(Operacion operacion) { this.operacion = operacion; }

    public Cuenta getCuenta() { return cuenta; }
    public void setCuenta(Cuenta cuenta) { this.cuenta = cuenta; }
}
