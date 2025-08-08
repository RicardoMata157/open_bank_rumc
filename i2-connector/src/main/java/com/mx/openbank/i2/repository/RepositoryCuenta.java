package com.mx.openbank.i2.repository;

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
	String  getClabeInterbancaria(@Param("account") String numeroCuenta);

}
