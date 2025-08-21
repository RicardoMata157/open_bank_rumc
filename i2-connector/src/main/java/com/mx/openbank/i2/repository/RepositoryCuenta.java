package com.mx.openbank.i2.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.mx.openbank.i2.entity.Cuenta;

@Repository
public interface RepositoryCuenta extends JpaRepository<Cuenta, String> {
	
	
	
	@Query(nativeQuery = true, value = "select pa.account_code, padf.id_account_field_def, padf.text_value  from pro_account pa "
			+ "inner join pro_account_dyn_field padf on pa.id=padf.id_account_record "
			+ "where pa.account_code=:account "
			+ "and id_account_field_def ='CLABE'")
	Cuenta  getClabeInterbancaria(@Param("account") String numeroCuenta);
	
	 @Query(
		        nativeQuery = true,
		        value = "SELECT " +
		                "CONCAT(pa.id, '-', padf.id) AS id, " +
		                "pa.ACCOUNT_CODE AS ACCOUNT_CODE, " +
		                "pa.account_type AS account_type, " +
		                "padf.text_value AS id_account_field_def " +
		                "FROM fcm.pro_account pa " +
		                "INNER JOIN fcm.pro_account_dyn_field padf ON pa.id = padf.id_account_record " +
		                "WHERE (:numerodecuenta IS NULL OR pa.ACCOUNT_CODE = :numerodecuenta) " +
		                "OR (:clabeinterbancaria IS NULL OR padf.text_value = :clabeinterbancaria)"
		    )
		    List<Cuenta> consultaCuenta(
		        @Param("numerodecuenta") String numerodecuenta,
		        @Param("clabeinterbancaria") String clabeinterbancaria
		    );
	

}
