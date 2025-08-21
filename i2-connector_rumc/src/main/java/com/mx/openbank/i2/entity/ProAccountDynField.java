package com.mx.openbank.i2.entity;

import java.io.Serializable;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "pro_account_dyn_field", schema = "FCM")
public class ProAccountDynField implements Serializable {

    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")               // asumiendo que esta tabla tiene PK propia 'id'
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_account_record", referencedColumnName = "id", nullable = false)
    private Cuenta account;

    @Column(name = "field_name")
    private String fieldName;          // ajusta al nombre real del campo

    @Column(name = "text_value")
    private String textValue;
    
    

}
